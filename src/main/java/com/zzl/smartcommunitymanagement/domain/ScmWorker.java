package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 服务人员
 */
@Table(name="SCM_Worker")
public class ScmWorker implements Serializable,Cloneable{
    /** 工号 */
    @Id
    @GeneratedValue
    private Integer wId ;
    /** 姓名 */
    private String wName ;
    /** 性别 */
    private String wGender ;
    /** 联系方式 */
    private String wContact ;

    /** 工号 */
    public Integer getWId(){
        return this.wId;
    }
    /** 工号 */
    public void setWId(Integer wId){
        this.wId=wId;
    }
    /** 姓名 */
    public String getWName(){
        return this.wName;
    }
    /** 姓名 */
    public void setWName(String wName){
        this.wName=wName;
    }
    /** 性别 */
    public String getWGender(){
        return this.wGender;
    }
    /** 性别 */
    public void setWGender(String wGender){
        this.wGender=wGender;
    }
    /** 联系方式 */
    public String getWContact(){
        return this.wContact;
    }
    /** 联系方式 */
    public void setWContact(String wContact){
        this.wContact=wContact;
    }
}