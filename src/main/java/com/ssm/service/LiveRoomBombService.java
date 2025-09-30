package com.ssm.service;

import com.ssm.pojo.Bomb;
import java.util.List;
import java.util.Map;

/**
 * 直播间炸弹服务接口
 */
public interface LiveRoomBombService {
    
    /**
     * 处理直播间炸弹进度消费
     * @param message 消息数据
     * @return 处理结果
     */
    Map<String, Object> liveRoomBombProgressConsumer(String message);
    
    /**
     * 爆炸炸弹并发放奖励
     * @param bomb 炸弹信息
     * @return 处理结果
     */
    boolean explodeBombAndReward(Bomb bomb);
    
    /**
     * 获取房间内的活跃炸弹
     * @param roomId 房间ID
     * @return 炸弹列表
     */
    List<Bomb> getActiveBombsByRoomId(Long roomId);
    
    /**
     * 更新炸弹状态
     * @param bombId 炸弹ID
     * @param status 新状态
     * @return 更新结果
     */
    boolean updateBombStatus(Long bombId, String status);
}