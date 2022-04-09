package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 住户
 */
@Table(name="SCM_Household")
public class ScmHousehold implements Serializable,Cloneable{
    /** 住户号 */
    @Id
    @GeneratedValue
    private Integer hId ;
    /** 楼号 */
    private Integer hBulding ;
    /** 门牌号 */
    private Integer hNumber ;
    /** 房屋面积 */
    private Double hArea ;
    /** 物业费 */
    private Double hManagementfee ;
    /** 物业费状态;是否已交物业费 */
    private String hState ;
    /** 更新时间 */
    private Date hTime ;

    /** 住户号 */
    public Integer getHId(){
        return this.hId;
    }
    /** 住户号 */
    public void setHId(Integer hId){
        this.hId=hId;
    }
    /** 楼号 */
    public Integer getHBulding(){
        return this.hBulding;
    }
    /** 楼号 */
    public void setHBulding(Integer hBulding){
        this.hBulding=hBulding;
    }
    /** 门牌号 */
    public Integer getHNumber(){
        return this.hNumber;
    }
    /** 门牌号 */
    public void setHNumber(Integer hNumber){
        this.hNumber=hNumber;
    }
    /** 房屋面积 */
    public Double getHArea(){
        return this.hArea;
    }
    /** 房屋面积 */
    public void setHArea(Double hArea){
        this.hArea=hArea;
    }
    /** 物业费 */
    public Double getHManagementfee(){
        return this.hManagementfee;
    }
    /** 物业费 */
    public void setHManagementfee(Double hManagementfee){
        this.hManagementfee=hManagementfee;
    }
    /** 物业费状态;是否已交物业费 */
    public String getHState(){
        return this.hState;
    }
    /** 物业费状态;是否已交物业费 */
    public void setHState(String hState){
        this.hState=hState;
    }
    /** 更新时间 */
    public Date getHTime(){
        return this.hTime;
    }
    /** 更新时间 */
    public void setHTime(Date hTime){
        this.hTime=hTime;
    }
}
