package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 社区服务信息
 */
@Table(name="SCM_CommunityService")
public class ScmCommunityService implements Serializable,Cloneable{
    /** 服务号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId ;
    /** 服务项目名 */
    private String sName ;
    /** 创建人 */
    private Integer cId ;
    /** 创建时间 */
    private Date cTime ;
    /** 更新人 */
    private String uId ;
    /** 更新时间 */
    private Date uTime ;
    /** 状态;是否解决 */
    private String sState ;

    /** 服务号 */
    public Integer getSId(){
        return this.sId;
    }
    /** 服务号 */
    public void setSId(Integer sId){
        this.sId=sId;
    }
    /** 服务项目名 */
    public String getSName(){
        return this.sName;
    }
    /** 服务项目名 */
    public void setSName(String sName){
        this.sName=sName;
    }
    /** 创建人 */
    public Integer getCId(){
        return this.cId;
    }
    /** 创建人 */
    public void setCId(Integer cId){
        this.cId=cId;
    }
    /** 创建时间 */
    public Date getCTime(){
        return this.cTime;
    }
    /** 创建时间 */
    public void setCTime(Date cTime){
        this.cTime=cTime;
    }
    /** 更新人 */
    public String getUId(){
        return this.uId;
    }
    /** 更新人 */
    public void setUId(String uId){
        this.uId=uId;
    }
    /** 更新时间 */
    public Date getUTime(){
        return this.uTime;
    }
    /** 更新时间 */
    public void setUTime(Date uTime){
        this.uTime=uTime;
    }
    /** 状态;是否解决 */
    public String getSState(){
        return this.sState;
    }
    /** 状态;是否解决 */
    public void setSState(String sState){
        this.sState=sState;
    }
}
