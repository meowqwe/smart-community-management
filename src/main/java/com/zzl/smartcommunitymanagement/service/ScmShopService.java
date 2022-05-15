package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmShop;

import java.util.Map;

public interface ScmShopService {
    /**
     * 查询所有社区问题
     * @param searchMap
     * pageNum pageSize
     * @return
     */
    public Page<ScmShop> findAll(Map searchMap);

    /**
     * 根据名称模糊查找
     * @param searchMap
     * name pageNum pageSize
     * @return
     */
    public Page<ScmShop> search(Map searchMap);

    /**
     * 新增问题
     * @param shop
     * @return
     */
    public Integer addShop(ScmShop shop);

    /**
     * 删除问题
     * @param shid
     * @return
     */
    public Integer deleteShop(Integer shid);
}
