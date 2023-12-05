package com.example.HealthyDog;

import com.example.HealthyDog.Entities.UserEntity;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private long userId;
    private List<GrantedAuthority> authorities;
    private String userNickname;
    private String userEmail;
    private int userPhone;
    private String userPassword;

    public MyUserDetails(UserEntity user){
        this.userId = user.getUserId();
        this.userNickname = user.getUserNickname();
        this.userEmail = user.getUserEmail();
        this.userPhone = user.getUserPhone();
        this.userPassword = user.getUserPassword();
        this.authorities = Arrays.stream(user.getUserRole().split(",")).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userNickname;
    }

    public String getEmail() {return userEmail;}
    public int getPhone() {return userPhone;}
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
