package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import tn.easymission.entities.Candidature;
import tn.easymission.services.GestionCandidatureLocal;

@ManagedBean(name="candidatureBean")
@ViewScoped
public class CandidatureBean {

	private Candidature candidature=new Candidature();
	private List<Candidature> candidatures=new ArrayList<Candidature>();
	
	@EJB
	GestionCandidatureLocal myService;
	private boolean visible=false;
	
	
	public Candidature getCandidature() {
		return candidature;
	}
	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}
	public List<Candidature> getCandidatures() {
		return candidatures;
	}
	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	public String doDelete(Candidature candidature){
		myService.delete(candidature);
		init();
		 return null;
	}
	
	@PostConstruct
	  public void init(){ 
		  	candidatures=myService.findAll();
	}

	

	public String doUpdate(){
		myService.update(candidature);
		setVisible(false);
		init();
		return null;
    }

	public String initialiser(){
		candidature=new Candidature();
		setVisible(true);
		return null;
	}
	
	
	
	
}
