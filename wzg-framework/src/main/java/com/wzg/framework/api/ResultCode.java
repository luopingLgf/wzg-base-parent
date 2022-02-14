package com.wzg.framework.api;

/**
 * 返回码枚举类
 *
 * @author : LuoPing
 * @since : 2022/2/10
 */
public enum ResultCode {
    SUCCESS   (0, "请求成功"),
    ERR_SYSTEM(10000, "系统异常，请联系管理员"),
    ERR_AUTH  (10401, "认证失败"),
    ERR_REAL  (10403, "权限错误"),
    ERR_404   (10404, "找不到资源"),
    ERR_500   (10500, "服务器错误"),
    ERR_NULL  (10501, "空对象错误"),
    ERR_PARAM (10405, "参数错误");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
