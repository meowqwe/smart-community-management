package com.zzl.smartcommunitymanagement.controller;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmRent;
import com.zzl.smartcommunitymanagement.domain.ScmTrade;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmHouseholdService;
import com.zzl.smartcommunitymanagement.service.ScmRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/rent")
public class ScmRentController {

    @Autowired
    private ScmRentService scmRentService;

    @Autowired
    private ScmHouseholdService scmHouseholdService;

    /**
     * 创建一个未审核的租房信息
     * @param session
     * @param request
     * @return Result
     */
    @RequestMapping("/create")
    @ResponseBody
    public Result createRent(HttpSession session, @RequestBody Map request) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        LocalDateTime now = LocalDateTime.now();
        ScmRent rent = new ScmRent();
        rent.setCId(user.getUId());
        rent.setCTime(now);
        rent.setRState("0");
        if (scmHouseholdService.findHouseholdByUserId(user.getUId()) == null) {
            return new Result(false, StatusCode.ERROR,"当前用户无住户，创建失败");
        }
        rent.setHId(scmHouseholdService.findHouseholdByUserId(user.getUId()).getHId());
        if (StringUtil.isEmpty((String) request.get("price"))) {
            return new Result(false,StatusCode.ERROR,"租房价格缺失，创建失败");
        }
        rent.setRPrice(Double.parseDouble((String) request.get("price")));
        if (StringUtil.isEmpty((String) request.get("time"))) {
            return new Result(false,StatusCode.ERROR,"租房时间缺失，创建失败");
        }
        rent.setRTime(LocalDateTime.parse((String) request.get("time")));
        rent.setRPicture((String) request.get("picture"));
        rent.setRDescription((String) request.get("description"));
        rent.setRPrice(Double.valueOf((String) request.get("price")));
        rent.setRContact((String) request.get("contact"));
        scmRentService.addRent(rent);
        return new Result(true, StatusCode.OK,"创建成功，请等待审核!");
    }

    /**
     * 删除租房信息
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteRent(@RequestBody Map request) {
        if (StringUtil.isEmpty((String) request.get("id"))) {
            return new Result(false,StatusCode.ERROR,"删除失败！");
        }
        int id = Integer.parseInt((String) request.get("id"));
        scmRentService.deleteRentById(id);
        return new Result(true, StatusCode.OK,"删除成功！");
    }

    /**
     * 用户浏览所有可用的租房信息
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public PageResult findAll(@RequestBody Map searchMap) {
        Page<ScmRent> allActive = scmRentService.findAllActive(searchMap);
        return new PageResult(true,StatusCode.OK,"查询成功！",allActive, (long) allActive.size());
    }

    /**
     * 用户按条件筛选租房信息
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Map searchMap) {
        Page<ScmRent> trades = scmRentService.search(searchMap);
        return new PageResult(true,StatusCode.OK,"查询成功！",trades,(long) trades.size());
    }

    /**
     * 根据当前用户查找交易信息
     * @param session
     * @param searchMap
     * @return
     */
    @RequestMapping("/userTrade")
    @ResponseBody
    public PageResult userTrade(HttpSession session, @RequestBody Map searchMap) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        int uid = user.getUId();
        Page<ScmRent> trades = scmRentService.findByUserId(uid, searchMap);
        return new PageResult(true, StatusCode.OK, "查询成功！", trades, (long) trades.size());
    }

}
