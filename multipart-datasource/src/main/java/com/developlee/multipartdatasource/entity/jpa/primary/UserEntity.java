package com.developlee.multipartdatasource.entity.jpa.primary;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/23 17:22
 */
@Entity
@Table(name = "tb_user")
@Data
public class UserEntity implements Serializable {
    private final Long serialVersion = -511345623L;

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
