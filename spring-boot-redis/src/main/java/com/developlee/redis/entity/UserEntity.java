package com.developlee.redis.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/27 10:12
 */
@Entity
@Table(name = "tb_user")
@Data
public class UserEntity implements Serializable {

    private final Long serialVersion = -12354325432L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String mobile;
}
