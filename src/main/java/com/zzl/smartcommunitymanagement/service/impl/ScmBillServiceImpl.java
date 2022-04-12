package com.zzl.smartcommunitymanagement.service.impl;

import com.zzl.smartcommunitymanagement.dao.ScmBillMapper;
import com.zzl.smartcommunitymanagement.domain.ScmBill;
import com.zzl.smartcommunitymanagement.service.ScmBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScmBillServiceImpl implements ScmBillService {

    @Autowired
    private ScmBillMapper scmBillMapper;

    @Override
    public Integer addBill(ScmBill bill) {
        return scmBillMapper.insert(bill);
    }
}
