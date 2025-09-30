package com.ssm.exception;

/**
 * 炸弹服务业务异常
 */
public class BombServiceException extends RuntimeException {
    
    private final String errorCode;
    
    public BombServiceException(String message) {
        super(message);
        this.errorCode = "BOMB_SERVICE_ERROR";
    }
    
    public BombServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BombServiceException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "BOMB_SERVICE_ERROR";
    }
    
    public BombServiceException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}
