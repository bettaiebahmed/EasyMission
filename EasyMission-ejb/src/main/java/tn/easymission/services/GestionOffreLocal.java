package tn.easymission.services;

import java.util.List;

import javax.ejb.Local;

import tn.easymission.entities.Offre;
import tn.easymission.entities.Service;
import tn.easymission.entities.Sub_Service;

@Local
	public interface GestionOffreLocal {
	
	public Boolean add(Offre offre);
	public Boolean update(Offre offre);
	public Offre findById(int id);
	public Boolean delete(Offre offre);
	public List<Offre> findAll();
//	public void affectServiceToOffre(Offre offre, Service service);
//	public void affectSub_ServiceToOffre(Offre offre, Sub_Service sub_service);
//	public Service findServiceByName(String name);
    public List<Service> findServices();
    }
