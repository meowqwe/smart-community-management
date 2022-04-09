package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 商铺信息
 */
@Table(name="SCM_Shop")
public class ScmShop implements Serializable,Cloneable{
    /** 商铺号 */
    @Id
    @GeneratedValue
    private String shId ;
    /** 商铺名 */
    private String shName ;
    /** 商铺类别 */
    private String shClass ;
    /** 商铺描述 */
    private String shDescription ;
    /** 商铺图片 */
    private String shPicture ;

    /** 号 */
    public String getShId(){
        return this.shId;
    }
    /** 号 */
    public void setShId(String shId){
        this.shId=shId;
    }
    /** 商铺名 */
    public String getShName(){
        return this.shName;
    }
    /** 商铺名 */
    public void setShName(String shName){
        this.shName=shName;
    }
    /** 商铺类别 */
    public String getShClass(){
        return this.shClass;
    }
    /** 商铺类别 */
    public void setShClass(String shClass){
        this.shClass=shClass;
    }
    /** 商铺描述 */
    public String getShDescription(){
        return this.shDescription;
    }
    /** 商铺描述 */
    public void setShDescription(String shDescription){
        this.shDescription=shDescription;
    }
    /** 商铺图片 */
    public String getShPicture(){
        return this.shPicture;
    }
    /** 商铺图片 */
    public void setShPicture(String shPicture){
        this.shPicture=shPicture;
    }
}