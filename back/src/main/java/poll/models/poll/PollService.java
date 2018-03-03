package poll.models.poll;

import java.util.List;

public interface PollService {

	public void createPoll(String question, List<Choice> choices, Long ownerId);
	public void deletePoll(Long pollId);
	public void updatePoll(Poll p);
	public Poll findPollById(Long pollId);
	public Poll findPollByQuestion(String question);
}
