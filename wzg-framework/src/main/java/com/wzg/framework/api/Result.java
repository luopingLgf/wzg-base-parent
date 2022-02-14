package com.wzg.framework.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * 接口返回类
 *
 * @author LuoPing
 * @since 2022/2/9
 */
@ApiModel(value = "返回结果对象")
public class Result<T> {

    /**
     * 是否成功返回
     */
    private boolean success = true;

    @ApiModelProperty(value = "接口返回码")
    private int code;

    @ApiModelProperty(value = "接口返回描述")
    private String msg;

    @ApiModelProperty(value = "错误栈-开发人员使用")
    private String stack;

    @ApiModelProperty(value = "接口返回数据对象")
    private T data;

    public Result() {
        this(null);
    }

    public Result(T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static<T> Result<T> fail() {
        return fail(ResultCode.ERR_SYSTEM.getCode(), ResultCode.ERR_SYSTEM.getMsg());
    }

    public static <T> Result<T> fail(String msg) {
        return fail(ResultCode.ERR_SYSTEM.getCode(), msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return fail(code, msg, StringUtils.EMPTY);
    }

    public static <T> Result<T> fail(int code, String msg, String stack) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setStack(stack);
        return r;
    }

    public static <T> Result<T> success() {
        return new Result<>();
    }

    public static <T> Result<T> success(T t) {
        Result<T> r = new Result<>();
        r.setData(t);
        return r;
    }

    /**
     * getter setter方法
     */
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
