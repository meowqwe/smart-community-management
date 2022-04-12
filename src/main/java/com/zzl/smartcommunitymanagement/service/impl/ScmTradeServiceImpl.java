package com.zzl.smartcommunitymanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzl.smartcommunitymanagement.dao.ScmTradeMapper;
import com.zzl.smartcommunitymanagement.domain.ScmTrade;
import com.zzl.smartcommunitymanagement.service.ScmTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
    public Page<ScmTrade> findAllActive(Integer pageNum,Integer pageSize) {
        Example example = new Example(ScmTrade.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tState","1");
        PageHelper.startPage(pageNum, pageSize);
        Page<ScmTrade> result = (Page<ScmTrade>) scmTradeMapper.selectByExample(example);
        return result;
    }


}
