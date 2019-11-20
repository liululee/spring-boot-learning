package com.developlee.springsecuritypermissions.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: liululee
 * @since: 2019/5/12-14:23
 * @description:
 **/
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_resources")
public class ResourceEntity {

    private Long id;

    // 资源链接
    private String url;

    // 资源名称
    private String name;

    // 资源描述
    private String description;
}
