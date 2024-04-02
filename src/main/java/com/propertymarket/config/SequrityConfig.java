package com.propertymarket.config;


//import com.propertymarket.security.UserServiceDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
public class SequrityConfig {

//    @Bean
//    DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetailsService userDetailsService = new UserServiceDetailsImpl();
//
//        return userDetailsService;
//    }
}
