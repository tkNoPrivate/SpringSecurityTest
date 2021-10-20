package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * ユーザー詳細実装
 *
 * @author tk
 */
public class CustomUserDetails implements UserDetails {

    /** ユーザー名 */
    private String username;

    /** パスワード */
    private String password;

    /** 権限リスト */
    private Collection<? extends GrantedAuthority> authorityList;

    /**
     * コンストラクタ
     *
     * @param username ユーザー名
     * @param password パスワード
     * @param authority 権限リスト
     */
    public CustomUserDetails(String username, String password, String authority) {

        this.username = username;
        this.password = password;
        Collection<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(authority));
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

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
