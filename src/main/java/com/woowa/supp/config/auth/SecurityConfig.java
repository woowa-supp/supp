package com.woowa.supp.config.auth;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.woowa.supp.domain.user.Role;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
			.disable()
			.headers()
			.frameOptions()
			.disable()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/v1/**")
			.permitAll()
			.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile", "/developer/**")
			.permitAll()
			.antMatchers(HttpMethod.POST, "/api/v1/**").hasRole(Role.USER.name())
			.antMatchers(HttpMethod.PUT, "/api/v1/**").hasRole(Role.USER.name())
			.antMatchers(HttpMethod.DELETE, "/api/v1/**").hasRole(Role.USER.name())
			.anyRequest()
			.authenticated()
			.and()
			.cors()
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.and()
			.oauth2Login()
			.userInfoEndpoint()
			.userService(customOAuth2UserService);
	}
}