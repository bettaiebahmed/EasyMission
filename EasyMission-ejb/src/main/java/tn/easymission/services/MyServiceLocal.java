package tn.easymission.services;

import java.util.List;

import javax.ejb.Local;


import tn.easymission.entities.Service;

@Local
public interface MyServiceLocal {

	
	public void Ajouter(Service service);
	//public Boolean Update(Service service);
	public void Update(Service service);
	public void Delete(Service service);
	public List<Service> getAll();
}
