package com.zzl.smartcommunitymanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzl.smartcommunitymanagement.dao.ScmRentMapper;
import com.zzl.smartcommunitymanagement.domain.ScmRent;
import com.zzl.smartcommunitymanagement.domain.ScmTrade;
import com.zzl.smartcommunitymanagement.service.ScmRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Map;

@Service
public class ScmRentServiceImpl implements ScmRentService {

    @Autowired
    ScmRentMapper scmRentMapper;

    @Override
    public Integer addRent(ScmRent rent) {
        return scmRentMapper.insert(rent);
    }

    @Override
    public Integer deleteRentById(Integer rid) {
        return scmRentMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public Page<ScmRent> search(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmTrade.class);
        if (searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String)searchMap.get("startPrice"))){
                criteria.andGreaterThanOrEqualTo("rPrice", Double.parseDouble((String)searchMap.get("startPrice")));
            }
            if (StringUtil.isNotEmpty((String)searchMap.get("endPrice"))){
                criteria.andLessThanOrEqualTo("rPrice", Double.parseDouble((String)searchMap.get("endPrice")));
            }
            if (StringUtil.isNotEmpty((String)searchMap.get("startTime"))){
                criteria.andGreaterThanOrEqualTo("rTime", Double.parseDouble((String)searchMap.get("startPrice")));
            }
            if (StringUtil.isNotEmpty((String)searchMap.get("endTime"))){
                criteria.andLessThanOrEqualTo("rTime", Double.parseDouble((String)searchMap.get("endPrice")));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))) {
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<ScmRent>) scmRentMapper.selectByExample(example);
    }

    @Override
    public Page<ScmRent> findAllActive(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmRent.class);
        if (searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))) {
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
            criteria.andEqualTo("rState","1");
        }
        PageHelper.startPage(pageNum, pageSize);
        Page<ScmRent> result = (Page<ScmRent>) scmRentMapper.selectByExample(example);
        return result;
    }

    @Override
    public Page<ScmRent> findByUserId(Integer uid, Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmTrade.class);
        if (searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
            criteria.andEqualTo("cId", uid);
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<ScmRent>) scmRentMapper.selectByExample(example);
    }

}
