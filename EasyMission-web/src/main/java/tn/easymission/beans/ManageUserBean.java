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

import tn.easymission.entities.Agent;
import tn.easymission.entities.Analyse;
import tn.easymission.entities.Candidature;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.Notification;
import tn.easymission.entities.Offre;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="ManageUserBean")
@SessionScoped
public class ManageUserBean {
	
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

	 @ManagedProperty(value="#{navigationBean}")
	    private NavigationBean navigationBean;
	 
	 
	 
	 public void setNavigationBean(NavigationBean navigationBean) {
	        this.navigationBean = navigationBean;
	    }
	 
	public String verifier(){
		 Agent u = new Agent(login, password, firstName, lastName, email, title, feedBack, location, rating, agentSkills);
		 Boolean v = false;
		 v=myService.add(u);
		 if(v==true)
		 {
               return navigationBean.toSuspendUser();
		 }
		 FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
	        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	         return null;
	       
	 }
	
	public int getUserNumber()
	{ int i = 0;
	  
		List<User> users=  myService.findAll();
		for (User user : users) {
			i++;
		}
		
		return i;
	}

}
