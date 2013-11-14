/**
 * 
 */
package tw.howie.sample.jetty.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author howie_yu
 * 
 */
public class DummyUserDetailsService implements UserDetailsService {
	private final Logger logger = LoggerFactory.getLogger(DummyUserDetailsService.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("username:{}", username);
		return new User(username, "notUsed", true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_USER"));
	}
}
