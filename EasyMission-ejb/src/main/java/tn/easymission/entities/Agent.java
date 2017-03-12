package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

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
	private List<Offre>offres;
	private List<Candidature> candidatures;
	private Analyse analyse;
	private List<Notification>notifications;
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
	@ManyToMany
	public List<Offre> getOffres() {
		return offres;
	}
	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	@OneToMany(mappedBy = "agent")
	public List<Candidature> getCandidatures() {
		return candidatures;
	}
	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}
	@OneToOne
	public Analyse getAnalyse() {
		return analyse;
	}
	public void setAnalyse(Analyse analyse) {
		this.analyse = analyse;
	}
	@OneToMany(mappedBy = "agent")
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
   
}
