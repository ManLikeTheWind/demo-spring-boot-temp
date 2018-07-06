package com.dongxiang.demospringboot11validating1.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.dongxiang.demospringboot11validating1.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import javax.validation.constraints.NotEmpty;

/**
 * author:dongxiang
 * <br/>data:2018/7/5 17:12
 * <br/>email:dongxiang_android_sdk2@aliyun.com
 * <br/>description:<h>参数校验</h>
 * <br/>function:
 * <br/>using:
 * <br/>note:
 * <p>控制层-service层都可以使用验证</p>
 * <li>1.@Validated:开启数据有效性验证：
 * <br/>......1.添加在类上，即为验证方法；
 * <br/>......2.添加在方法上，无效；
 * <br/>......3.添加在方法参数中，即为验证参数对象；</li>
 * <li>2.@NotBlank：字符串不允许为空(value!=null && value.trim()>0)</li>
 * <li>3.@Length：字符串的大小不许在指定范围内</li>
 * <li>4.@NotNull：对象不允许为空（value!=null）</li>
 * <li>5.@DemicalMin:数字必须大于或等于指定的数值</li>
 *
 * <b>link http://blog.battcn.com/2018/06/05/springboot/v2-other-validate1/
 */
@Validated
@RestController
@RequestMapping(value = {"/ValidationController"})
@Api(tags = "1 ", description = "数据验证  方案一")
public class ValidationController {

    private static final Logger mLogger = LoggerFactory.getLogger(ValidationController.class);

    @ApiOperation(value = "条件查询-发送字符串-done")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "name", value = "名字", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY)
    })
    @GetMapping(value = {"/test2"})
    public String test2(@NotEmpty(message = "name 不能为空") @Length(min = 2, max = 10, message = "name 去掉前后空格后，长度必须在{min}-{max}") String name) {
        return "测试成功";
    }

    @ApiOperation(value = "条件查询--发送对象")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "user",value = "发送的用户对象",dataType = "User 对象",paramType = ApiParamType.QUERY)
    })
    @GetMapping("/test3")
    public String test3(User user) {
        mLogger.info("test3测试成功 user ={}", user);

        return "测试成功";
    }


}
