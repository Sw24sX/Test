package com.example.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
                                                       UserDetailsService userDetailService) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/actuator/**").permitAll()
            .antMatchers("/shop/add")
                .hasAnyRole("ADMIN")
            .antMatchers("/auth/registration")
                .anonymous()
            .antMatchers("/**")
                .hasAnyRole("ADMIN", "USER")
            .anyRequest()
                .authenticated()
            .and()
                .httpBasic()
            .and()
                .formLogin()
                .loginPage("/api/login")
                .permitAll()
                .successHandler(successHandler())
                .failureHandler(failureHandler())
            .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
            .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
                .logoutSuccessHandler(logoutSuccessHandler())
                .logoutUrl("/auth/logout");

        return http.build();
    }

    private AuthenticationSuccessHandler successHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.setStatus(200);
    }

    private LogoutSuccessHandler logoutSuccessHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.setStatus(200);
    }

    private AuthenticationFailureHandler failureHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.getWriter().append("Authentication failure");
            httpServletResponse.setStatus(401);
        };
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.getWriter().append("Access denied");
            httpServletResponse.setStatus(403);
        };
    }

    private AuthenticationEntryPoint authenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.getWriter().append("Not authenticated");
            httpServletResponse.setStatus(401);
        };
    }
}
