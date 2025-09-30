package com.ssm.exception;

/**
 * 参数验证异常
 */
public class ValidationException extends BombServiceException {
    
    public ValidationException(String message) {
        super("VALIDATION_ERROR", message);
    }
    
    public ValidationException(String message, Throwable cause) {
        super("VALIDATION_ERROR", message, cause);
    }
}
