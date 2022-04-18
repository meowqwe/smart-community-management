package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmUser;

import java.util.List;
import java.util.Map;

public interface ScmUserService {
    /**
     * 根据用户名和密码查找
     */
    public ScmUser findByNameAndPassword(String name,String password);

    /**
     * 根据用户名称查找
     * name pageNum pageSize
     */
    public Page<ScmUser> searchByName(Map searchMap);
}
