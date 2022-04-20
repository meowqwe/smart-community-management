package com.zzl.smartcommunitymanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzl.smartcommunitymanagement.dao.ScmCommunityServiceMapper;
import com.zzl.smartcommunitymanagement.dao.ScmServiceWorkerMapper;
import com.zzl.smartcommunitymanagement.dao.ScmWorkerMapper;
import com.zzl.smartcommunitymanagement.domain.ScmCommunityService;
import com.zzl.smartcommunitymanagement.domain.ScmServiceWorker;
import com.zzl.smartcommunitymanagement.domain.ScmWorker;
import com.zzl.smartcommunitymanagement.service.ScmServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class ScmServiceServiceImpl implements ScmServiceService {

    @Autowired
    private ScmCommunityServiceMapper scmCommunityServiceMapper;

    @Autowired
    private ScmWorkerMapper scmWorkerMapper;

    @Autowired
    private ScmServiceWorkerMapper scmServiceWorkerMapper;

    @Override
    public Page<ScmCommunityService> findAll(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmCommunityService.class);
        if (searchMap != null) {
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String)searchMap.get("pageNum"))) {
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))) {
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
            criteria.andEqualTo("sState", "1");
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<ScmCommunityService>) scmCommunityServiceMapper.selectByExample(example);
    }

    @Override
    public Page<ScmCommunityService> search(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmCommunityService.class);
        if (searchMap != null) {
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String)searchMap.get("pageNum"))) {
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))) {
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                criteria.andLike("sName", "%" + searchMap.get("name") +"%");
            }
            criteria.andEqualTo("sState", "1");
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<ScmCommunityService>) scmCommunityServiceMapper.selectByExample(example);
    }

    @Override
    public List<ScmWorker> findWorker(Integer sid) {
        Example example = new Example(ScmCommunityService.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sId", sid);
        List<ScmServiceWorker> scmServiceWorkers = scmServiceWorkerMapper.selectByExample(example);
        List<ScmWorker> workers = null;
        for (ScmServiceWorker sw : scmServiceWorkers) {
            ScmWorker worker = scmWorkerMapper.selectByPrimaryKey(sw.getWId());
            if (worker != null) {
                workers.add(worker);
            }
        }
        return workers;
    }
}
