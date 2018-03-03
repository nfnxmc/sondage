package poll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poll.models.poll.Poll;
import poll.models.poll.PollService;

@RestController
public class PollController {
	
	
	@Autowired
	private PollService pollService;
	
	@GetMapping("/getpoll/:pollId")
	public Poll getPoll(@RequestParam(name="pollId", required=true) Long pollId){
		return this.pollService.findPollById(pollId);
	}

	@DeleteMapping("/deletepoll/:pollId")
	public void deletePoll(@RequestParam(name="pollId", required=true) Long pollId){
		this.pollService.deletePoll(pollId);
	}
	
	@PostMapping("/updatepoll")
	public void updatePoll(@RequestBody Poll poll){
		this.pollService.updatePoll(poll);
	}
	
	
}
