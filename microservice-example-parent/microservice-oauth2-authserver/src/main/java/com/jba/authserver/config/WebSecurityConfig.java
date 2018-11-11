/**
 * 
 */
package com.jba.authserver.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.jba.authserver.constant.AuthServerConstants;
import com.jba.authserver.provider.CustomAuthenticationProvider;

/**
 * @author Jude
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return new ProviderManager(Arrays.asList((AuthenticationProvider) new CustomAuthenticationProvider()));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling()
				.authenticationEntryPoint(
						(request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and().authorizeRequests().antMatchers(AuthServerConstants.MATCHER).authenticated().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
/*		auth.inMemoryAuthentication().withUser(AuthServerConstants.READER).password(AuthServerConstants.READER)
				.authorities(AuthServerConstants.FULL_READ).and().withUser(AuthServerConstants.WRITER)
				.password(AuthServerConstants.WRITER)
				.authorities(AuthServerConstants.FULL_READ, AuthServerConstants.FULL_WRITE);
*/	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
}
