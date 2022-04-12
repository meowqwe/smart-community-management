package com.zzl.smartcommunitymanagement.controller;

import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmCarport;
import com.zzl.smartcommunitymanagement.domain.ScmHousehold;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmCarportService;
import com.zzl.smartcommunitymanagement.service.ScmHouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zzl
 * @desc 车位管理层
 */
@RestController
@RequestMapping("/carport")
public class ScmCarportController {

    @Autowired
    private ScmCarportService scmCarportService;
    @Autowired
    private ScmHouseholdService scmHouseholdService;

    /**
     * 根据当前登录用户查询其所属住户的所有车位
     * @param session
     * @return
     */
    @RequestMapping("/findByUser")
    @ResponseBody
    public PageResult findByUser(HttpSession session) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        ScmHousehold household = scmHouseholdService.findById(user.getHId());
        if (household == null)
        {
            return new PageResult(false, StatusCode.ERROR,"目前没有绑定住户", null,0l);
        }
        List<ScmCarport> carports = scmCarportService.findByHid(household.getHId());
        return new PageResult(true,StatusCode.OK,"请求成功",carports, (long) carports.size());
    }

}
