package com.zzl.smartcommunitymanagement.service.impl;

import com.zzl.smartcommunitymanagement.dao.ScmHouseholdMapper;
import com.zzl.smartcommunitymanagement.domain.ScmHousehold;
import com.zzl.smartcommunitymanagement.service.ScmHouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScmHouseholdServiceImpl implements ScmHouseholdService {

    @Autowired
    private ScmHouseholdMapper scmhouseholdMapper;

    @Override
    public ScmHousehold findHouseholdByUserId(Integer uid) {
        return scmhouseholdMapper.findByUserId(uid);
    }

    @Override
    public Integer updateHousehold(ScmHousehold household) {
        return scmhouseholdMapper.updateByPrimaryKey(household);
    }

    @Override
    public ScmHousehold findById(Integer hid) {
        return scmhouseholdMapper.selectByPrimaryKey(hid);
    }

    @Override
    public List<ScmHousehold> findAll() {
        return scmhouseholdMapper.selectAll();
    }

}
