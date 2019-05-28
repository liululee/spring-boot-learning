package com.developlee.springsecuritypermissions.domain.po;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Set;

/**
 * @author: liululee
 * @since: 2019/5/12-14:23
 * @description: role： 角色对象
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 角色中文名
    @Column(name = "role_name")
    private String roleName;

    // 角色英文名
    @Column(name = "role_en_name")
    private String roleEnName;

    @OneToMany(mappedBy = "roleEntity")
    private Set<RoleResourceEntity> roleResourceEntitySet;
}
