package com.example.courserestapi.config;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.inMemoryAuthentication().withUser("qulu").
        password("123").
        roles("USER").
        and().
        withUser("resad")
        .password("2003")
        .roles("ADMIN");

    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/welcome", "/").permitAll().antMatchers("/courses").hasRole("ADMIN")
                .antMatchers("/{id}").hasAnyRole("ADMIN", "USER").anyRequest().authenticated().and().formLogin().and().logout();
    }

@Bean
   public PasswordEncoder getPassword() {
    return NoOpPasswordEncoder.getInstance();
}
}
