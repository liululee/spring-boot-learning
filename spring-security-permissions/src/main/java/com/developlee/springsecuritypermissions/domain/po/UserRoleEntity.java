package com.developlee.springsecuritypermissions.domain.po;

import lombok.*;

import javax.persistence.*;

/**
 * @author liululee
 * @desc
 * @since 2019/5/28 0028
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_users_roles")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "role_id")
    private RoleEntity roleEntity;
}
