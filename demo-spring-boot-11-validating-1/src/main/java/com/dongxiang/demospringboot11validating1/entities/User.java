package com.dongxiang.demospringboot11validating1.entities;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class User {
    private Integer id;
    @NotBlank(message = "name 不能 为空")
    @Length(min = 2,max = 10,message = "name长度必须在{min}-{max}之间")
    private String name;
    @NotNull(message = "price 不允许为null")
    @DecimalMax(value = "0.1",message = "价格不能低于{value}")
    private BigDecimal price;

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
