package com.linking.springsecurityremeberme.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 该实体类对应数据库实体
 *
 * @author developlee
 * @since 2019/1/15 14:35
 */
@Table(name = "tb_users")
@Entity
@Data
public class UserEntity {
    private static final long serialVersion = 1432485965L;

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String hometown;

    @Column
    private int age;

    @Column
    private boolean isEnabled;

    @Column
    private boolean isExpiredIn;

    @Column
    public boolean isLocked;
}
