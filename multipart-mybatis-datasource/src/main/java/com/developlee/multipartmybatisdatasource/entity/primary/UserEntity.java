package com.developlee.multipartmybatisdatasource.entity.primary;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/19 10:42
 */
@Data
public class UserEntity implements Serializable {
    private static final Long serialVersion = -2134215435L;
    private Long id;
    private String name;
    private String mobile;
}
