package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Part;


import tn.easymission.entities.Admin;
import tn.easymission.entities.Agent;
import tn.easymission.entities.Analyse;
import tn.easymission.entities.Candidature;
import tn.easymission.entities.Client;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.Notification;
import tn.easymission.entities.Offre;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="UpdateUserBean")
@ViewScoped
public class UpdateUserBean {
	private Agent agent = new Agent();
	private Client client = new Client();
	
	
	private static final long serialVersionUID = 1L;


	@EJB  
	LocalUser myService;

	@PostConstruct
	public void init ()
	{
		
		String valueAgent=null;
		String valueClient=null;
		int idAgent=0;
		int idClient=0;
	
		try {
			 valueAgent = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAgent");
			 valueClient = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idClient");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (valueAgent!=null)
		{
			 idAgent = Integer.parseInt(valueAgent);
             agent=myService.findAgentById(idAgent);
		}
		if (valueClient!=null)
		{
			 idClient = Integer.parseInt(valueClient);
            client=myService.findClientById(idClient);
		}

	}
	



	public Agent getAgent() {
		return agent;
	}




	public Client getClient() {
		return client;
	}




	public Agent getAgent(int id) {
		agent =myService.findAgentById(id);
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Client getClient(int id) {
		client=myService.findClientById(id);
		return client;
		}

	public void setClient(Client client) {
		this.client = client;
	}
	@ManagedProperty(value="#{navigationBean}")
	    private NavigationBean navigationBean;
	 
	 
	
	
	
	
	

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public String updateAgent()
	{
		myService.updateAgent(agent);
		return "sucess";
	}
	public String updateClient()
	{
		myService.updateClient(client);
		return "sucess";
	}
 
	
	

}
