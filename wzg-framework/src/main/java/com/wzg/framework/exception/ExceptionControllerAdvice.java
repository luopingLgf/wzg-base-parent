package com.wzg.framework.exception;

import com.wzg.framework.api.Result;
import com.wzg.framework.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Set;

/**
 * 统一异常处理
 *
 * @author : LuoPing
 * @since : 2022/2/10
 */
@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    /**
     * 处理未捕获的异常
     *
     * @param ex 异常对象
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result<?> exceptionHandler(Exception ex) {
        this.logStackMsg(ex);
        Integer code = ResultCode.ERR_500.getCode();
        return Result.fail(code, code + "-" + ResultCode.ERR_500.getMsg(), ex.getMessage());
    }

    /**
     * 处理自定义异常
     *
     * @param ex 异常对象
     * @return Result
     */
    @ExceptionHandler(CustomException.class)
    public Result<String> customExceptionHandler(CustomException ex) {
        this.logStackMsg(ex);
        return Result.fail(ResultCode.ERR_500.getCode(), ex.getMessage());
    }

    /**
     * 处理空指针异常
     *
     * @param ex 异常对象
     * @return Result
     */
    @ExceptionHandler(NullPointerException.class)
    public Result<String> missParamExceptionHandler(NullPointerException ex) {
        this.logStackMsg(ex);
        Integer code = ResultCode.ERR_NULL.getCode();
        return Result.fail(code, code + "-" + ResultCode.ERR_NULL.getMsg(), ex.getMessage());
    }

    /**
     * 处理缺少参数异常
     *
     * @param ex 异常对象
     * @return Result
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<String> missParamExceptionHandler(MissingServletRequestParameterException ex) {
        this.logStackMsg(ex);
        Integer code = ResultCode.ERR_PARAM.getCode();
        return Result.fail(code, code + "-" + ResultCode.ERR_PARAM.getMsg(), "缺少参数：" + ex.getParameterName());
    }

    /**
     * 处理Json参数转化异常
     *
     * @param ex 异常对象
     * @return Result
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<String> missParamExceptionHandler(HttpMessageNotReadableException ex) {
        this.logStackMsg(ex);
        Integer code = ResultCode.ERR_PARAM.getCode();
        return Result.fail(code, code + "-" + ResultCode.ERR_PARAM.getMsg(), ex.getMessage());
    }

    /**
     * 处理单个参数不满足校验规则异常
     *
     * @param ex 异常对象
     * @return Result
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> paramExceptionHandler(ConstraintViolationException ex) {
        this.logStackMsg(ex);
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            stringBuilder.append(constraintViolation.getMessage()).append("\n");
        }
        Integer code = ResultCode.ERR_PARAM.getCode();
        return Result.fail(code, code + "-" + ResultCode.ERR_PARAM.getMsg(), stringBuilder.toString());
    }

    /**
     * 处理请求对象属性不满足校验规则异常
     *
     * @param ex 异常对象
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> paramExceptionHandler(MethodArgumentNotValidException ex) {
        this.logStackMsg(ex);
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            stringBuilder.append(error.getDefaultMessage()).append("\n");
        }
        Integer code = ResultCode.ERR_PARAM.getCode();
        return Result.fail(code, code + "-" + ResultCode.ERR_PARAM.getMsg(), stringBuilder.toString());
    }

    /**
     * 记录异常的栈日志
     *
     * @param ex 异常类
     * @return void
     */
    private void logStackMsg(Exception ex) {
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            ex.printStackTrace(pw);
            pw.flush();
            sw.flush();
            if (sw != null) {
                log.error("\r\n" + sw.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
