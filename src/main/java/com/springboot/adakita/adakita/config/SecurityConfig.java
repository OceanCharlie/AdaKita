package com.springboot.adakita.adakita.config;

import com.springboot.adakita.adakita.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final LoginService loginService;

    @Autowired
    public SecurityConfig(LoginService loginService) {
        this.loginService = loginService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return loginService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(loginService);
        return provider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login/auth").permitAll();
                    httpForm.defaultSuccessUrl("/home", true);
                })
                .logout(logout -> {
                    logout.logoutUrl("/logout");
                    logout.logoutSuccessUrl("/home");
                    logout.invalidateHttpSession(true);
                    logout.clearAuthentication(true);
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home", "/", "/register", "/register/personal" , "/css/**", "/js/**", "/images/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();
    }

}
