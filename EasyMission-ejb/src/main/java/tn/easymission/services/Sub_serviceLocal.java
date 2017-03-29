package tn.easymission.services;

import java.util.List;

import javax.ejb.Local;

import tn.easymission.entities.Promotion;

import tn.easymission.entities.Sub_Service;
@Local
public interface Sub_serviceLocal {

	
	public void Ajouter(Sub_service s1);
	public void Update(Sub_service s1);
	public Boolean Delete(Sub_service s1);
	public List<Promotion> getAll();
}
