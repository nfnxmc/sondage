package poll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poll.models.poll.Choice;
import poll.models.poll.ChoiceService;

@RestController
public class ChoiceController {

	@Autowired
	ChoiceService cs;
	
	@PostMapping(name="/update/choice", produces="application/json")
	public Choice updateChoice(@RequestParam Choice choice){
		this.cs.updateChoice(choice);
		return choice;
	}
	
	@GetMapping(name="getchoice/:name/:pollId", produces="application/json")
	public Choice getChoice(@RequestParam(name="name") String name,
			@RequestParam(name="pollId") Long pollId){
		Choice choice = this.cs.findChoice(name, pollId);
		return choice;
	}
}
