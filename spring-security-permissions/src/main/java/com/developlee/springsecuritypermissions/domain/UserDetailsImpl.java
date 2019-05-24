package com.developlee.springsecuritypermissions.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author: liululee
 * @since: 2019/4/28-21:26
 * @description: 实现UserDetails
 **/
public class UserDetailsImpl implements UserDetails {

    private UserEntity userEntity;

    // 构造方法注入userEntity
    public UserDetailsImpl(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    /**
     * 权限集合
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 设置密码
     * @return
     */
    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    /**
     * 设置用户名
     * @return
     */
    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    /**
     * 账户是否过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        // 设置是否过期属性
        return userEntity.isExpired();
    }

    /**
     * 账户是否锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        // 是否锁定
        return userEntity.isLocked();
    }

    /**
     * 凭证是否过期
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 账户是否启用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        // 是否启用
        return userEntity.isEnabled();
    }
}
