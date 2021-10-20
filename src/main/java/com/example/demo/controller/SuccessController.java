package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * サクセスコントローラー
 *
 * @author tk
 */
@Controller
public class SuccessController {

    /**
     * 認証成功時の処理
     *
     * @return サクセス画面
     */
    @PostMapping("/")
    public String init() {

        return "success";
    }
}
