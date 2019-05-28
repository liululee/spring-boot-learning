package com.developlee.springsecuritypermissions.domain.po;

import lombok.*;

import javax.persistence.*;

/**
 * @author: liululee
 * @since: 2019/5/10-23:00
 * @description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_users")
public class UserEntity {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
