package com.zzl.smartcommunitymanagement.service.impl;

import com.zzl.smartcommunitymanagement.dao.ScmUserMapper;
import com.zzl.smartcommunitymanagement.domain.ScmHousehold;
import com.zzl.smartcommunitymanagement.service.ScmManagementFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScmManagementFeeServiceImpl implements ScmManagementFeeService {

    @Autowired
    private ScmUserMapper scmUserMapper;



    @Override
    public ScmHousehold findHouseholdByUserId(Integer uid) {
        return null;
    }

    @Override
    public ScmHousehold updateHouseholdById(Integer hid) {
        return null;
    }
}
