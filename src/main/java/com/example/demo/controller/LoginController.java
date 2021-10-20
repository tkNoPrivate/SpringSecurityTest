package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログインコントローラー
 *
 * @author tk
 */
@Controller
public class LoginController {

	/**
	 * ログイン処理
	 *
	 * @return ログイン画面
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}
