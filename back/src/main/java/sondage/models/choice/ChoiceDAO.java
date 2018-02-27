package sondage.models.choice;

import java.util.List;

public interface ChoiceDAO {

	public void createChoice(Choice c);
	public void deleteChoice(Choice c);
	public void updateChoice(Choice c);
	public Choice findChoice(Long pollId, String name);
	public void deleteChoices(Long pollId);
	public List<Choice> getChoices(Long pollId);
	public List<Choice> getChoices(String question);
}
