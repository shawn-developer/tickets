package com.ticket.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.ticket.seckill.entity.TGoods;
import com.ticket.seckill.vo.GoodsVo;

import java.util.List;

/**
 * 商品表 Mapper 接口
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/15
 */
public interface TGoodsMapper extends BaseMapper<TGoods> {

    /**
     * 返回商品列表
     * @author LC
     * @operation add
     * @date 5:50 下午 2022/3/3
     * @param
     * @return java.util.List<com.example.seckilldemo.vo.GoodsVo>
     **/
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVobyGoodsId(Long goodsId);
}
