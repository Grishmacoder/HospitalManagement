package com.testproject.hospitalManagement.security;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class webSecurityConfig {

    private final OAuth2SuceessHandler oAuth2SuceessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
                        .anyRequest().authenticated()
                )
                .oauth2Login(oAuth2 -> oAuth2
                        .failureHandler(( request,  response,  exception)-> {
                                log.error("OAuth2 error: {}", exception.getMessage());
                            })
                        .successHandler(oAuth2SuceessHandler)

                )
                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();

    }


}
