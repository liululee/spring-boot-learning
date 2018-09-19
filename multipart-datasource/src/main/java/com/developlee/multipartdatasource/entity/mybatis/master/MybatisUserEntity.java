package com.developlee.multipartdatasource.entity.mybatis.master;

import lombok.Data;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/18 16:36
 */
@Data
public class MybatisUserEntity {
    private long id;
    private String username;
    private String password;
    private String mobile;
}
