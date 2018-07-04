package com.dongxaing.demospringboot03configlogger.controller;

import com.dongxaing.demospringboot03configlogger.properties.PropertiesMy1;
import com.dongxaing.demospringboot03configlogger.properties.PropertiesMy2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 *
 * 文件名：com.dongxaing.demospringboot03configlogger.controller.PropertiestController
 * <br>   作者：Dongxiang
 * <br>   邮箱：dongxiang_android_sdk@aliyun.com
 * <br>   时间：2018/7/4 21:00
 * <br>   版本： 1.0
 * <br>   功能：
 * <br>   使用：
 * <p>   注释：
 * <li></li>
 * Copyright (c) 2018 Dongxiang-Personal. All rights reserved.
 */
@Controller
@ResponseBody
@RequestMapping(value = {"/PropertiestController"})
@Api(tags = "v 1.1.0",description = "属性映射",value = "属性-my1，my2",position = 0)
public class PropertiestController {

    private PropertiesMy1 mPropertiesMy1;
    private PropertiesMy2 mPropertiesMy2;

    @Autowired
    public PropertiestController(PropertiesMy1 propertiesMy1, PropertiesMy2 propertiesMy2) {
        mPropertiesMy1 = propertiesMy1;
        mPropertiesMy2 = propertiesMy2;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "加载属性-done")
    public Object loadProperties(){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("propertiesMy1", mPropertiesMy1);
        map.put("propertiesMy2", mPropertiesMy2);
        return map;
    }


}
