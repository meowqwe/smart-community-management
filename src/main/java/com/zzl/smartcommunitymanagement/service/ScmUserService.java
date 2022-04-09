package com.zzl.smartcommunitymanagement.service;

import com.zzl.smartcommunitymanagement.domain.ScmUser;

import java.util.List;

public interface ScmUserService {
    /**
     * 根据用户名和密码查找
     */
    public ScmUser findByNameAndPassword(String name,String password);
    /**
     * 根据用户名称查找
     */
    public List<ScmUser> searchByName(String name);
}
