package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.User;
import com.example.demo.repository.LoginRepository;

/**
 * ユーザー詳細サービス実装
 *
 * @author tk
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = loginRepository.getOne(username);
        if(user == null) {
            throw new UsernameNotFoundException("error!");
        }
        CustomUserDetails customUserDetails =
                new CustomUserDetails(user.getUsername(), user.getPassword(), user.getRole());
        return customUserDetails;
    }

}
