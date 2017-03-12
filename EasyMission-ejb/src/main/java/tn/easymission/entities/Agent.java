package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.easymission.entities.User;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity

public class Agent extends User implements Serializable {

	
	private String feedBack;
	private String workHistory;
	private int rating;
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}   
	public String getFeedBack() {
		return this.feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}   
	public String getWorkHistory() {
		return this.workHistory;
	}

	public void setWorkHistory(String workHistory) {
		this.workHistory = workHistory;
	}   
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
   
}
