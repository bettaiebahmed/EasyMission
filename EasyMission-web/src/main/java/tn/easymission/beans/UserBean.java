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
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="UserBean")
@SessionScoped
public class UserBean {
	private int id;
	private String title;
	private String location;
	private String DateStart;
	private String DateEnd;
	private String Responsabilities;
	private String Skills;
	
	private ArrayList<EmployementHistory> list;
	
	public ArrayList<EmployementHistory> getList() {
		return list;
	}



	public void setList(ArrayList<EmployementHistory> list) {
		this.list = list;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getDateStart() {
		return DateStart;
	}



	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}



	public String getDateEnd() {
		return DateEnd;
	}



	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}



	public String getResponsabilities() {
		return Responsabilities;
	}



	public void setResponsabilities(String responsabilities) {
		Responsabilities = responsabilities;
	}



	public String getSkills() {
		return Skills;
	}



	public void setSkills(String skills) {
		Skills = skills;
	}



	@EJB  
	LocalUser myService;

    
    
	public ArrayList<EmployementHistory> verifier(int id){
		 
		return (ArrayList<EmployementHistory>) this.myService.getResume(id);
	 }

}
