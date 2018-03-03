package poll.models.poll;

import java.util.List;

public interface PollDAO {

	public void createPoll(String question, List<Choice> choices, Long ownerId);
	public void updatePoll(Poll p);
	public void deletePoll(Long pollId);
	public Poll findPollById(Long pollId);
	List<Poll> findPollByOwernId(Long ownerId);
}
