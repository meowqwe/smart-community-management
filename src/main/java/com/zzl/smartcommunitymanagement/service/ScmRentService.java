package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmRent;

import java.util.Map;

public interface ScmRentService {

    /**
     * 添加租房信息
     * @param rent
     */
    public Integer addRent(ScmRent rent);

    /**
     * 删除租房信息
     * @param rid
     * @return
     */
    public Integer deleteRentById(Integer rid);

    /**
     * 查询租房信息
     * @param searchMap
     * startPrice endPrice startTime endTime 分页信息
     * @return
     */
    public Page<ScmRent> search(Map searchMap);

    /**
     * 查询所有可用
     * @param searchMap
     * 分页信息
     * @return
     */
    public Page<ScmRent> findAllActive(Map searchMap);

    /**
     * 根据用户id查询所有
     * @param uid
     * @param searchMap
     * 分页信息
     * @return
     */
    public Page<ScmRent> findByUserId(Integer uid, Map searchMap);

}
