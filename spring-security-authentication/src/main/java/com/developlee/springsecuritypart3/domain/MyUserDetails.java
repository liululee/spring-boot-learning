package com.developlee.springsecuritypart3.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author developlee
 * @since 2018/11/27 21:42
 */
public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj != null && MyUserDetails.class.isAssignableFrom(obj.getClass())) {
            MyUserDetails details = (MyUserDetails) obj;
            isEqual = new EqualsBuilder().append(details.user.getId(), this.user.getId())
                    .append(details.user.getUsername(), this.user.getUsername()).append(details.user.getPassword(), this.user.getPassword()).isEquals();
        }
        return isEqual;

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(user.getId()).append(user.getUsername()).append(user.getPassword())
                .toHashCode();
    }
}
