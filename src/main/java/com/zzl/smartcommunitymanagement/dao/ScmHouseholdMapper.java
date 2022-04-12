package com.zzl.smartcommunitymanagement.dao;

import com.zzl.smartcommunitymanagement.domain.ScmHousehold;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ScmHouseholdMapper extends Mapper<ScmHousehold> {

    @Select("select h.* from SCM_Household h, SCM_User u where h.h_id = u.h_id")
    public ScmHousehold findByUserId(Integer uid);
}
