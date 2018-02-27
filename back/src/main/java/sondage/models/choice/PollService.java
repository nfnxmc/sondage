package sondage.models.choice;

import java.util.List;

public interface PollService {

	public void createPoll(List<Choice> choices);
	public void deletePoll(Long pollId);
	public void updatePoll(List<Choice> choices);
	public List<Choice> findPollById(Long pollId);
	public List<Choice> findPollByQuestion(String question);
	public void updateChoice(Choice choice);
}
