package com.example.demo.model;

/**
 * ユーザー情報モデル
 *
 * @author tk
 *
 */
public class User {

    /** ユーザー名 */
    private String username;

    /** パスワード */
    private String password;

    /** 権限リスト */
    private String authority;

    /**
     * ユーザー名取得
     *
     * @return ユーザー名
     */
    public String getUsername() {
        return username;
    }

    /**
     * ユーザー名設定
     *
     * @param username ユーザー名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * パスワード取得
     *
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワード設定
     *
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 権限リスト取得
     *
     * @return 権限リスト
     */
    public String getRole() {
        return authority;
    }

    /**
     * 権限リスト設定
     *
     * @param role 権限リスト
     */
    public void setRole(String role) {
        this.authority = role;
    }

}
