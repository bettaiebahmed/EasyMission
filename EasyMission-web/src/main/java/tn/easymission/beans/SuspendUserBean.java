package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.easymission.controllers.Home;
import tn.easymission.entities.Agent;
import tn.easymission.entities.Analyse;
import tn.easymission.entities.Candidature;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.Notification;
import tn.easymission.entities.Offre;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="SuspendUserBean")
@ViewScoped
public class SuspendUserBean {
	
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String title;
	private String feedBack;
	private String location;
	private int rating;
	private String agentSkills;
	private String isValid;
	public String suspended;
	
	private static final long serialVersionUID = 1L;


	@EJB  
	LocalUser myService;

    
    
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getFeedBack() {
		return feedBack;
	}



	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public String getAgentSkills() {
		return agentSkills;
	}



	public void setAgentSkills(String agentSkills) {
		this.agentSkills = agentSkills;
	}



	public String getIsValid() {
		return isValid;
	}



	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}



	public LocalUser getMyService() {
		return myService;
	}



	public void setMyService(LocalUser myService) {
		this.myService = myService;
	}

	
	
	 public String getSuspended() {
		return suspended;
	}



	public void setSuspended(String suspended) {
		this.suspended = suspended;
	}



	@ManagedProperty(value="#{navigationBean}")
	    private NavigationBean navigationBean;
	 
	 
	 
	 public void setNavigationBean(NavigationBean navigationBean) {
	        this.navigationBean = navigationBean;
	    }
	 
	 public ArrayList<User> getUsers(){
		   
			return (ArrayList<User>) this.myService.findAll();
		 }
	 public Agent getUserbyId(int id)
	 {
		 
		 return this.myService.findAgentById(id);
	 }
	 public void doSuspend(int id)
	 {
		 if (suspended==null||suspended!="closed")
		 {
			 this.myService.doSuspend(id);
			 suspended="closed";
		 }
			 
else
		 {
			 this.myService.UnSuspend(id);

			 suspended="opened";

		 }
	 }
	 


}
