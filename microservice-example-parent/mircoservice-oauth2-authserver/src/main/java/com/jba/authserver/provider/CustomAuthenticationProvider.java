/**
 * 
 */
package com.jba.authserver.provider;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.jba.authserver.constant.AuthServerConstants;

/**
 * @author Jude
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	public CustomAuthenticationProvider() {
		LOGGER.info("*** CustomAuthenticationProvider created");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		LOGGER.info("User name :: {}", authentication.getName());
		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new SimpleGrantedAuthority(AuthServerConstants.ROLE_USER));
		grantedAuths.add(new SimpleGrantedAuthority(AuthServerConstants.ROLE_ADMIN));
		Authentication objAuthentication = new UsernamePasswordAuthenticationToken(authentication.getName(),
				authentication.getCredentials(), grantedAuths);
		SecurityContextHolder.getContext().setAuthentication(objAuthentication);
		return objAuthentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
