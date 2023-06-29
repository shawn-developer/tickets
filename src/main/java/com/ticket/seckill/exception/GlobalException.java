package com.ticket.seckill.exception;

import com.ticket.seckill.vo.RespBeanEnum;

/**
 * 全局异常
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/28
 */
public class GlobalException extends RuntimeException {

    private RespBeanEnum respBeanEnum;

    public RespBeanEnum getRespBeanEnum() {
        return respBeanEnum;
    }

    public void setRespBeanEnum(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }

    public GlobalException(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }
}
