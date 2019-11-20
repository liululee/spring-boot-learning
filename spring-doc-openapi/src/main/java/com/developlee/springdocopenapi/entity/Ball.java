package com.developlee.springdocopenapi.entity;

import javax.persistence.*;

@Entity
public class Ball {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     *  种类
     */
    @Column
    private String category;

    /**
     * 所属人
     */
    @Column
    private String owner;

    /**
     * 几人一组
     */
    @Column
    private Integer players;
}
