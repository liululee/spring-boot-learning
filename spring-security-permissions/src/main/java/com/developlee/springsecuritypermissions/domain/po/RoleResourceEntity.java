package com.developlee.springsecuritypermissions.domain.po;

import lombok.*;

import javax.persistence.*;

/**
 * @author liululee
 * @desc 角色资源关联关系： role and resource relationship
 * @since 2019/5/28 0028
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_roles_resources")
public class RoleResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resourceEntity;

    @Column(name = "status")
    private Integer status;
}
