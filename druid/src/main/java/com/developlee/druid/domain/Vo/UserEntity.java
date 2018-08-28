package com.developlee.druid.domain.Vo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/26 21:37
 */
@Entity
@Data
@Table(name ="tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;
}
