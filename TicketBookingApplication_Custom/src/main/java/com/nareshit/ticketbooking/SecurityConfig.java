package com.nareshit.ticketbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
// This annotation considers SecurityConfig.class ==> Default Security Filter 
//Here webSecurityConfigure Adapter does not consider as default security filter
public class SecurityConfig {
	
	
	//Authentication
	/*
	 *  Create two Users with Roles
	 *  1) Nareshitadmin/Nareshitadmin ==> Admin
	 *  2) NareshitGuest/NareshitGuest ==> Guest
	 */
	@Autowired
	public void configure_global(AuthenticationManagerBuilder authenticationObj) throws Exception {
		
		authenticationObj.inMemoryAuthentication().withUser("nareshitadmin").password("{noop}nareshitadmin")
		.roles("ADMIN");
		
		
		
		authenticationObj.inMemoryAuthentication().withUser("nareshitguest").password("{noop}nareshitguest")
		.roles("GUEST");
		
	}
	
	
	
	
	//Authorization
	
	/*
	 * Defining Authorization Rules
	 * Admin Role Can access All Ticket API and Individual Ticket
	 * Guest Role can Access Individual Ticket API
	 */
	
	
	//Default Authorzation ==> NO Authorization
	@Bean
	public SecurityFilterChain configure(HttpSecurity authorizationObj) throws Exception {
		
		
		//formLogin() == Renders Login Page
		/*authorizationObj.csrf().disable() //This Line I will explain tomarrow
		.authorizeRequests().antMatchers("/ticket/all/**").hasAnyRole("ADMIN")
		.and().formLogin();*/
		
		
		authorizationObj.csrf().disable() //This Line I will explain tomarrow
		.authorizeRequests().antMatchers("/ticket/all/**").hasAnyRole("ADMIN")
		.and().httpBasic();
		
		
		/*authorizationObj.csrf().disable()
		.authorizeRequests().antMatchers("/ticket/get/**").hasAnyRole("ADMIN","GUEST")
		.and().formLogin();*/
		
		authorizationObj.csrf().disable()
		.authorizeRequests().antMatchers("/ticket/get/**").hasAnyRole("ADMIN","GUEST")
		.and().httpBasic();
		
		return authorizationObj.build();
		
	}
	

}
