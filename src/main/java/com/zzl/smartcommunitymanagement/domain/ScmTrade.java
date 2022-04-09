package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 闲置交易信息
 */
@Table(name="SCM_Trade")
public class ScmTrade implements Serializable,Cloneable{
    /** 交易信息号 */
    @Id
    @GeneratedValue
    private String tId ;
    /** 创建人 */
    private String cId ;
    /** 创建时间 */
    private Date cTime ;
    /** 更新时间 */
    private Date uTime ;
    /** 商品名 */
    private String tName ;
    /** 商品数量 */
    private Integer tQuantity ;
    /** 商品价格 */
    private Double tPrice ;
    /** 商品状态;是否在售 */
    private String tState ;

    /** 交易信息号 */
    public String getTId(){
        return this.tId;
    }
    /** 交易信息号 */
    public void setTId(String tId){
        this.tId=tId;
    }
    /** 创建人 */
    public String getCId(){
        return this.cId;
    }
    /** 创建人 */
    public void setCId(String cId){
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
    /** 更新时间 */
    public Date getUTime(){
        return this.uTime;
    }
    /** 更新时间 */
    public void setUTime(Date uTime){
        this.uTime=uTime;
    }
    /** 商品名 */
    public String getTName(){
        return this.tName;
    }
    /** 商品名 */
    public void setTName(String tName){
        this.tName=tName;
    }
    /** 商品数量 */
    public Integer getTQuantity(){
        return this.tQuantity;
    }
    /** 商品数量 */
    public void setTQuantity(Integer tQuantity){
        this.tQuantity=tQuantity;
    }
    /** 商品价格 */
    public Double getTPrice(){
        return this.tPrice;
    }
    /** 商品价格 */
    public void setTPrice(Double tPrice){
        this.tPrice=tPrice;
    }
    /** 商品状态;是否在售 */
    public String getTState(){
        return this.tState;
    }
    /** 商品状态;是否在售 */
    public void setTState(String tState){
        this.tState=tState;
    }
}