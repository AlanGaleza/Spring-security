package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //add our users for in memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("1234").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("1234").roles("MANAGER", "EMPLOYEE"))
                .withUser(users.username("susan").password("1234").roles("EMPLOYEE", "ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //422 433
        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
