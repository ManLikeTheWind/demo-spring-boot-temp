package com.dongxiang.demospringboot10globalexception.controller;

import com.dongxiang.demospringboot10globalexception.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * author:dongxiang
 * data:2018/7/5 15:32
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note:
 * <p>异常处理办法</p>
 * <li>1.try-catch 捕获异常，然后将异常抛出</li>
 * <li>2.自定义异常，然后进行抛出异常</li>
 */
@Controller
@RequestMapping(value = {"/ExceptionController"})
public class ExceptionController {

    @ResponseBody
    @RequestMapping(value = {"/test1"},method = RequestMethod.GET)
    public String test1(){
        //TODO 这里只是模拟异常
        int i=10/0;
        return "test1";
    }

    @ResponseBody
    @RequestMapping(value = {"/test2"},method = RequestMethod.GET)
    public Map<String,String> test2(){
        Map<String ,String > result=new HashMap<>(16);
        try {
            int i=10/0;
            result.put("code", "200");
            result.put("data", "具体返回的结果集");
        }catch (Exception e){
            e.printStackTrace();
            result.put("code", "500");
            result.put("message", "请求错误");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/test3"},method = RequestMethod.GET)
    public String test3(Integer num){
        if (num==null||num==0){
            throw new CustomException("num cannot be "+num,400);
        }
        int i=10/num;
        return "result : = "+i;
    }


    @ResponseBody
    @RequestMapping(value = {"/test4"},method = RequestMethod.GET)
    public String test4(Integer num){
        int i=10/num;
        return "result : = "+i;
    }






}
