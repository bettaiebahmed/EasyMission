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
import tn.easymission.entities.Client;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.FeedBackListing;
import tn.easymission.entities.Feedback;
import tn.easymission.entities.Offre;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="feedBackBean")
@SessionScoped
public class feedBackBean {
	private int rate;
	private String description;
	private User userRight;
	private User userLeft;
	@EJB  
	LocalUser myService;
	
	
	
	
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
	
		
	
	
	
	public User getUserRight() {
		return userRight;
	}
	public void setUserRight(User userRight) {
		this.userRight = userRight;
	}
	public User getUserLeft() {
		return userLeft;
	}
	public void setUserLeft(User userLeft) {
		this.userLeft = userLeft;
	}
	public List<FeedBackListing> feedBacks()
	{
		List<Feedback> feeds= myService.getFeedBacks();
		List<FeedBackListing> feedsNew = new ArrayList<>();
		FeedBackListing f = new FeedBackListing();
		for (Feedback feedback : feeds) {
		
			description=feedback.getDescription();
			rate=feedback.getRate();
			f.setUserRight(feedback.getUserRight().getFirstName());
			f.setUserLeft(feedback.getUserLeft().getFirstName());
            f.setRate(rate);
            f.setDescription(description);
            feedsNew.add(f);
		}
		return  feedsNew;
	}

    
    
	
}
