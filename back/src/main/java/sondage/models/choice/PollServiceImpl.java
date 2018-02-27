package sondage.models.choice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PollServiceImpl implements PollService {

	@Autowired
	private ChoiceDAO choiceDAO;
	
	@Override
	public void createPoll(List<Choice> choices) {
		for(Choice c: choices){
			this.choiceDAO.createChoice(c);
		}
	}

	@Override
	public void deletePoll(Long pollId) {
		this.choiceDAO.deleteChoices(pollId);
	}

	@Override
	public void updatePoll(List<Choice> choices) {
		for(Choice c: choices){
			this.choiceDAO.updateChoice(c);
		}

	}

	@Override
	public List<Choice> findPollById(Long pollId) {
		List<Choice> choices = this.choiceDAO.getChoices(pollId);
		return choices;
	}

	@Override
	public List<Choice> findPollByQuestion(String question) {
		List<Choice> choices= this.choiceDAO.getChoices(question);
		return choices;
	}

	@Override
	public void updateChoice(Choice choice) {
		this.choiceDAO.updateChoice(choice);

	}

}
