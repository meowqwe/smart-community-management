package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 服务-人员
 */
@Table(name="SCM_ServiceWorker")
public class ScmServiceWorker implements Serializable,Cloneable {
    /** 服务号 */
    @Id
    @GeneratedValue
    private Integer sId ;
    /** 工号 */
    @Id
    @GeneratedValue
    private Integer wId ;

    /** 服务号 */
    public Integer getSId(){
        return this.sId;
    }
    /** 服务号 */
    public void setSId(Integer sId){
        this.sId=sId;
    }
    /** 工号 */
    public Integer getWId(){
        return this.wId;
    }
    /** 工号 */
    public void setWId(Integer wId){
        this.wId=wId;
    }
}
