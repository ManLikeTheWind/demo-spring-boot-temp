package com.dongxiang.demospringboot11validating1.entities;

import com.battcn.swagger.properties.ApiDataType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel
public class User {
    @ApiModelProperty(value = "主键id",dataType = ApiDataType.INT)
    private Integer id;

    @ApiModelProperty(value = "名字")
    @NotBlank(message = "name 不能 为空")
    @Length(min = 2,max = 10,message = "name长度必须在{min}-{max}之间")
    private String name;

    @ApiModelProperty(value = "价格")
    @NotNull(message = "price 不允许为null")
    @DecimalMin(value = "0.1",message = "价格不能低于{value}")
    private BigDecimal price=new BigDecimal(2.0);
//    private double price;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
