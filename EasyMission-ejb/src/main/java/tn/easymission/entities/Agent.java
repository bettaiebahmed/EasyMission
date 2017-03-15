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

	
	private String title;
	private String feedBack;
	private String location;
	private List<EmployementHistory> workHistory;
	private int rating;
	private List<Offre>offres;
	private List<Candidature> candidatures;
	private Analyse analyse;
	private String agentSkills;
	private String isValid;
	private List<Notification>notifications;
	private static final long serialVersionUID = 1L;

	
	

	public Agent(String login, String password, String firstName, String lastName, String email, String title,
			String feedBack, String location, int rating, String agentSkills) {
		super(login, password, firstName, lastName, email);
		this.title = title;
		this.feedBack = feedBack;
		this.location = location;
		this.rating = rating;
		this.agentSkills = agentSkills;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAgentSkills() {
		return agentSkills;
	}

	public void setAgentSkills(String agentSkills) {
		this.agentSkills = agentSkills;
	}

	public String getFeedBack() {
		return this.feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}   
	
	
	@OneToMany(mappedBy = "agent")
	public List<EmployementHistory> getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(List<EmployementHistory> workHistory) {
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
