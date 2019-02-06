package com.liululee.springsecuritypart4.domain.vo;

import com.liululee.springsecuritypart4.domain.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 该类实现UserDetails
 * @author developlee
 * @since 2019/1/15 14:48
 */
public class AuthUserDetails implements UserDetails {

    private UserEntity userEntity;

    // 构造方法 注入 userEntity
    public AuthUserDetails (UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userEntity.isExpiredIn();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userEntity.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.isEnabled();
    }
}
