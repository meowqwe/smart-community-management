package com.zzl.smartcommunitymanagement.service.impl;

import com.zzl.smartcommunitymanagement.dao.ScmCarportMapper;
import com.zzl.smartcommunitymanagement.domain.ScmCarport;
import com.zzl.smartcommunitymanagement.service.ScmCarportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScmCarportServiceImpl implements ScmCarportService {

    @Autowired
    private ScmCarportMapper scmCarportMapper;

    @Override
    public List<ScmCarport> findByHid(Integer hid) {
        Example example = new Example(ScmCarport.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("hId",hid);
        return scmCarportMapper.selectByExample(criteria);
    }

    @Override
    public ScmCarport findById(Integer cid) {
        return scmCarportMapper.selectByPrimaryKey(cid);
    }

    @Override
    public Integer update(ScmCarport carport) {
        return scmCarportMapper.updateByPrimaryKey(carport);
    }
}
