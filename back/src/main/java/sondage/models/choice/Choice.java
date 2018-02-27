package sondage.models.choice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Choice")
@NamedQueries({
	@NamedQuery(name="updateChoice", query="update Choice set score = :score where name =:name and pollId = :pollId"),
	@NamedQuery(name="removeChoice", query="delete from Choice where name=:name and pollId=:pollId"),
	@NamedQuery(name="deletePoll", query="delete from Choice where pollId =:pollId"),
	@NamedQuery(name="createChoice", query="insert into Choice(pollId,question, score, name) values (:pollId, :question, :score, :name)"),
	@NamedQuery(name="findChoice", query="select from Choice where name=:name and pollId=:pollId"),
	@NamedQuery(name="findPollById", query="select from Choice where pollId=:pollId"),
	@NamedQuery(name="findPollByQuestion", query="select from Choice where question=:question")
})
public class Choice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long pollId;
	private String question;
	private Long score;
	private String name;
	
	public Choice(){}

	public Long getPollId() {
		return pollId;
	}

	public void setPollId(Long pollId) {
		this.pollId = pollId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
