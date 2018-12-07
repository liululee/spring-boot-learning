package com.developlee.springsecuritypart3.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author developlee
 * @since 2018/11/27 21:38
 */
@Entity
@Table(name = "tb_users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private String age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "isLock")
    private boolean isLock;

    @Column(name = "isEnabled")
    private boolean isEnabled;

}
