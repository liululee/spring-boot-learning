package com.developlee.springbootopenapi.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Ball {

    /**
     * 主键
     */
    private long id;

    /**
     * 种类
     */
    @NotBlank
    @Size(max = 30)
    private String category;

    /**
     * 所属人
     */
    @Size(max = 25)
    private String owner;

    /**
     * 几人一组
     */
    @Max(50)
    private Integer players;
}
