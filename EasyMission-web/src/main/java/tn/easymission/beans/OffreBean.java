package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.easymission.entities.Offre;
import tn.easymission.entities.Service;
import tn.easymission.services.GestionOffreLocal;

@ManagedBean(name="offreBean")
@ViewScoped
	public class OffreBean {

	
	  private Offre offre=new Offre();
	  private List<Offre> offres=new ArrayList<Offre>();
	  @EJB
	  GestionOffreLocal myService;
	  public List<Service> services;
	  private boolean visible=false;
	
	  public List<Offre> getOffres() {
		return offres;
	  }
	
	  public void setOffres(List<Offre> offres) {
		this.offres = offres;
	  }
	
	  public Offre getOffre() {
		return offre;
	  }
	
	  public void setOffre(Offre offre) {
		this.offre = offre;
	  }
	
	  
	  public List<Service> getServices() {
			return services;
		}


	  public void setServices(List<Service> services) {
		  this.services = services;
	  }
		
	  //public String Doadd(){
		//  System.out.println("in!!!");
		 // myService.add(offre);

		  //System.out.println("succus...!!");
		  //return null;
	  //}
	  
	  public String doDelete(Offre offre){
		myService.delete(offre);
		init();
		 return null;
	  }
	@PostConstruct
	  public void init(){ 
			Offre offre = new Offre();
		  	offres=myService.findAll();
		  	List<Service> services = new ArrayList<Service>();
			
			
		}
	
	  //public List<Offre> offres()
	  //{
		//List<Offre> l = myService.findAll();
      // return l;
	  //}
	
	
	
	  public String initialiser(){
		offre=new Offre();
		setVisible(true);
		return null;
	  }

	  public boolean isVisible() {
		return visible;
	  }

	  public void setVisible(boolean visible) {
		this.visible = visible;
	  }
	
	  public String doUpdate(){
		myService.update(offre);
		setVisible(false);
		init();	
		return null;
	  }
	}

