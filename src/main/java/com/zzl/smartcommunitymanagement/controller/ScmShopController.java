package com.zzl.smartcommunitymanagement.controller;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmShop;
import com.zzl.smartcommunitymanagement.service.ScmShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ScmShopController {

    @Autowired
    private ScmShopService scmShopService;

    /**
     * 查询所有
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public PageResult findAll(@RequestBody Map searchMap) {
        Page<ScmShop> all = scmShopService.findAll(searchMap);
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
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Map searchMap) {
        Page<ScmShop> search = scmShopService.search(searchMap);
        if (search.isEmpty()) {
            return new PageResult(false, StatusCode.ERROR, "获取失败",null, 0l);
        }
        return new PageResult(true,StatusCode.OK,null,search, search.getTotal());
    }

    /**
     * 添加问题
     * @param request
     * @return
     */
    @RequestMapping("/addShop")
    @ResponseBody
    public Result addProblem(@RequestBody Map request) {
        String name = "";
        String description = "";
        String shopClass = "";
        if (StringUtil.isNotEmpty((String) request.get("name"))) {
            name = (String) request.get("name");
        }
        if (StringUtil.isNotEmpty((String) request.get("description"))) {
            description = (String) request.get("description");
        }
        if (StringUtil.isNotEmpty((String) request.get("class"))) {
            shopClass = (String) request.get("class");
        }
        ScmShop shop = new ScmShop();
        shop.setShName(name);
        shop.setShClass(shopClass);
        shop.setShDescription(description);
        scmShopService.addShop(shop);
        return new Result(true, StatusCode.OK, "添加成功！");
    }

    /**
     * 删除问题
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteShop", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteProblem(@RequestBody Map request) {
        int shid = -1;
        if (StringUtil.isNotEmpty(String.valueOf(request.get("pid")))) {
            shid = (Integer) request.get("shid");
        }
        if (shid == -1) {
            return new Result(false, StatusCode.ERROR, "删除失败！");
        }
        scmShopService.deleteShop(shid);
        return new Result(true, StatusCode.OK, "删除成功!");
    }

}
