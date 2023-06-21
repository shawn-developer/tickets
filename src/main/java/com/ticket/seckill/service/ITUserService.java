package com.ticket.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ticket.seckill.vo.LoginVo;
import com.ticket.seckill.vo.RespBean;
import com.ticket.seckill.entity.TUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LiChao
 * @since 2022-03-02
 */

public interface ITUserService extends IService<TUser> {

    /**
     * 登录方法
     *
     * @param loginVo
     * @param request
     * @param response
     * @return com.ticket.seckill.vo.RespBean
     * @author LC
     * @operation add
     * @date 1:49 下午 2022/3/3
     **/
    RespBean doLongin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据cookie获取用户
     *
     * @param userTicket
     * @return com.ticket.seckill.entity.TUser
     * @author LC
     * @operation add
     * @date 1:50 下午 2022/3/3
     **/
    TUser getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);


    /**
     * 更新密码
     *
     * @param userTicket
     * @param id
     * @param password
     * @return com.ticket.seckill.vo.RespBean
     * @author LC
     * @operation add
     * @date 9:05 下午 2022/3/4
     **/
    RespBean updatePassword(String userTicket, String password, HttpServletRequest request, HttpServletResponse response);
}
