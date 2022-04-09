package com.zzl.smartcommunitymanagement.common;

import java.io.Serializable;
/**
 * @author zzl
 * @Desc 分页标准返回结果
 */
public class PageResult implements Serializable{

    private static final long serialVersionUID = -6250130355901431732L;

    private boolean flag;//是否成功
    private Integer code;//返回码
    private String message;//返回消息
    private Object data;
    private Long total;
    /**
     * 功能描述: 无参构造
     * @return :
     */
    public PageResult() {
    }
    /**
     * 功能描述:
     * @param flag  请求是否成功
     * @param code  状态码
     * @param message   消息提示
     * @param data      结果集列表
     * @param total     总条数
     * @return :
     */
    public PageResult(boolean flag, Integer code, String message, Object data, Long total) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
