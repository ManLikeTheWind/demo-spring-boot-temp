package com.dongxiang.demospringboot11validating1.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 *          <br/>......1.添加在类上，即为验证方法；
 *          <br/>......2.添加在方法上，无效；
 *          <br/>......3.添加在方法参数中，即为验证参数对象；</li>
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
public class ValidationController {


    


}
