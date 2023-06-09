package com.ticket.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ticket.seckill.entity.TGoods;
import com.ticket.seckill.vo.GoodsVo;

import java.util.List;

/**
 * 商品表 服务类
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/21
 */
public interface ITGoodsService extends IService<TGoods> {

    /**
     * 返回商品列表
     *
     * @param
     * @return java.util.List<com.ticket.seckill.vo.GoodsVo>
     * @author LC
     * @operation add
     * @date 5:49 下午 2022/3/3
     **/
    List<GoodsVo> findGoodsVo();

    /**
     * 获取商品详情
     *
     * @param goodsId
     * @return java.lang.String
     * @author LC
     * @operation add
     * @date 9:37 上午 2022/3/4
     **/
    GoodsVo findGoodsVobyGoodsId(Long goodsId);
}
