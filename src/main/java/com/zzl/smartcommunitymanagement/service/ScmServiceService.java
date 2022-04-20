package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmCommunityService;
import com.zzl.smartcommunitymanagement.domain.ScmWorker;

import java.util.List;
import java.util.Map;

public interface ScmServiceService {

    /**
     * 查询所有
     * @param searchMap
     * pageNum pageSize
     * @return
     */
    public Page<ScmCommunityService> findAll(Map searchMap);

    /**
     * 根据名称模糊查询
     * @param searchMap
     * @return
     */
    public Page<ScmCommunityService> search(Map searchMap);

    /**
     * 根据服务id查询对应工作人员
     * @param sid
     * @return
     */
    public List<ScmWorker> findWorker(Integer sid);

}
