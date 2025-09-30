package com.ssm.util;

import com.ssm.constant.BombConstants;
import com.ssm.exception.ValidationException;

import java.math.BigDecimal;

/**
 * 炸弹验证工具类
 */
public final class BombValidationUtil {
    
    /**
     * 验证房间ID
     * @param roomId 房间ID
     * @throws ValidationException 验证失败时抛出异常
     */
    public static void validateRoomId(Long roomId) {
        if (roomId == null || roomId <= 0) {
            throw new ValidationException(BombConstants.ERROR_ROOM_ID_INVALID);
        }
    }
    
    /**
     * 验证用户ID
     * @param userId 用户ID
     * @throws ValidationException 验证失败时抛出异常
     */
    public static void validateUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new ValidationException(BombConstants.ERROR_USER_ID_INVALID);
        }
    }
    
    /**
     * 验证炸弹类型
     * @param bombType 炸弹类型
     * @throws ValidationException 验证失败时抛出异常
     */
    public static void validateBombType(String bombType) {
        if (!BombConstants.BOMB_TYPE_SMALL.equals(bombType) &&
            !BombConstants.BOMB_TYPE_MEDIUM.equals(bombType) &&
            !BombConstants.BOMB_TYPE_LARGE.equals(bombType)) {
            throw new ValidationException(BombConstants.ERROR_BOMB_TYPE_UNKNOWN);
        }
    }
    
    /**
     * 验证炸弹威力
     * @param bombType 炸弹类型
     * @param power 威力值
     * @throws ValidationException 验证失败时抛出异常
     */
    public static void validateBombPower(String bombType, BigDecimal power) {
        if (power == null) {
            throw new ValidationException(BombConstants.ERROR_BOMB_POWER_INSUFFICIENT);
        }
        
        switch (bombType) {
            case BombConstants.BOMB_TYPE_SMALL:
                if (power.compareTo(BombConstants.SMALL_BOMB_MIN_POWER) < 0) {
                    throw new ValidationException(BombConstants.ERROR_BOMB_POWER_INSUFFICIENT);
                }
                break;
            case BombConstants.BOMB_TYPE_MEDIUM:
                if (power.compareTo(BombConstants.MEDIUM_BOMB_MIN_POWER) < 0) {
                    throw new ValidationException(BombConstants.ERROR_BOMB_POWER_INSUFFICIENT);
                }
                break;
            case BombConstants.BOMB_TYPE_LARGE:
                if (power.compareTo(BombConstants.LARGE_BOMB_MIN_POWER) < 0) {
                    throw new ValidationException(BombConstants.ERROR_BOMB_POWER_INSUFFICIENT);
                }
                break;
            default:
                throw new ValidationException(BombConstants.ERROR_BOMB_TYPE_UNKNOWN);
        }
    }
    
    /**
     * 验证消息格式
     * @param message 消息内容
     * @throws ValidationException 验证失败时抛出异常
     */
    public static void validateMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new ValidationException(BombConstants.ERROR_MESSAGE_EMPTY);
        }
    }
    
    /**
     * 验证消息分割后的部分数量
     * @param parts 消息分割后的数组
     * @throws ValidationException 验证失败时抛出异常
     */
    public static void validateMessageParts(String[] parts) {
        if (parts.length < BombConstants.MESSAGE_MIN_PARTS_COUNT) {
            throw new ValidationException(BombConstants.ERROR_MESSAGE_FORMAT);
        }
    }
    
    // 私有构造函数，防止实例化
    private BombValidationUtil() {
        throw new IllegalStateException("Utility class");
    }
}
