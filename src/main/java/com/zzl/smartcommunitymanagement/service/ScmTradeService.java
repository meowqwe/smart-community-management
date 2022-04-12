package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmTrade;

import java.util.List;

public interface ScmTradeService {

    /**
     * 添加闲置交易信息
     * @param trade
     */
    public Integer addTrade(ScmTrade trade);

    /**
     * 根据id删除闲置交易信息
     * @param id
     */
    public Integer deleteById(Integer id);

    /**
     * 查询所有可用交易
     * @return
     */
    public Page<ScmTrade> findAllActive(Integer pageNum,Integer pageSize);

}
