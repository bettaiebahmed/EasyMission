package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.easymission.entities.Service;
import tn.easymission.services.MyServiceLocal;

@ManagedBean(name="ManageServiceBean")
@ViewScoped
public class ManageServiceBean {
	
	private Service service = new Service();
	private List<Service> services = new ArrayList<Service>();
	private boolean visible=false;
	@EJB
	MyServiceLocal myservice;
	
	@PostConstruct
	public void init(){
		service=new Service();
		services = myservice.getAll();
			
	}
	public String doDelete(Service service){
		myservice.Delete(service);
		init();
		return null;
		
	}
	public String doUpdate() {
		myservice.Update(service);
		setVisible(false);
		init();
		return null;
	}

	public String doAdd() {
		myservice.Ajouter(service);
		setVisible(false);
		init();
		return null;
	} 
	
	public String initialiser()
	{
		
		setVisible(true);
		return null;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}


}
