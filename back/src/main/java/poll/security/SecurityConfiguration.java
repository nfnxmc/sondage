package poll.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.authenticationProvider);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		HttpSessionCsrfTokenRepository repo = new HttpSessionCsrfTokenRepository();
		repo.setSessionAttributeName("csrf_token");
		repo.setParameterName("csrf_token");
		http.authorizeRequests()
			.antMatchers("/user/*").authenticated()
			.and()
			.formLogin()
			.and()
			.csrf().csrfTokenRepository(repo);
	}

	
}
