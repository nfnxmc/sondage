package poll.models.poll;

public interface ChoiceService {
	public void createChoice(Choice c);
	public void deleteChoice(Choice c);
	public void updateChoice(Choice c);
	public Choice findChoice(String name, Long pollId);
}
