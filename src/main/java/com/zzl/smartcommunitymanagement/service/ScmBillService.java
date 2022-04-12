package com.zzl.smartcommunitymanagement.service;

import com.zzl.smartcommunitymanagement.domain.ScmBill;

/**
 * @author zzl
 * @desc 账单服务层
 */
public interface ScmBillService {
    /**
     * 添加一个账单
     */
    public void addBill(ScmBill bill);
}
