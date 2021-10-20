package com.example.demo.service.impl;

import org.apache.commons.lang3.StringUtils;
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

        if (StringUtils.isEmpty(username)) {
            // 入力されていない場合は例外をスローする。メッセージは隠蔽される為適当で良い。
            throw new UsernameNotFoundException("error!");
        }
        User user = loginRepository.getOne(username);
        if (user == null) {
            // ユーザーが取得出来なかった場合は例外をスローする。メッセージは隠蔽される為適当で良い。
            throw new UsernameNotFoundException("error!");
        }
        // UserDetails実装クラスに取得情報を詰め替えて、返却する。
        CustomUserDetails customUserDetails =
                new CustomUserDetails(user.getUsername(), user.getPassword(), user.getRole());

        return customUserDetails;
    }

}
