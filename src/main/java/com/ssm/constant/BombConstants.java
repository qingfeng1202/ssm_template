package com.ssm.constant;

import java.math.BigDecimal;

/**
 * 炸弹相关常量定义
 */
public final class BombConstants {
    
    // 炸弹类型常量
    public static final String BOMB_TYPE_SMALL = "SMALL";
    public static final String BOMB_TYPE_MEDIUM = "MEDIUM";
    public static final String BOMB_TYPE_LARGE = "LARGE";
    
    // 炸弹状态常量
    public static final String BOMB_STATUS_ACTIVE = "ACTIVE";
    public static final String BOMB_STATUS_EXPLODED = "EXPLODED";
    public static final String BOMB_STATUS_EXPIRED = "EXPIRED";
    
    // 动作类型常量
    public static final String ACTION_EXPLODE = "EXPLODE";
    public static final String ACTION_CREATE = "CREATE";
    
    // 炸弹威力阈值常量
    public static final BigDecimal SMALL_BOMB_MIN_POWER = new BigDecimal("100");
    public static final BigDecimal MEDIUM_BOMB_MIN_POWER = new BigDecimal("500");
    public static final BigDecimal LARGE_BOMB_MIN_POWER = new BigDecimal("1000");
    
    // 炸弹数量限制常量
    public static final int SMALL_BOMB_MAX_COUNT = 5;
    public static final int MEDIUM_BOMB_MAX_COUNT = 3;
    public static final int LARGE_BOMB_MAX_COUNT = 1;
    
    // 奖励系数常量
    public static final BigDecimal BASE_REWARD_RATE = new BigDecimal("0.1");
    public static final BigDecimal SMALL_BOMB_REWARD_RATE = new BigDecimal("0.1");
    public static final BigDecimal MEDIUM_BOMB_REWARD_RATE = new BigDecimal("0.15");
    public static final BigDecimal LARGE_BOMB_REWARD_RATE = new BigDecimal("0.2");
    
    // 奖励加成系数常量
    public static final BigDecimal SMALL_BOMB_BONUS_RATE = new BigDecimal("0.05");
    public static final BigDecimal MEDIUM_BOMB_BONUS_RATE = new BigDecimal("0.1");
    public static final BigDecimal LARGE_BOMB_BONUS_RATE = new BigDecimal("0.15");
    
    // 消息格式常量
    public static final int MESSAGE_MIN_PARTS_COUNT = 5;
    public static final int MESSAGE_ROOM_ID_INDEX = 0;
    public static final int MESSAGE_USER_ID_INDEX = 1;
    public static final int MESSAGE_BOMB_TYPE_INDEX = 2;
    public static final int MESSAGE_POWER_INDEX = 3;
    public static final int MESSAGE_ACTION_INDEX = 4;
    
    // 错误消息常量
    public static final String ERROR_MESSAGE_EMPTY = "消息为空";
    public static final String ERROR_MESSAGE_FORMAT = "消息格式错误";
    public static final String ERROR_ROOM_ID_INVALID = "房间ID无效";
    public static final String ERROR_USER_ID_INVALID = "用户ID无效";
    public static final String ERROR_USER_NOT_FOUND = "用户不存在";
    public static final String ERROR_BOMB_TYPE_UNKNOWN = "未知炸弹类型";
    public static final String ERROR_BOMB_POWER_INSUFFICIENT = "炸弹威力不足";
    public static final String ERROR_BOMB_COUNT_LIMIT = "炸弹数量已达上限";
    public static final String ERROR_BOMB_NULL = "炸弹为空";
    public static final String ERROR_BOMB_ID_NULL = "炸弹ID为空";
    public static final String ERROR_BOMB_NOT_FOUND = "炸弹不存在";
    public static final String ERROR_BOMB_STATUS_INVALID = "炸弹状态无效";
    public static final String ERROR_BOMB_UPDATE_FAILED = "更新炸弹失败";
    public static final String ERROR_NUMBER_FORMAT = "数字格式错误";
    public static final String ERROR_SYSTEM = "系统错误";
    public static final String ERROR_EXPLODE_FAILED = "爆炸处理失败";
    
    // 成功消息常量
    public static final String SUCCESS_REWARD_GRANTED = "发放奖励";
    
    // 响应字段常量
    public static final String RESPONSE_SUCCESS = "success";
    public static final String RESPONSE_MESSAGE = "message";
    public static final String RESPONSE_BOMB_ID = "bombId";
    public static final String RESPONSE_REWARD = "reward";
    
    // 私有构造函数，防止实例化
    private BombConstants() {
        throw new IllegalStateException("Utility class");
    }
}