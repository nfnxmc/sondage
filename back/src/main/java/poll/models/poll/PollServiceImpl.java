package poll.models.poll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PollServiceImpl implements PollService {
	
	@Autowired
	PollDAO pollDAO;
	
	
	@Override
	public void createPoll(String question, List<Choice> choices, Long ownerId) {
		this.pollDAO.createPoll(question, choices, ownerId);
	}

	@Override
	public void deletePoll(Long pollId) {
		this.pollDAO.deletePoll(pollId);

	}

	@Override
	public void updatePoll(Poll p) {
		this.pollDAO.updatePoll(p);
	}

	@Override
	public Poll findPollById(Long pollId) {
		return this.pollDAO.findPollById(pollId);
	}

	@Override
	public Poll findPollByQuestion(String question) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
