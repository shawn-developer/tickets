package com.ticket.seckill.config;

import com.ticket.seckill.entity.TUser;

/**
 * @Author: Shawn Chen
 * @Date: 2023/6/29
 */
public class UserContext {

    private static ThreadLocal<TUser> userThreadLocal = new ThreadLocal<>();

    public static void setUser(TUser tUser) {
        userThreadLocal.set(tUser);
    }

    public static TUser getUser() {
        return userThreadLocal.get();
    }
}
