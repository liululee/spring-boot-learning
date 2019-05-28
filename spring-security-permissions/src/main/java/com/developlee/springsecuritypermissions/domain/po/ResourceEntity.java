package com.developlee.springsecuritypermissions.domain.po;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author: liululee
 * @since: 2019/5/12-14:23
 * @description: 资源： resource
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_resources")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 资源链接
    @Column
    private String url;

    // 资源名称
    @Column
    private String name;

    // 资源描述
    @Column
    private String description;

    /**
     * mapperBy：定义在被拥有方，指向拥有方。
     * 定义在ResourceEntity中，即Resource是被Role拥有的。
     * 说明tb_resources 有一个外键指向tb_roles_resources
     * mapperBy was defined in the owned side ,and point to to owning side.
     * so in the project we have to define it in the ResourceEntity,
     * it's mean [Resources] are owned by the [Roles].
     *
     */
    @OneToMany(mappedBy = "resourceEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<RoleResourceEntity> resourceEntitySet;
}
