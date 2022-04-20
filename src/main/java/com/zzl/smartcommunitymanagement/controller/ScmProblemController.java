package com.zzl.smartcommunitymanagement.controller;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmProblem;
import com.zzl.smartcommunitymanagement.service.ScmProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/problem")
public class ScmProblemController {

    @Autowired
    private ScmProblemService scmProblemService;

    /**
     * 查询所有
     * @param searchMap
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public PageResult findAll(@RequestBody Map searchMap) {
        Page<ScmProblem> all = scmProblemService.findAll(searchMap);
        if (all.isEmpty()) {
            return new PageResult(false, StatusCode.ERROR, "获取失败",null, 0l);
        }
        return new PageResult(true, StatusCode.OK,"请求成功",all,(long) all.size());
    }

    /**
     * 根据名称模糊查询
     * @param searchMap
     * @return
     */
    @RequestMapping("/findByName")
    @ResponseBody
    public PageResult findByName(@RequestBody Map searchMap) {
        Page<ScmProblem> search = scmProblemService.search(searchMap);
        if (search.isEmpty()) {
            return new PageResult(false, StatusCode.ERROR, "获取失败",null, 0l);
        }
        return new PageResult(true,StatusCode.OK,"请求成功",search, (long) search.size());
    }

}
