package com.ssm.dto;

import java.math.BigDecimal;

/**
 * 炸弹消息数据传输对象
 */
public class BombMessageDTO {
    
    private Long roomId;
    private Long userId;
    private String bombType;
    private BigDecimal power;
    private String action;
    
    public BombMessageDTO() {}
    
    public BombMessageDTO(Long roomId, Long userId, String bombType, BigDecimal power, String action) {
        this.roomId = roomId;
        this.userId = userId;
        this.bombType = bombType;
        this.power = power;
        this.action = action;
    }
    
    // Getters and Setters
    public Long getRoomId() {
        return roomId;
    }
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getBombType() {
        return bombType;
    }
    
    public void setBombType(String bombType) {
        this.bombType = bombType;
    }
    
    public BigDecimal getPower() {
        return power;
    }
    
    public void setPower(BigDecimal power) {
        this.power = power;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    @Override
    public String toString() {
        return "BombMessageDTO{" +
                "roomId=" + roomId +
                ", userId=" + userId +
                ", bombType='" + bombType + '\'' +
                ", power=" + power +
                ", action='" + action + '\'' +
                '}';
    }
}
