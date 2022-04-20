package com.zzl.smartcommunitymanagement.service;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.domain.ScmProblem;

import java.util.Map;

public interface ScmProblemService {

    /**
     * 查询所有社区问题
     * @param searchMap
     * pageNum pageSize
     * @return
     */
    public Page<ScmProblem> findAll(Map searchMap);

    /**
     * 根据名称模糊查找
     * @param searchMap
     * name pageNum pageSize
     * @return
     */
    public Page<ScmProblem> search(Map searchMap);

}
