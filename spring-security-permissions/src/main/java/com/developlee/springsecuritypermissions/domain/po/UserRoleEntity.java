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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserEntity.class)
    private UserEntity userEntity;

    @JoinColumn(name = "role_id")
    @ManyToOne(targetEntity = RoleEntity.class, cascade = CascadeType.ALL)
    private RoleEntity roleEntity;
}
