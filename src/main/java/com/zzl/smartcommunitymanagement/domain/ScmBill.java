package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 账单
 */
@Table(name="SCM_Bill")
public class ScmBill implements Serializable,Cloneable{
    /** 账单号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bId ;
    /** 创建人 */
    private Integer cId ;
    /** 创建时间 */
    private LocalDateTime cTime ;
    /** 账单类型 */
    private String bType ;
    /** 账单类型关联id */
    private Integer tId ;
    /** 账单状态;是否生效 */
    private String bState ;
    /** 金额 */
    private Double bTotal ;

    /** 账单号 */
    public Integer getBId(){
        return this.bId;
    }
    /** 账单号 */
    public void setBId(Integer bId){
        this.bId=bId;
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
    public LocalDateTime getCTime(){
        return this.cTime;
    }
    /** 创建时间 */
    public void setCTime(LocalDateTime cTime){
        this.cTime=cTime;
    }
    /** 账单类型 */
    public String getBType(){
        return this.bType;
    }
    /** 账单类型 */
    public void setBType(String bType){
        this.bType=bType;
    }
    /** 账单类型关联id */
    public Integer getTId(){
        return this.tId;
    }
    /** 账单类型关联id */
    public void setTId(Integer tId){
        this.tId=tId;
    }
    /** 账单状态;是否生效 */
    public String getBState(){
        return this.bState;
    }
    /** 账单状态;是否生效 */
    public void setBState(String bState){
        this.bState=bState;
    }
    /** 金额 */
    public Double getBTotal(){
        return this.bTotal;
    }
    /** 金额 */
    public void setBTotal(Double bTotal){
        this.bTotal=bTotal;
    }
}
