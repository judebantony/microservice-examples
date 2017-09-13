/**
 * 
 */
package com.jba.authserver.provider;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Jude
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		return new CustomUserDetails();
	}

}
