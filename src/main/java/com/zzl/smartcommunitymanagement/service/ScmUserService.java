package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import org.apache.catalina.User;

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

    /**
     * 根据用户更新
     * @param user
     * @return
     */
    public Integer updateUser(ScmUser user);

    /**
     * 查询所有
     * @param request
     * @return
     */
    Page<ScmUser> findAll(Map request);
}
