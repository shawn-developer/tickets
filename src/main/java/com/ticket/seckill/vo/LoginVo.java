package com.ticket.seckill.vo;


import org.hibernate.validator.constraints.Length;


/**
 * 登录传参
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/15
 * @ClassName: LoginVo
 */
public class LoginVo {

//    @NotNull
//    @IsMobile
    private String mobile;

//    @NotNull
    @Length(min = 32)
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
