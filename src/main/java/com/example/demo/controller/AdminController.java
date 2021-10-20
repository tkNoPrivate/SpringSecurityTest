package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    /**
     * 管理者ページ遷移処理
     *
     * @return 管理者画面
     */
    @GetMapping("/admin")
    public String adminPageTransition() {
        return "admin";
    }
}
