package com.dongxiang.demospringboot07swagger.dao.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * author:dongxiang
 * data:2018/7/4 11:48
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note:
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
 */
@ApiModel
public class User implements Serializable {

    private static  final long serialVersionID=1l;

    private long id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
