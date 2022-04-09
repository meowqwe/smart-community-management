package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 用户表
 */
@Table(name="SCM_User")
public class ScmUser implements Serializable,Cloneable{
    /** 用户号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uId ;
    /** 住户号 */
    private Integer hId ;
    /** 用户名 */
    private String uName ;
    /** 密码 */
    private String uPassword ;
    /** 权限;是否为管理员 */
    private String uAdmin ;

    /** 用户号 */
    public Integer getUId(){
        return this.uId;
    }
    /** 用户号 */
    public void setUId(Integer uId){
        this.uId=uId;
    }
    /** 住户号 */
    public Integer getHId(){
        return this.hId;
    }
    /** 住户号 */
    public void setHId(Integer hId){
        this.hId=hId;
    }
    /** 用户名 */
    public String getUName(){
        return this.uName;
    }
    /** 用户名 */
    public void setUName(String uName){
        this.uName=uName;
    }
    /** 密码 */
    public String getUPassword(){
        return this.uPassword;
    }
    /** 密码 */
    public void setUPassword(String uPassword){
        this.uPassword=uPassword;
    }
    /** 权限;是否为管理员 */
    public String getUAdmin(){
        return this.uAdmin;
    }
    /** 权限;是否为管理员 */
    public void setUAdmin(String uAdmin){
        this.uAdmin=uAdmin;
    }
}
