package com.zzl.smartcommunitymanagement.controller;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmCommunityService;
import com.zzl.smartcommunitymanagement.domain.ScmWorker;
import com.zzl.smartcommunitymanagement.service.ScmServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Service")
public class ScmServiceController {

    @Autowired
    private ScmServiceService scmServiceService;

    /**
     * 查询所有
     * @param searchMap
     * pageNum pageSize
     * @return
     */
    public PageResult findAll(@RequestBody Map searchMap) {
        Page<ScmCommunityService> all = scmServiceService.findAll(searchMap);
        if (all.isEmpty()) {
            return new PageResult(false, StatusCode.ERROR, "查询失败", null, 0l);
        }
        return new PageResult(true, StatusCode.OK, "请求成功", all, all.getTotal());
    }

    /**
     * 根据名称模糊查询
     * @param searchMap
     * @return
     */
    public PageResult search(@RequestBody Map searchMap) {
        Page<ScmCommunityService> all = scmServiceService.search(searchMap);
        if (all.isEmpty()) {
            return new PageResult(false, StatusCode.ERROR, "查询失败", null, 0l);
        }
        return new PageResult(true, StatusCode.OK, "请求成功", all, all.getTotal());
    }

    /**
     * 根据服务id查询对应工作人员
     * @param request
     * @return
     */
    public Result findWorker(@RequestBody Map request) {
        if (StringUtil.isEmpty((String) request.get("id"))) {
            return new Result(false, StatusCode.ERROR, "缺少服务id");
        }
        List<ScmWorker> workers = scmServiceService.findWorker(Integer.parseInt((String) request.get("id")));
        if (workers.isEmpty()) {
            return new Result(false, StatusCode.ERROR, "查询失败");
        }
        return new Result(true, StatusCode.OK, "请求成功", workers);
    }

}
