package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 租房信息
 */
@Table(name="SCM_Rent")
public class ScmRent implements Serializable,Cloneable{
    /** 租房信息号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rId ;
    /** 住户信息 */
    private Integer hId ;
    /** 创建人 */
    private Integer cId ;
    /** 创建时间 */
    private LocalDateTime cTime ;
    /** 房屋状态;是否已出租 */
    private String rState ;
    /** 审核状态;是否通过审核 */
    private String rCheck ;
    /** 租房价格 */
    private Double rPrice ;
    /** 租房时间 */
    private LocalDateTime rTime ;
    /** 房屋图片 */
    private String rPicture ;
    /** 房屋描述 */
    private String rDescription ;
    /** 联系方式 */
    private String rContact ;

    /** 租房信息号 */
    public Integer getRId(){
        return this.rId;
    }
    /** 租房信息号 */
    public void setRId(Integer rId){
        this.rId=rId;
    }
    /** 住户信息 */
    public Integer getHId(){
        return this.hId;
    }
    /** 住户信息 */
    public void setHId(Integer hId){
        this.hId=hId;
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
    /** 房屋状态;是否已出租 */
    public String getRState(){
        return this.rState;
    }
    /** 房屋状态;是否已出租 */
    public void setRState(String rState){
        this.rState=rState;
    }
    /** 审核状态;是否通过审核 */
    public String getRCheck(){
        return this.rCheck;
    }
    /** 审核状态;是否通过审核 */
    public void setRCheck(String rCheck){
        this.rCheck=rCheck;
    }
    /** 租房价格 */
    public Double getRPrice(){
        return this.rPrice;
    }
    /** 租房价格 */
    public void setRPrice(Double rPrice){
        this.rPrice=rPrice;
    }
    /** 租房时间 */
    public LocalDateTime getRTime(){
        return this.rTime;
    }
    /** 租房时间
     * @param rTime*/
    public void setRTime(LocalDateTime rTime){
        this.rTime=rTime;
    }
    /** 房屋图片 */
    public String getRPicture(){
        return this.rPicture;
    }
    /** 房屋图片 */
    public void setRPicture(String rPicture){
        this.rPicture=rPicture;
    }
    /** 房屋描述 */
    public String getRDescription(){
        return this.rDescription;
    }
    /** 房屋描述 */
    public void setRDescription(String rDescription){
        this.rDescription=rDescription;
    }
    /** 联系方式 */
    public String getRContact(){
        return this.rContact;
    }
    /** 联系方式 */
    public void setRContact(String rContact){
        this.rContact=rContact;
    }
}
