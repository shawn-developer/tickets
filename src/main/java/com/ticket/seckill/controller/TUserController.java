package com.ticket.seckill.controller;

import com.ticket.seckill.entity.TUser;
import com.ticket.seckill.rabbitmq.MQSender;
import com.ticket.seckill.service.ITUserService;
import com.ticket.seckill.vo.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @Author: Shawn Chen
 * @Date: 2023/6/25
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户表", tags = "用户表")
public class TUserController {


    @Autowired
    private ITUserService tUserService;
    @Autowired
    private MQSender mqSender;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("返回用户信息")
    public RespBean info(TUser user) {
        return RespBean.success(user);
    }


//    @RequestMapping(value = "/mq", method = RequestMethod.GET)
//    @ResponseBody
//    public void mq() {
//        mqSender.send("Hello");
//    }
//
//    @RequestMapping(value = "/mq/fanout", method = RequestMethod.GET)
//    @ResponseBody
//    public void mqFanout() {
//        mqSender.send("Hello");
//    }
//
//    @RequestMapping(value = "/mq/direct01", method = RequestMethod.GET)
//    @ResponseBody
//    public void mqDirect01() {
//        mqSender.send01("Hello Red");
//    }
//
//    @RequestMapping(value = "/mq/direct02", method = RequestMethod.GET)
//    @ResponseBody
//    public void mqDirect02() {
//        mqSender.send02("Hello Green");
//    }
//
//    @RequestMapping(value = "/mq/topic01", method = RequestMethod.GET)
//    @ResponseBody
//    public void mqtopic01() {
//        mqSender.send03("Hello Red");
//    }
//
//    @RequestMapping(value = "/mq/topic02", method = RequestMethod.GET)
//    @ResponseBody
//    public void mqtopic02() {
//        mqSender.send04("Hello Green");
//    }
//
//    @RequestMapping(value = "/mq/header01", method = RequestMethod.GET)
//    @ResponseBody
//    public void header01() {
//        mqSender.send05("Hello 01");
//    }
//
//    @RequestMapping(value = "/mq/header02", method = RequestMethod.GET)
//    @ResponseBody
//    public void header02() {
//        mqSender.send06("Hello 02");
//    }


    @GetMapping("/createuser")
    @ApiOperation("压测创建配置文件")
    public void CreateUser() throws IOException {
        List<TUser> list = new ArrayList<>();
        //生成用户
//        for (int i = 0; i < 100; i++) {
//            TUser tUser = new TUser();
//            tUser.setId(1233L + i);
//            tUser.setNickname("user" + i);
//            tUser.setSalt("1a2b3c");
//            tUser.setPassword("05314c6fbe1d0cdb5eab4e80f1bda30a");
//            list.add(tUser);
//        }
//        tUserService.saveBatch(list);
//        System.out.println("create user");

        //读取用户
        list = tUserService.list();

        //登录，生成UserTicket
        String urlString = "http://localhost:8080/login/doLogin";
        File file = new File("/Users/lichao/Downloads/config.txt");
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(0);
        for (int i = 0; i < list.size(); i++) {
            TUser tUser = list.get(i);
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            String params = "mobile=" + tUser.getId() + "&password=c38dc3dcb8f0b43ac8ea6a70b5ec7648";
            outputStream.write(params.getBytes());
            outputStream.flush();
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) >= 0) {
                byteArrayOutputStream.write(buff, 0, len);
            }
            inputStream.close();
            byteArrayOutputStream.close();
            String respone = new String(byteArrayOutputStream.toByteArray());
            ObjectMapper mapper = new ObjectMapper();
            RespBean respBean = mapper.readValue(respone, RespBean.class);
            String userTicket = (String) respBean.getObject();
            System.out.println("create userTicket:" + tUser.getId());
            String row = tUser.getId() + "," + userTicket;
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(row.getBytes());
            randomAccessFile.write("\r\n".getBytes());
            System.out.println("write to file :" + tUser.getId());
        }
        randomAccessFile.close();
        System.out.println();
    }
}
