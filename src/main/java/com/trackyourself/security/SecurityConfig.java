package com.trackyourself.security;

//import com.trackyourself.service.MongoUserDetailsService;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//  final private MongoUserDetailsService detailsService;
//  
//  public SecurityConfig(MongoUserDetailsService detailsService) {
//    this.detailsService = detailsService;
//  }
  
  @Override
  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(detailsService);
    auth.inMemoryAuthentication()
      .withUser("admin").password(passwordEncoder().encode("password")).roles("USER");
  }
  
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .cors().and()
      .authorizeRequests()
      .antMatchers("/is_logged_in").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .and()
      .rememberMe();
  }
//  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowCredentials(true);
    configuration.setAllowedOrigins(Arrays.asList(
      "http://localhost:3000", 
      "http://d1dm4qh0b5fw2m.cloudfront.net", 
      "https://d1dm4qh0b5fw2m.cloudfront.net",
      "http://trackyourself.io",
      "https://trackyourself.io"
    ));
    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
