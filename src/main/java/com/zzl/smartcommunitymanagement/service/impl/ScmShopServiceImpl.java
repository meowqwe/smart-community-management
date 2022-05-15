package com.zzl.smartcommunitymanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzl.smartcommunitymanagement.dao.ScmShopMapper;
import com.zzl.smartcommunitymanagement.domain.ScmShop;
import com.zzl.smartcommunitymanagement.service.ScmShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class ScmShopServiceImpl implements ScmShopService {

    @Autowired
    private ScmShopMapper scmShopMapper;

    @Override
    public Page<ScmShop> findAll(Map searchMap) {
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
        List<ScmShop> problems = scmShopMapper.selectAll();
        return (Page<ScmShop>) problems;
    }

    @Override
    public Page<ScmShop> search(Map searchMap) {
        int pageNum = 1;
        int pageSize = 10;
        Example example = new Example(ScmShop.class);
        if (searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("shName", "%" + (String) searchMap.get("name") + "%");
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("class"))){
                criteria.andLike("shClass", "%" +(String) searchMap.get("class") + "%");
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<ScmShop>) scmShopMapper.selectByExample(example);
    }

    @Override
    public Integer addShop(ScmShop shop) {
        return scmShopMapper.insert(shop);
    }

    @Override
    public Integer deleteShop(Integer shid) {
        return scmShopMapper.deleteByPrimaryKey(shid);
    }
}
