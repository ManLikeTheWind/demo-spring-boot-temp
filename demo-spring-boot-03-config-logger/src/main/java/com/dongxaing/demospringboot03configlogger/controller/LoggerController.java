package com.dongxaing.demospringboot03configlogger.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.dongxaing.demospringboot03configlogger.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 文件名：com.dongxaing.demospringboot03configlogger.controller.LoggerController
 * <br>   作者：Dongxiang
 * <br>   邮箱：dongxiang_android_sdk@aliyun.com
 * <br>   时间：2018/7/4 21:34
 * <br>   版本： 1.0
 * <br>   功能：
 * <br>   使用：
 * <p>   注释：
 * <p>restful 风格接口</p>
 *
 *     注解描述
 *
 *     <li>@Api：描述Controller</li>
 *     <li>@ApiIgnore：忽略该Controller，指不对当前类做扫描</li>
 *     <li> @ApiOperation：描述Controller类中的method接口</li>
 *     <li> @ApiParam：单个参数描述，与@ApiImplicitParam不同的是，他是写在参数左侧的。
 *              <br><b>如（@ApiParam(name = "username",value = "用户名") String username）</li>
 *     <li>@ApiModel：描述POJO对象</li>
 *     <li>@ApiProperty：描述POJO对象中的属性值</li>
 *     <li>@ApiImplicitParam：描述单个入参信息</li>
 *     <li>@ApiImplicitParams：描述多个入参信息</li>
 *     <li>@ApiResponse：描述单个出参信息</li>
 *     <li>@ApiResponses：描述多个出参信息</li>
 *     <li>@ApiError：接口错误所返回的信息</li>
 * Copyright (c) 2018 Dongxiang-Personal. All rights reserved.
 */
@Controller
@ResponseBody
@RequestMapping(value = {"/LoggerController"})
@Api(tags = {"1.0"},description = "loggerback-spring.xml配置 检测",position = 1)
public class LoggerController {

    private static final Logger mLogger=LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping(method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ApiOperation(value = "插入一个用户-done")
    public User insertUser(User user){
        mLogger.info("如果是POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return user;
    }

    @DeleteMapping(value = {"/{id}"})
    @ApiOperation(value = "主键删除用户 - DONE")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH)
    public void delete(@PathVariable Long id) {
        mLogger.info("单个参数 使用ApiImplicitParam");
        mLogger.debug("单个参数 使用ApiImplicitParam");
        mLogger.error("单个参数 使用ApiImplicitParam");
        mLogger.warn("单个参数 使用ApiImplicitParam");
        mLogger.trace("单个参数 使用ApiImplicitParam");
    }


    @GetMapping(value = {"/{id}"})
    @ApiOperation(value = "id-查询 done")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id",value = "主键",dataType = ApiDataType.LONG,paramType = ApiParamType.PATH)
    })
    public User queryUserByid(@PathVariable int id){
        mLogger.info("单个参数用  @ApiImplicitParam");
        return new User(id, "username"+id, "password"+id, id);
    }

    /** http://localhost:8080/UserController?username=dfa&password=asdf */
    @GetMapping
    @ApiOperation(value = "条件查询（DONE）")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "age",     value = "用户年龄", dataType = ApiDataType.INT, paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "username", value = "用户账号", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY)
    })
    public User queryUser(int age,String username, String password) {
        mLogger.info("多个参数用 @ApiImplicitParams");
        return new User(age, username, password);
    }


    @PutMapping("/{id}")
    public void put(@PathVariable Long id) {
        mLogger.info("如果不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数作为描述信息");
    }


}
