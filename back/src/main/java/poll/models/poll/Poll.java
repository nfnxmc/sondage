package poll.models.poll;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Poll")
@Table(name="Poll")
@NamedQueries({
	@NamedQuery(name="deletePoll", query="delete from Poll where Id =:pollId"),
	@NamedQuery(name="findPollById", query="select from Poll where Id=:pollId"),
	@NamedQuery(name="findPollByQuestion", query="select from Poll where question=:question"),
	@NamedQuery(name="findPollByOwnerId", query="select from Poll where ownerId=:ownerId")
})
public class Poll {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long Id;
	
	@Column(name="Question")
	public String question;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Choice> choices;
	
	@Column(name="ownerId")
	public Long ownerId;
	
	public Poll(String q, List<Choice> cs, Long oi){
		this.question = q;
		this.choices = cs;
		this.ownerId = oi;
	}
}
