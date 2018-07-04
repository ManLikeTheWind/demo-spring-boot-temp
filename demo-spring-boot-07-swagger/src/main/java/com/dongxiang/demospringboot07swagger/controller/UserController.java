package com.dongxiang.demospringboot07swagger.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.dongxiang.demospringboot07swagger.dao.entities.User;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * author:dongxiang
 * data:2018/7/4 12:26
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note:
 * <p>restful 风格接口</p>
 * <p>
 * 注解描述
 *
 * <li>@Api：描述Controller</li>
 * <li>@ApiIgnore：忽略该Controller，指不对当前类做扫描</li>
 * <li> @ApiOperation：描述Controller类中的method接口</li>
 * <li> @ApiParam：单个参数描述，与@ApiImplicitParam不同的是，他是写在参数左侧的。
 * <br><b>如（@ApiParam(name = "username",value = "用户名") String username）</li>
 * <li>@ApiModel：描述POJO对象</li>
 * <li>@ApiProperty：描述POJO对象中的属性值</li>
 * <li>@ApiImplicitParam：描述单个入参信息</li>
 * <li>@ApiImplicitParams：描述多个入参信息</li>
 * <li>@ApiResponse：描述单个出参信息</li>
 * <li>@ApiResponses：描述多个出参信息</li>
 * <li>@ApiError：接口错误所返回的信息</li>
 */

@Controller
@ResponseBody
@RequestMapping(value = {"/UserController"})
@Api(tags = {"1.1"}, description = "用户管理",position = 0)
public class UserController {

    private static final Logger mLogger = LoggerFactory.getLogger(UserController.class);

/** http://localhost:8080/UserController?username=dfa&password=asdf */
    @GetMapping
    @ApiOperation(value = "条件查询（DONE）")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username", value = "用户名", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "password", value = "密码", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY)
    })
    public User queryUser(String username, String password) {
        mLogger.info("多个参数用 @ApiImplicitParams");
        return new User(1l, username, password);
    }


    @GetMapping(value = {"/{id}"})
    @ApiOperation(value = "主键查询（DONE）")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH)
    })
    public User get(@PathVariable Long id) {
        mLogger.info("单个参数用  @ApiImplicitParam");
        return new User(id, "u1", "p1");
    }

    @DeleteMapping(value = {"/{id}"})
    @ApiOperation(value = "主键删除用户 - DONE")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH)
    public void delete(@PathVariable Long id) {
        mLogger.info("单个参数 使用ApiImplicitParam");
    }

    @PostMapping
    @ApiOperation(value = "用户添加用户 - DONe")
    public User post(@RequestBody User user) {
        mLogger.info("如果是POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return user;
    }


    @PutMapping("/{id}")
    public void put(@PathVariable Long id) {
        mLogger.info("如果不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数作为描述信息");
    }


}
