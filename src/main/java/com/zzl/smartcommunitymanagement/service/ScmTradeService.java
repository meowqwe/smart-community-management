package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmTrade;

import java.util.List;
import java.util.Map;

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
     * pageNum pageSize
     * @return
     */
    public Page<ScmTrade> findAllActive(Map searchMap);

    /**
     * 根据条件查询
     * @param searchMap
     * name pageNum pageSize startPrice endPrice
     * @return
     */
    public Page<ScmTrade> search(Map searchMap);

    /**
     * 根据用户id查询
     * @param searchMap
     * pageNum pageSize
     * @return
     */
    public Page<ScmTrade> findByUserId(Integer uid, Map searchMap);

}
