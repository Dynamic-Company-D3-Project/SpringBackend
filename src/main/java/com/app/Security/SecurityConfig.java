package com.app.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/user/login","/user/updateUser","/user/register","/catgeory/categoryList","/catgeory/categoryListWithSubcategory","/catgeory/categoryWithSubCategoryList/{id}").permitAll()
//                    .anyRequest().authenticated()
//            )
        .authorizeRequests(authorizeRequests ->
        authorizeRequests
            .antMatchers("/**").permitAll() // Permit all requests
    )
            .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(point))
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
