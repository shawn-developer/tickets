package com.ticket.seckill.utils;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @Author: Shawn Chen
 * @Date: 2023/7/25
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
