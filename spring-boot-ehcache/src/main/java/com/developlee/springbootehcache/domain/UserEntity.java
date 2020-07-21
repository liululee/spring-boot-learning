package com.developlee.springbootehcache.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: liululi
 * @date: 2020/7/21
 * @desc:
 */
@Data
@Entity
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;
}
