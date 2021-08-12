package com.msp.kg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.msp.kg.enums.RolEnum;
import com.msp.kg.security.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl userDetailService;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bCrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		http.authorizeRequests().antMatchers(ResourceList.RES_PUBLIC).permitAll()				
				.antMatchers(ResourceList.RES_ADMIN).hasRole(RolEnum.ADMIN.toString())
				.antMatchers(ResourceList.RES_CIUDADANO).hasRole(RolEnum.CIUDADANO.toString())
				.anyRequest().authenticated().and().httpBasic()				
				.and()
				.formLogin().permitAll()
				.and()
				.logout().permitAll()
				.and().csrf().disable();
		
		
		/*
		http.authorizeRequests().antMatchers(ResourceList.RES_PUBLIC).permitAll()				
		.antMatchers(ResourceList.RES_ADMIN).hasRole(RolEnum.ADMIN.toString())
		.antMatchers(ResourceList.RES_CIUDADANO).hasRole(RolEnum.CIUDADANO.toString())
		.antMatchers(ResourceList.RES_CIUDADANO).access("hasRole('"+RolEnum.CIUDADANO+"')")
		.anyRequest().authenticated().and().httpBasic()
		.and()
		.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/menu").failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password")
		.and()
		.logout().permitAll().logoutSuccessUrl("/login?logout"); 
		*/
	}
}
