package poll.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.exception.InvalidHashException;

import poll.models.user.User;
import poll.models.user.UserNotFoundException;
import poll.models.user.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String useremail = auth.getName();
		String password = (String) auth.getCredentials();
		
		User user = null;
		
		try{
			user = userService.findUser(useremail);
		} catch (UserNotFoundException e) {
			
		}
		
		if(user == null || !user.getEmail().equalsIgnoreCase(useremail)){
			throw new BadCredentialsException("Email not found.");
		}
		
		try {
			if(!Hash.password(password.toCharArray()).verify(user.getPassword())){
				throw new BadCredentialsException("Wrong password.");
			}
			
			Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			return new UsernamePasswordAuthenticationToken(user, password, authorities);
		} catch (InvalidHashException e) {
			throw new BadCredentialsException("Wrong password.");
		}
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
