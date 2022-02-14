package com.wzg.framework.exception;

/**
 * 自定义异常类
 *
 * @author LuoPing
 * @since 2022/2/9
 */
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
