package com.zzl.smartcommunitymanagement.service;

import com.zzl.smartcommunitymanagement.domain.ScmHousehold;

/**
 * @author zzl
 * @desc 物业费服务层
 */
public interface ScmManagementFeeService {
    /**
     * 根据用户id连表查询一个住户
     */
    public ScmHousehold findHouseholdByUserId(Integer uid);

    /**
     * 根据id更新住户信息
     */
    public ScmHousehold updateHouseholdById(Integer hid);
}
