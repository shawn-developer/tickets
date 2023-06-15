package com.ticket.seckill.vo;

import com.ticket.seckill.entity.TOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详情返回对象
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/15
 * @ClassName: OrderDeatilVo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeatilVo {

    private TOrder tOrder;

    private GoodsVo goodsVo;
}
