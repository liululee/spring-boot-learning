package com.developlee.multipartdatasource.entity.jpa.primary;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/23 17:22
 */
@Entity
@Table(name = "tb_user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String pwd;
    @Column
    private String mobile;

}
