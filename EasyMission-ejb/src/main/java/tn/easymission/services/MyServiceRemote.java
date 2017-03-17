package tn.easymission.services;

import javax.ejb.Remote;

import tn.easymission.entities.Service;

@Remote
public interface MyServiceRemote {
	
	public void Ajouter(Service service);
	public void Update(Service service);
	public Boolean Delete(Service service);

}
