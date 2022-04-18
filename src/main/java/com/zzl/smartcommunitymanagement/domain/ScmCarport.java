package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 车位信息
 */
@Table(name="SCM_Carport")
public class ScmCarport implements Serializable,Cloneable{
    /** 车位号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cpId ;
    /** 住户号 */
    private Integer hId ;
    /** 到期时间 */
    private LocalDateTime exTime ;
    /** 租金 */
    private Double cpRent ;

    /** 车位号 */
    public Integer getCpId(){
        return this.cpId;
    }
    /** 车位号 */
    public void setCpId(Integer cpId){
        this.cpId=cpId;
    }
    /** 住户号 */
    public Integer getHId(){
        return this.hId;
    }
    /** 住户号 */
    public void setHId(Integer hId){
        this.hId=hId;
    }
    /** 到期时间 */
    public LocalDateTime getExTime(){
        return this.exTime;
    }
    /** 到期时间 */
    public void setExTime(LocalDateTime exTime){
        this.exTime=exTime;
    }
    /** 租金 */
    public Double getCpRent(){
        return this.cpRent;
    }
    /** 租金 */
    public void setCpRent(Double cpRent){
        this.cpRent=cpRent;
    }
}
