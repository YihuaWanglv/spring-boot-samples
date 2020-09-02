package com.qkc.bus.phoenix.core;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfig
 */
public class ServiceException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -2641334479605359213L;

    private int code;

    public ServiceException() {
        super("服务出错了，您可以联系管理员反馈此错误");
        this.code = 500;
    }

    public ServiceException(String message) {
        super(message);
        this.code = 500;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.code = 500;
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
