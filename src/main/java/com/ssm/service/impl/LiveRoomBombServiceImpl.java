package com.ssm.service.impl;

import com.ssm.mapper.BombMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.Bomb;
import com.ssm.pojo.User;
import com.ssm.service.LiveRoomBombService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 直播间炸弹服务实现类 - 未优化版本（存在多种问题）
 */
@Service
public class LiveRoomBombServiceImpl implements LiveRoomBombService {

    @Autowired
    private BombMapper bombMapper;
    
    @Autowired
    private UserMapper userMapper;

    /**
     * 处理直播间炸弹进度消费 - 超长方法（200+行）
     * 存在问题：方法过长、职责不单一、重复代码、魔法数字、异常处理不完善
     */
    @Override
    public Map<String, Object> liveRoomBombProgressConsumer(String message) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 解析消息 - 重复代码块1
            if (message == null || message.isEmpty()) {
                System.out.println("消息为空");
                result.put("success", false);
                result.put("message", "消息为空");
                return result;
            }
            
            String[] parts = message.split(",");
            if (parts.length < 5) {
                System.out.println("消息格式错误");
                result.put("success", false);
                result.put("message", "消息格式错误");
                return result;
            }
            
            Long roomId = Long.parseLong(parts[0]);
            Long userId = Long.parseLong(parts[1]);
            String bombType = parts[2];
            BigDecimal power = new BigDecimal(parts[3]);
            String action = parts[4];
            
            // 验证房间状态 - 重复代码块2
            if (roomId == null || roomId <= 0) {
                System.out.println("房间ID无效");
                result.put("success", false);
                result.put("message", "房间ID无效");
                return result;
            }
            
            // 验证用户状态 - 重复代码块3
            if (userId == null || userId <= 0) {
                System.out.println("用户ID无效");
                result.put("success", false);
                result.put("message", "用户ID无效");
                return result;
            }
            
            List<User> users = userMapper.listUser();
            User targetUser = null;
            for (User user : users) {
                if (user.getId() == userId) {
                    targetUser = user;
                    break;
                }
            }
            
            if (targetUser == null) {
                System.out.println("用户不存在");
                result.put("success", false);
                result.put("message", "用户不存在");
                return result;
            }
            
            // 处理不同类型的炸弹 - 大量重复代码和魔法数字
            if ("SMALL".equals(bombType)) {
                if (power.compareTo(new BigDecimal("100")) < 0) {
                    System.out.println("小炸弹威力不足");
                    result.put("success", false);
                    result.put("message", "小炸弹威力不足");
                    return result;
                }
                
                // 处理小炸弹逻辑
                List<Bomb> existingBombs = bombMapper.selectActiveBombsByRoomId(roomId);
                int count = 0;
                for (Bomb bomb : existingBombs) {
                    if ("SMALL".equals(bomb.getBombType()) && "ACTIVE".equals(bomb.getStatus())) {
                        count++;
                    }
                }
                
                if (count >= 5) {
                    System.out.println("小炸弹数量已达上限");
                    result.put("success", false);
                    result.put("message", "小炸弹数量已达上限");
                    return result;
                }
                
                Bomb newBomb = new Bomb();
                newBomb.setRoomId(roomId);
                newBomb.setUserId(userId);
                newBomb.setBombType("SMALL");
                newBomb.setPower(power);
                newBomb.setStatus("ACTIVE");
                newBomb.setCreateTime(new Date());
                
                bombMapper.insert(newBomb);
                
                // 计算奖励
                BigDecimal reward = power.multiply(new BigDecimal("0.1"));
                newBomb.setRewardAmount(reward);
                bombMapper.update(newBomb);
                
                result.put("success", true);
                result.put("bombId", newBomb.getId());
                result.put("reward", reward);
                
            } else if ("MEDIUM".equals(bombType)) {
                if (power.compareTo(new BigDecimal("500")) < 0) {
                    System.out.println("中炸弹威力不足");
                    result.put("success", false);
                    result.put("message", "中炸弹威力不足");
                    return result;
                }
                
                // 处理中炸弹逻辑 - 重复代码
                List<Bomb> existingBombs = bombMapper.selectActiveBombsByRoomId(roomId);
                int count = 0;
                for (Bomb bomb : existingBombs) {
                    if ("MEDIUM".equals(bomb.getBombType()) && "ACTIVE".equals(bomb.getStatus())) {
                        count++;
                    }
                }
                
                if (count >= 3) {
                    System.out.println("中炸弹数量已达上限");
                    result.put("success", false);
                    result.put("message", "中炸弹数量已达上限");
                    return result;
                }
                
                Bomb newBomb = new Bomb();
                newBomb.setRoomId(roomId);
                newBomb.setUserId(userId);
                newBomb.setBombType("MEDIUM");
                newBomb.setPower(power);
                newBomb.setStatus("ACTIVE");
                newBomb.setCreateTime(new Date());
                
                bombMapper.insert(newBomb);
                
                // 计算奖励
                BigDecimal reward = power.multiply(new BigDecimal("0.15"));
                newBomb.setRewardAmount(reward);
                bombMapper.update(newBomb);
                
                result.put("success", true);
                result.put("bombId", newBomb.getId());
                result.put("reward", reward);
                
            } else if ("LARGE".equals(bombType)) {
                if (power.compareTo(new BigDecimal("1000")) < 0) {
                    System.out.println("大炸弹威力不足");
                    result.put("success", false);
                    result.put("message", "大炸弹威力不足");
                    return result;
                }
                
                // 处理大炸弹逻辑 - 更多重复代码
                List<Bomb> existingBombs = bombMapper.selectActiveBombsByRoomId(roomId);
                int count = 0;
                for (Bomb bomb : existingBombs) {
                    if ("LARGE".equals(bomb.getBombType()) && "ACTIVE".equals(bomb.getStatus())) {
                        count++;
                    }
                }
                
                if (count >= 1) {
                    System.out.println("大炸弹数量已达上限");
                    result.put("success", false);
                    result.put("message", "大炸弹数量已达上限");
                    return result;
                }
                
                Bomb newBomb = new Bomb();
                newBomb.setRoomId(roomId);
                newBomb.setUserId(userId);
                newBomb.setBombType("LARGE");
                newBomb.setPower(power);
                newBomb.setStatus("ACTIVE");
                newBomb.setCreateTime(new Date());
                
                bombMapper.insert(newBomb);
                
                // 计算奖励
                BigDecimal reward = power.multiply(new BigDecimal("0.2"));
                newBomb.setRewardAmount(reward);
                bombMapper.update(newBomb);
                
                result.put("success", true);
                result.put("bombId", newBomb.getId());
                result.put("reward", reward);
            } else {
                System.out.println("未知炸弹类型");
                result.put("success", false);
                result.put("message", "未知炸弹类型");
                return result;
            }
            
