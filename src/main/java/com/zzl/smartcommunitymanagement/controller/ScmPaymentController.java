package com.zzl.smartcommunitymanagement.controller;

import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.ScmBillType;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmBill;
import com.zzl.smartcommunitymanagement.domain.ScmCarport;
import com.zzl.smartcommunitymanagement.domain.ScmHousehold;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmBillService;
import com.zzl.smartcommunitymanagement.service.ScmCarportService;
import com.zzl.smartcommunitymanagement.service.ScmHouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @desc 用户缴费控制层
 */
@Controller
@RequestMapping("/pay")
public class ScmPaymentController {

    @Autowired
    private ScmHouseholdService scmHouseholdService;

    @Autowired
    private ScmBillService scmBillService;

    @Autowired
    private ScmCarportService scmCarportService;

    @RequestMapping("/managementfee")
    @ResponseBody
    public Result managementFee(HttpSession session) {
        // 获取当前登录用户
        ScmUser user = (ScmUser) session.getAttribute("user");
        int uid = user.getUId();
        int hid = user.getHId();
        // 获取当前用户所在住户
        ScmHousehold household = scmHouseholdService.findById(hid);
        if (household == null){
            return new Result(false,StatusCode.ERROR,"目前没有绑定住户");
        }
        // 更新下次到期时间
        Date now = new Date();
        Date base = household.getHTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(base);
        calendar.add(Calendar.MONTH,+1);
        household.setHTime(calendar.getTime());
        // 修改缴费状态
        if (household.getHState().equals("0")  && household.getHTime().after(now)) {
            household.setHState("1");
        }
        // 创建账单
        ScmBill bill = new ScmBill();
        bill.setCId(uid);
        bill.setBState("1");
        bill.setBTotal(household.getHArea() * household.getHManagementfee());
        bill.setBType(ScmBillType.ManagementFee);
        bill.setTId(hid);
        bill.setCTime(now);
        // 保存账单
        scmBillService.addBill(bill);
        // 更新住户信息
        scmHouseholdService.updateHousehold(household);
        return new Result(true, StatusCode.OK, "缴费成功");
    }

    @RequestMapping("/updateHousehold")
    @ResponseBody
    public Result updateHouseholdState() {
        List<ScmHousehold> all = scmHouseholdService.findAll();
        for (ScmHousehold h : all) {
            // 如果过期则更新状态为未交
            if (h.getHState() == "1" && h.getHTime().before(new Date())) {
                h.setHState("0");
                scmHouseholdService.updateHousehold(h);
            }
        }
        return new Result(true, StatusCode.OK,"更新成功");
    }

    @RequestMapping("/carportfee")
    @ResponseBody
    public Result carportFee(HttpSession session,@RequestBody Map<String, Integer> request) {
        // 获取当前登录用户
        ScmUser user = (ScmUser) session.getAttribute("user");
        int uid = user.getUId();
        int cid = 0;
        if (request.get("cid") != null)
        {
            cid = request.get("cid");
        }
        // 获取待缴费车位
        ScmCarport carport = scmCarportService.findById(cid);
        // 更新下次到期时间
        Date now = new Date();
        Date base = carport.getExTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(base);
        calendar.add(Calendar.MONTH,+1);
        carport.setExTime((calendar.getTime()));
        // 创建账单
        ScmBill bill = new ScmBill();
        bill.setCId(uid);
        bill.setBState("1");
        bill.setBTotal(carport.getCpRent());
        bill.setBType(ScmBillType.CarportFee);
        bill.setTId(carport.getCpId());
        bill.setCTime(now);
        // 保存账单
        scmBillService.addBill(bill);
        // 更新车位信息
        scmCarportService.update(carport);
        return new Result(true, StatusCode.OK, "缴费成功");
    }

}
