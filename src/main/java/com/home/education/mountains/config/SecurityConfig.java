package com.home.education.mountains.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("roman").password("123456").roles("USER");
		  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.httpBasic().and().authorizeRequests()
		//.antMatchers("/Mountains/location").access("hasRole('ROLE_USER')")
		.antMatchers("/Mountains**").access("hasRole('ROLE_ADMIN')")
		//.antMatchers("/Mountains/mountain**").access("hasRole('ROLE_USER')")
		//.antMatchers("/Mountains/route**").access("hasRole('ROLE_USER')")
		.and().csrf().disable();
		
	}
}
