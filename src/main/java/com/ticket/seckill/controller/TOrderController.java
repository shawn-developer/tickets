package com.ticket.seckill.controller;

import com.ticket.seckill.entity.TUser;
import com.ticket.seckill.service.ITOrderService;
import com.ticket.seckill.vo.OrderDeatilVo;
import com.ticket.seckill.vo.RespBean;
import com.ticket.seckill.vo.RespBeanEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/25
 */
@RestController
@RequestMapping("/order")
@Api(value = "订单", tags = "订单")
public class TOrderController {

    @Autowired
    private ITOrderService itOrderService;


    @ApiOperation("订单")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public RespBean detail(TUser tUser, Long orderId) {
        if (tUser == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        OrderDeatilVo orderDeatilVo = itOrderService.detail(orderId);
        return RespBean.success(orderDeatilVo);
    }
}
