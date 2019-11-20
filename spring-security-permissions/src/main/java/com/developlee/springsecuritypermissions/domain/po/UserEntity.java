package com.developlee.springsecuritypermissions.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: liululee
 * @since: 2019/5/10-23:00
 * @description:
 **/
@Data
@Entity
@Table(name = "tb_users")
public class UserEntity {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column
    private String username;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 是否锁定
     */
    @Column
    private boolean isLocked;

    /**
     * 是否过期
     */
    @Column
    private boolean isExpired;

    /**
     * 是否启用
     */
    @Column
    private boolean isEnabled;
}
