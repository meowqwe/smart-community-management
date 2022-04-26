package com.zzl.smartcommunitymanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzl.smartcommunitymanagement.dao.ScmProblemMapper;
import com.zzl.smartcommunitymanagement.domain.ScmProblem;
import com.zzl.smartcommunitymanagement.service.ScmProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class ScmProblemServiceImpl implements ScmProblemService {

    @Autowired
    private ScmProblemMapper scmProblemMapper;

    @Override
    public Page<ScmProblem> findAll(Map searchMap) {

        int pageNum = 1;
        int pageSize = 10;
        if (searchMap != null){
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ScmProblem> problems = scmProblemMapper.selectAll();
        return (Page<ScmProblem>) problems;
    }

    @Override
    public Page<ScmProblem> search(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmProblem.class);
        if (searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("pName", "%" + (String) searchMap.get("name") + "%");
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<ScmProblem>) scmProblemMapper.selectByExample(example);
    }

    @Override
    public Integer addProblem(ScmProblem problem) {
        return scmProblemMapper.insert(problem);
    }

    @Override
    public Integer deleteProblem(Integer pid) {
        return scmProblemMapper.deleteByPrimaryKey(pid);
    }
}
