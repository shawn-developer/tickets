package com.ticket.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ticket.seckill.entity.TSeckillGoods;
import com.ticket.seckill.mapper.TSeckillGoodsMapper;
import com.ticket.seckill.service.ITSeckillGoodsService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 秒杀商品表 服务实现类
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/21
 */
@Service
@Primary
public class TSeckillGoodsServiceImpl extends ServiceImpl<TSeckillGoodsMapper, TSeckillGoods> implements ITSeckillGoodsService {

}
