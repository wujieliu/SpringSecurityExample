package com.lolixx.example.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic() // HTTP Basic方式
//                .and()
//                .authorizeRequests() // 授权配置
//                .anyRequest()  // 所有请求
//                .authenticated(); // 都需要认证
//        http.formLogin() // 表单方式
//                .and()
//                .authorizeRequests() // 授权配置
//                .anyRequest()  // 所有请求
//                .authenticated(); // 都需要认证
        http.formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/login.html").permitAll()
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable();
    }
}
