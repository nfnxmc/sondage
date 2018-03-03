package poll.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poll.models.poll.Poll;
import poll.models.poll.PollService;
import poll.models.user.User;
import poll.security.CustomAuthenticationProvider;

@RestController
public class SondageController {
	
	@Autowired 
	private CustomAuthenticationProvider authenticationProvider;
	
	@Autowired
	private PollService pollService;
	
	@GetMapping("/poll/:pollId")
	public Poll getPoll(@RequestParam(value="pollId") Long pollId){
		return this.pollService.findPollById(pollId);
	}

	@PostMapping(value="/login")
	public String processLogin(@RequestBody User reqUser, HttpServletRequest req){
		Authentication authentication = null;
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(reqUser.getEmail(), reqUser.getPassword());
		try {
			authentication = this.authenticationProvider.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			User user = (User) authentication.getPrincipal();
			user.setPassword(null);
			return "USER LOGGED SUCCESSFULLY," + user.toString();
		} catch (BadCredentialsException e) {
			return "LOGGING PROCESS FAILED"; 
		}
	}
	
}
