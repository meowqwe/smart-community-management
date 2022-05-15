package com.zzl.smartcommunitymanagement.controller;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmProblem;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
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
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public PageResult findAll(@RequestBody Map searchMap) {
        Page<ScmProblem> all = scmProblemService.findAll(searchMap);
        if (all.isEmpty()) {
            return new PageResult(false, StatusCode.ERROR, "获取失败",null, 0l);
        }
        return new PageResult(true, StatusCode.OK,null,all,all.getTotal());
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
        return new PageResult(true,StatusCode.OK,null,search, search.getTotal());
    }

    /**
     * 添加问题
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/addProblem")
    @ResponseBody
    public Result addProblem(HttpSession session, @RequestBody Map request) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        String name = "";
        String solution = "";
        if (StringUtil.isNotEmpty((String) request.get("name"))) {
            name = (String) request.get("name");
        }
        if (StringUtil.isNotEmpty((String) request.get("solution"))) {
            solution = (String) request.get("solution");
        }
        ScmProblem problem = new ScmProblem();
        LocalDateTime now = LocalDateTime.now();
        problem.setCTime(now);
        problem.setCId(user.getUId());
        problem.setPName(name);
        problem.setPSolution(solution);
        problem.setUTime(now);
        problem.setUId(user.getUId());
        scmProblemService.addProblem(problem);
        return new Result(true, StatusCode.OK, "添加成功！");
    }

    /**
     * 删除问题
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteProblem", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteProblem(@RequestBody Map request) {
        int pid = -1;
        if (StringUtil.isNotEmpty(String.valueOf(request.get("pid")))) {
            pid = (Integer) request.get("pid");
        }
        if (pid == -1) {
            return new Result(false, StatusCode.ERROR, "删除失败！");
        }
        scmProblemService.deleteProblem(pid);
        return new Result(true, StatusCode.OK, "删除成功!");
    }
}
