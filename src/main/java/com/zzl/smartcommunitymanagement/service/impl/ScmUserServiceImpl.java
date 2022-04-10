package com.zzl.smartcommunitymanagement.service.impl;

import com.zzl.smartcommunitymanagement.dao.ScmUserMapper;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
@Service
public class ScmUserServiceImpl implements ScmUserService {

    @Autowired
    private ScmUserMapper scmUserMapper;

    @Override
    public ScmUser findByNameAndPassword(String name, String password) {
        Example example = new Example(ScmUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uName",name);
        criteria.andEqualTo("uPassword",password);
        ScmUser user = scmUserMapper.selectOneByExample(example);
        return user;
    }

    @Override
    public List<ScmUser> searchByName(String name) {
        Example example = new Example(ScmUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("uName","%" + name + "%");
        List<ScmUser> list = scmUserMapper.selectByExample(example);
        return null;
    }
}
