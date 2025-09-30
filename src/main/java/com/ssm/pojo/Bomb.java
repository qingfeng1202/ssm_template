package com.ssm.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 炸弹实体类
 */
public class Bomb implements Serializable {
    
    private Long id;
    private Long roomId;
    private Long userId;
    private String bombType;
    private BigDecimal power;
    private String status;
    private Date createTime;
    private Date explodeTime;
    private BigDecimal rewardAmount;
    
    // Constructors
    public Bomb() {}
    
    public Bomb(Long roomId, Long userId, String bombType, BigDecimal power) {
        this.roomId = roomId;
        this.userId = userId;
        this.bombType = bombType;
        this.power = power;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getExplodeTime() {
        return explodeTime;
    }
    
    public void setExplodeTime(Date explodeTime) {
        this.explodeTime = explodeTime;
    }
    
    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }
    
    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }
    
    @Override
    public String toString() {
        return "Bomb{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", userId=" + userId +
                ", bombType='" + bombType + '\'' +
                ", power=" + power +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", explodeTime=" + explodeTime +
                ", rewardAmount=" + rewardAmount +
                '}';
    }
}