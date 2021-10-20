package com.example.demo.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.User;

/**
 * ログインマッパー
 *
 * @author tk
 */
@Mapper
public interface LoginMapper {

    /**
     * ユーザー情報取得処理
     *
     * @param username ユーザー名
     * @return ユーザー情報
     */
    User getOne(String username);
}
