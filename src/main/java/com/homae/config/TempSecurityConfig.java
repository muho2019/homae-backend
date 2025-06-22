package com.homae.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 인증 시스템 구현 전까지 임시적으로 보안 해제
 */
@Configuration
@EnableWebSecurity
public class TempSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 보안 기능 비활성화 (API 서버는 보통 사용하지 않음)
                .csrf(AbstractHttpConfigurer::disable)
                // Form 기반 로그인 비활성화
                .formLogin(AbstractHttpConfigurer::disable)
                // HTTP Basic 인증 비활성화
                .httpBasic(AbstractHttpConfigurer::disable)
                // 경로별 접근 권한 설정
                .authorizeHttpRequests(authz -> authz
                        // "/api/"로 시작하는 모든 요청은 인증 없이 허용
                        .requestMatchers("/api/**").permitAll()
                        // 그 외의 모든 요청은 일단 허용 (나중에 필요에 따라 수정)
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}