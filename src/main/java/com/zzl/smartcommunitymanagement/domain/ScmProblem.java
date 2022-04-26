package com.zzl.smartcommunitymanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : zzl
 * @date : 2022-4-8
 * @desc : 社区常见问题
 */
@Table(name="SCM_Problem")
public class ScmProblem implements Serializable,Cloneable{
    /** 问题号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId ;
    /** 问题内容 */
    private String pName ;
    /** 创建人 */
    private Integer cId ;
    /** 创建时间 */
    private LocalDateTime cTime ;
    /** 更新人 */
    private Integer uId ;
    /** 更新时间 */
    private LocalDateTime uTime ;
    /** 解决方案 */
    private String pSolution ;

    /** 问题号 */
    public Integer getPId(){
        return this.pId;
    }
    /** 问题号 */
    public void setPId(Integer pId){
        this.pId=pId;
    }
    /** 问题内容 */
    public String getPName(){
        return this.pName;
    }
    /** 问题内容 */
    public void setPName(String pName){
        this.pName=pName;
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
    /** 更新人 */
    public Integer getUId(){
        return this.uId;
    }
    /** 更新人 */
    public void setUId(Integer uId){
        this.uId=uId;
    }
    /** 更新时间 */
    public LocalDateTime getUTime(){
        return this.uTime;
    }
    /** 更新时间 */
    public void setUTime(LocalDateTime uTime){
        this.uTime=uTime;
    }
    /** 解决方案 */
    public String getPSolution(){
        return this.pSolution;
    }
    /** 解决方案 */
    public void setPSolution(String pSolution){
        this.pSolution=pSolution;
    }
}
