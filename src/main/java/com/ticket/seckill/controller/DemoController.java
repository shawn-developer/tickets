package com.ticket.seckill.controller;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试类
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/23
 */
@Controller
@RequestMapping("demo")
@Api(value = "demo", tags = "demo测试类")
public class DemoController {

    /**
     * 测试页面
     *
     * @param model
     * @return java.lang.String
     * @author LC
     * @operation add
     * @date 4:25 下午 2022/3/1
     **/
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "example");
        return "hello";
    }
}