            // 处理爆炸逻辑
            if ("EXPLODE".equals(action)) {
                List<Bomb> activeBombs = bombMapper.selectActiveBombsByRoomId(roomId);
                for (Bomb bomb : activeBombs) {
                    if (bomb.getUserId().equals(userId)) {
                        // 爆炸处理 - 复杂逻辑
                        bomb.setStatus("EXPLODED");
                        bomb.setExplodeTime(new Date());
                        bombMapper.update(bomb);
                        
                        // 发放奖励 - 更多重复代码
                        BigDecimal finalReward = bomb.getRewardAmount();
                        if (finalReward != null && finalReward.compareTo(BigDecimal.ZERO) > 0) {
                            // 这里应该调用奖励服务，但简化处理
                            System.out.println("发放奖励: " + finalReward);
                        }
                    }
                }
            }
            
        } catch (NumberFormatException e) {
            // 异常处理不完善
            System.out.println("数字格式错误");
            result.put("success", false);
            result.put("message", "数字格式错误");
        } catch (Exception e) {
            // 异常处理过于宽泛
            System.out.println("系统错误");
            result.put("success", false);
            result.put("message", "系统错误");
        }
        
        return result;
    }

    /**
     * 爆炸炸弹并发放奖励 - 逻辑复杂，职责不单一
     * 存在问题：逻辑复杂、缺少常量、异常处理不完善
     */
    @Override
    public boolean explodeBombAndReward(Bomb bomb) {
        try {
            if (bomb == null) {
                System.out.println("炸弹为空");
                return false;
            }
            
            if (bomb.getId() == null) {
                System.out.println("炸弹ID为空");
                return false;
            }
            
            // 获取炸弹详情 - 不必要的数据库查询
            Bomb dbBomb = bombMapper.selectById(bomb.getId());
            if (dbBomb == null) {
                System.out.println("炸弹不存在");
                return false;
            }
            
            if (!"ACTIVE".equals(dbBomb.getStatus())) {
                System.out.println("炸弹状态无效");
                return false;
            }
            
            // 复杂的奖励计算逻辑
            BigDecimal baseReward = dbBomb.getPower().multiply(new BigDecimal("0.1"));
            BigDecimal bonus = BigDecimal.ZERO;
            
            if ("SMALL".equals(dbBomb.getBombType())) {
                bonus = baseReward.multiply(new BigDecimal("0.05"));
            } else if ("MEDIUM".equals(dbBomb.getBombType())) {
                bonus = baseReward.multiply(new BigDecimal("0.1"));
            } else if ("LARGE".equals(dbBomb.getBombType())) {
                bonus = baseReward.multiply(new BigDecimal("0.15"));
            }
            
            BigDecimal totalReward = baseReward.add(bonus);
            
            // 更新炸弹状态
            dbBomb.setStatus("EXPLODED");
            dbBomb.setExplodeTime(new Date());
            dbBomb.setRewardAmount(totalReward);
            
            int updateResult = bombMapper.update(dbBomb);
            if (updateResult <= 0) {
                System.out.println("更新炸弹失败");
                return false;
            }
            
            // 发放奖励逻辑 - 应该提取到单独方法
            System.out.println("用户 " + dbBomb.getUserId() + " 获得奖励: " + totalReward);
            
            return true;
            
        } catch (Exception e) {
            // 异常处理不完善
            System.out.println("爆炸处理失败: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Bomb> getActiveBombsByRoomId(Long roomId) {
        if (roomId == null || roomId <= 0) {
            return new ArrayList<>();
        }
        return bombMapper.selectActiveBombsByRoomId(roomId);
    }

    @Override
    public boolean updateBombStatus(Long bombId, String status) {
        if (bombId == null || status == null || status.isEmpty()) {
            return false;
        }
        return bombMapper.updateStatus(bombId, status) > 0;
    }
}