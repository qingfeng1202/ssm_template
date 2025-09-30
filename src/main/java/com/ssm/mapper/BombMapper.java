package com.ssm.mapper;

import com.ssm.pojo.Bomb;
import java.util.List;

/**
 * 炸弹数据访问接口
 */
public interface BombMapper {
    
    /**
     * 根据ID查询炸弹
     * @param id 炸弹ID
     * @return 炸弹信息
     */
    Bomb selectById(Long id);
    
    /**
     * 根据房间ID查询活跃炸弹
     * @param roomId 房间ID
     * @return 炸弹列表
     */
    List<Bomb> selectActiveBombsByRoomId(Long roomId);
    
    /**
     * 插入炸弹
     * @param bomb 炸弹信息
     * @return 影响行数
     */
    int insert(Bomb bomb);
    
    /**
     * 更新炸弹
     * @param bomb 炸弹信息
     * @return 影响行数
     */
    int update(Bomb bomb);
    
    /**
     * 更新炸弹状态
     * @param id 炸弹ID
     * @param status 状态
     * @return 影响行数
     */
    int updateStatus(Long id, String status);
    
    /**
     * 批量更新炸弹状态
     * @param ids 炸弹ID列表
     * @param status 状态
     * @return 影响行数
     */
    int batchUpdateStatus(List<Long> ids, String status);
}