package tn.easymission.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import tn.easymission.entities.User;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client extends User implements Serializable {

	private ArrayList<Offre>offres;
	private List<Candidature>candidatures;
	private List<EmployementHistory> workHistory;
	private Analyse analyse;
	private List<Notification>notifications;
	private static final long serialVersionUID = 1L;
	
	
	public Client()
	{
		super();
	}

	public Client(String login, String password, String firstName, String lastName, String email) {
		super(login, password, firstName, lastName, email);
	}


	public ArrayList<Offre> getOffres() {
		return offres;
	}


	public void setOffres(ArrayList<Offre> offres) {
		this.offres = offres;
	}

	@OneToMany(mappedBy = "client")
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

	@OneToMany(mappedBy = "client")
	public List<Notification> getNotifications() {
		return notifications;
	}


	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@OneToMany(mappedBy = "client")
	public List<EmployementHistory> getWorkHistory() {
		return workHistory;
	}


	public void setWorkHistory(List<EmployementHistory> workHistory) {
		this.workHistory = workHistory;
	}
   
	
	
	
	
	
	
	
	
	
}
