package com.zzl.smartcommunitymanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzl.smartcommunitymanagement.dao.ScmUserMapper;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public Page<ScmUser> searchByName(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmUser.class);
        if (searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("uName","%" + (String) searchMap.get("name") + "%");
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        return (Page<ScmUser>) scmUserMapper.selectByExample(example);
    }
}
