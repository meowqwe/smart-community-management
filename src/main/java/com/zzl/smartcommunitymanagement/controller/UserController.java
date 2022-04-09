package com.zzl.smartcommunitymanagement.controller;

import com.zzl.smartcommunitymanagement.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzl
 * @Desc 用户管理层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/find")
    public Result find(){
        return new Result(false, 200, "请求成功");
    }
}
