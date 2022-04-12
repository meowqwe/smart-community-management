package com.zzl.smartcommunitymanagement.service;

import com.zzl.smartcommunitymanagement.domain.ScmHousehold;

import java.util.List;

/**
 * @author zzl
 * @desc 物业费服务层
 */
public interface ScmHouseholdService {
    /**
     * 根据用户id连表查询一个住户
     */
    public ScmHousehold findHouseholdByUserId(Integer uid);

    /**
     * 更新住户信息
     */
    public void updateHousehold(ScmHousehold household);

    /**
     * 根据主键查询住户信息
     */
    public ScmHousehold findById(Integer hid);

    /**
     * 查询所有
     */
    public List<ScmHousehold> findAll();
}
