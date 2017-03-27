package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Commentaire
 *
 */
@Entity

public class Feedback implements Serializable {

	private FeedBackPk idFeedBack;
	private int rate;
	private String description;
	private User userLeft,userRight;
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
	}

	@EmbeddedId
	public FeedBackPk getIdFeedBack() {
		return idFeedBack;
	}

	public void setIdFeedBack(FeedBackPk idFeedBack) {
		this.idFeedBack = idFeedBack;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne
	@JoinColumn(name="idUserleft",referencedColumnName="idUser",insertable=false,updatable=false)

	public User getUserLeft() {
		return userLeft;
	}

	public void setUserLeft(User userLeft) {
		this.userLeft = userLeft;
	}
	@ManyToOne
	@JoinColumn(name="idUserRight",referencedColumnName="idUser",insertable=false,updatable=false)

	public User getUserRight() {
		return userRight;
	}

	public void setUserRight(User userRight) {
		this.userRight = userRight;
	}
	
	
	
	
	
	
}
