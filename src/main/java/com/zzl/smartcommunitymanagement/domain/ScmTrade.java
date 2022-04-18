package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tId ;
    /** 创建人 */
    private Integer cId ;
    /** 创建时间 */
    private LocalDateTime cTime ;
    /** 更新时间 */
    private LocalDateTime uTime ;
    /** 商品名 */
    private String tName ;
    /** 商品数量 */
    private Integer tQuantity ;
    /** 商品价格 */
    private Double tPrice ;
    /** 商品状态;是否在售 */
    private String tState ;
    /** 联系方式 */
    private String tContact ;

    /** 交易信息号 */
    public Integer getTId(){
        return this.tId;
    }
    /** 交易信息号 */
    public void setTId(Integer tId){
        this.tId=tId;
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
    /** 更新时间 */
    public LocalDateTime getUTime(){
        return this.uTime;
    }
    /** 更新时间 */
    public void setUTime(LocalDateTime uTime){
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
    /** 联系方式 */
    public String getTContact(){
        return this.tContact;
    }
    /** 联系方式 */
    public void setTContact(String tContact){
        this.tContact=tContact;
    }
}
