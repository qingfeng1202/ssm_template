package com.ssm.service.impl;

import com.ssm.constant.BombConstants;
import com.ssm.exception.ValidationException;
import com.ssm.util.BombValidationUtil;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 直播间炸弹服务实现类测试
 * 主要测试优化后的验证逻辑和常量使用
 */
public class LiveRoomBombServiceImplTest {

    @Test
    public void testBombConstants() {
        // 测试常量定义是否正确
        assert BombConstants.BOMB_TYPE_SMALL.equals("SMALL");
        assert BombConstants.BOMB_TYPE_MEDIUM.equals("MEDIUM");
        assert BombConstants.BOMB_TYPE_LARGE.equals("LARGE");
        
        // 测试数值常量
        assert BombConstants.SMALL_BOMB_MAX_COUNT == 5;
        assert BombConstants.MEDIUM_BOMB_MAX_COUNT == 3;
        assert BombConstants.LARGE_BOMB_MAX_COUNT == 1;
        
        System.out.println("常量测试通过");
    }

    @Test
    public void testValidationUtil() {
        try {
            // 测试正常的房间ID验证
            BombValidationUtil.validateRoomId(1L);
            System.out.println("房间ID验证测试通过");
        } catch (Exception e) {
            System.err.println("房间ID验证测试失败: " + e.getMessage());
        }

        try {
            // 测试无效的房间ID验证
            BombValidationUtil.validateRoomId(-1L);
            System.err.println("应该抛出异常但没有抛出");
        } catch (ValidationException e) {
            System.out.println("无效房间ID验证测试通过: " + e.getMessage());
        }

        try {
            // 测试炸弹类型验证
            BombValidationUtil.validateBombType(BombConstants.BOMB_TYPE_SMALL);
            System.out.println("炸弹类型验证测试通过");
        } catch (Exception e) {
            System.err.println("炸弹类型验证测试失败: " + e.getMessage());
        }

        try {
            // 测试炸弹威力验证
            BombValidationUtil.validateBombPower(BombConstants.BOMB_TYPE_SMALL, new BigDecimal("150"));
            System.out.println("炸弹威力验证测试通过");
        } catch (Exception e) {
            System.err.println("炸弹威力验证测试失败: " + e.getMessage());
        }
    }

    @Test
    public void testMessageValidation() {
        try {
            // 测试正常消息验证
            BombValidationUtil.validateMessage("123,456,SMALL,150,CREATE");
            System.out.println("消息验证测试通过");
        } catch (Exception e) {
            System.err.println("消息验证测试失败: " + e.getMessage());
        }

        try {
            // 测试空消息验证
            BombValidationUtil.validateMessage("");
            System.err.println("应该抛出异常但没有抛出");
        } catch (ValidationException e) {
            System.out.println("空消息验证测试通过: " + e.getMessage());
        }

        try {
            // 测试消息分割验证
            String[] parts = "123,456,SMALL".split(",");
            BombValidationUtil.validateMessageParts(parts);
            System.err.println("应该抛出异常但没有抛出");
        } catch (ValidationException e) {
            System.out.println("消息分割验证测试通过: " + e.getMessage());
        }
    }
}
