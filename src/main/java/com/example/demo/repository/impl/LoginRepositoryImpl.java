package com.example.demo.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.User;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.mapper.LoginMapper;

/**
 * ログインリポジトリ実装
 *
 * @author tk
 *
 */
@Repository
public class LoginRepositoryImpl implements LoginRepository{

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User getOne(String username) {

        return loginMapper.getOne(username);
    }
}
