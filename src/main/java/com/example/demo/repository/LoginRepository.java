package com.example.demo.repository;

import com.example.demo.model.User;

/**
 * ログインリポジトリ
 *
 * @author tk
 */
public interface LoginRepository {

    /**
     * ユーザー情報取得処理
     *
     * @param username ユーザー名
     * @return ユーザー情報
     */
    User getOne(String username);

}
