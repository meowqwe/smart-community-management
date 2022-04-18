package com.zzl.smartcommunitymanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzl.smartcommunitymanagement.dao.ScmTradeMapper;
import com.zzl.smartcommunitymanagement.domain.ScmTrade;
import com.zzl.smartcommunitymanagement.service.ScmTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class ScmTradeServiceImpl implements ScmTradeService {

    @Autowired
    private ScmTradeMapper scmTradeMapper;

    @Override
    public Integer addTrade(ScmTrade trade) {
        return scmTradeMapper.insert(trade);
    }

    @Override
    public Integer deleteById(Integer id) {
        Example example = new Example(ScmTrade.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tId",id);
        return scmTradeMapper.deleteByExample(example);
    }

    @Override
    public Page<ScmTrade> findAllActive(Map searchMap) {
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
            criteria.andEqualTo("tState","1");
        }
        PageHelper.startPage(pageNum, pageSize);
        Page<ScmTrade> result = (Page<ScmTrade>) scmTradeMapper.selectByExample(example);
        return result;
    }

    @Override
    public Page<ScmTrade> search(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmTrade.class);
        if (searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String)searchMap.get("name"))){
                criteria.andLike("tName", "%" + (String)searchMap.get("name") + "%");
            }
            if (StringUtil.isNotEmpty((String)searchMap.get("startPrice"))){
                criteria.andGreaterThanOrEqualTo("tPrice", Double.parseDouble((String)searchMap.get("startPrice")));
            }
            if (StringUtil.isNotEmpty((String)searchMap.get("endPrice"))){
                criteria.andLessThanOrEqualTo("tPrice", Double.parseDouble((String)searchMap.get("endPrice")));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<ScmTrade>) scmTradeMapper.selectByExample(example);
    }

    @Override
    public Page<ScmTrade> findByUserId(Integer uid, Map searchMap) {
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
        return (Page<ScmTrade>) scmTradeMapper.selectByExample(example);
    }


}
