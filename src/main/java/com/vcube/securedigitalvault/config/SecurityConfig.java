package com.vcube.securedigitalvault.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(auth -> auth
						// Allow error dispatches
						.dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()

						// Allow users to register without authentication
						.requestMatchers(HttpMethod.POST, "/api/users").permitAll()

						// Require authentication for all other endpoints
						.anyRequest().authenticated())

				.httpBasic(Customizer.withDefaults());

		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

	    UserDetails devUser = org.springframework.security.core.userdetails.User
	            .withUsername("vaultdev")
	            .password(passwordEncoder.encode("VaultDev@123"))
	            .roles("USER")
	            .build();

	    return new InMemoryUserDetailsManager(devUser);
	}
}