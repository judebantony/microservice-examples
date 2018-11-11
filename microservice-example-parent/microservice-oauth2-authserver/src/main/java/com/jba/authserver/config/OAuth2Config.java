/**
 * 
 */
package com.jba.authserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.jba.authserver.constant.AuthServerConstants;
import com.jba.authserver.provider.CustomUserDetailsService;

/**
 * @author Jude
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2Config.class);
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	protected JwtAccessTokenConverter jwtTokenEnhancer() {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(AuthServerConstants.JKS),
				AuthServerConstants.SECRET_KEY.toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyStoreKeyFactory.getKeyPair(AuthServerConstants.JWT));
		return converter;
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(AuthServerConstants.CLIENT).autoApprove(true)
				.authorities(AuthServerConstants.FULL_READ, AuthServerConstants.FULL_WRITE)
				.authorizedGrantTypes("authorization_code", "refresh_token", "password", "implicit")
				.scopes(AuthServerConstants.SCOPE);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		LOGGER.info("authenticationManager calss name {} ", authenticationManager.getClass());
		endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer())
				.authenticationManager(authenticationManager).userDetailsService(customUserDetailsService);
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

}
