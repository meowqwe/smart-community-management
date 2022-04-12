package com.zzl.smartcommunitymanagement.service;

import com.zzl.smartcommunitymanagement.domain.ScmCarport;

import java.util.List;

public interface ScmCarportService {
    /**
     * 根据住户id找车位
     * @param hid
     */
    public List<ScmCarport> findByHid(Integer hid);

    /**
     * 根据id查找
     * @param cid
     * @return
     */
    public ScmCarport findById(Integer cid);

    /**
     * 更新
     * @param carport
     */
    public Integer update(ScmCarport carport);
}
