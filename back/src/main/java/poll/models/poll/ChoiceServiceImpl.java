package poll.models.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChoiceServiceImpl implements ChoiceService {
	
	@Autowired
	private ChoiceDAO choiceDAO;

	@Override
	public void createChoice(Choice c) {
		this.choiceDAO.createChoice(c);

	}

	@Override
	public void deleteChoice(Choice c) {
		this.choiceDAO.deleteChoice(c);
	}

	@Override
	public void updateChoice(Choice c) {
		this.choiceDAO.updateChoice(c);
	}

	@Override
	public Choice findChoice(String name, Long pollId) {
		Choice c = this.choiceDAO.findChoice(pollId, name);
		return c;
	}

}
