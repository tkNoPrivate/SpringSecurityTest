package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.demo.service.impl.UserDetailsServiceImpl;

/**
 * セキュリティ設定
 *
 * @author tk
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**", "/css/**", "/javascript/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ログイン処理の設定
        http.formLogin().loginPage("/login")// ログイン画面
                .loginProcessingUrl("/authenticate")// ログイン処理
                .successForwardUrl("/")// 認証成功時の遷移URL
                .failureUrl("/login?error")// 認証失敗時の遷移URL
                .usernameParameter("username")// ユーザー名の項目名
                .passwordParameter("password")// パスワードの項目名
                .permitAll();

        // ログアウトの処理
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true)
                .permitAll();

        // 権限の設定
        http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").anyRequest()
                .authenticated();

    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

}
