package com.developlee.multipartdatasource.entity.jpa.secondary;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/27 14:49
 */
@Entity
@Data
@Table(name = "tb_city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String desc;

    @Column
    private Long userId;

}
