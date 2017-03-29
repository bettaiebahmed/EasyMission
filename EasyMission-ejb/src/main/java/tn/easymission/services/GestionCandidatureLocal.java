package tn.easymission.services;

import java.util.List;

import javax.ejb.Local;

import tn.easymission.entities.Candidature;

@Local
public interface GestionCandidatureLocal {
	
	public Boolean add(Candidature candidature);
	public Boolean update(Candidature candidature);
	public Candidature findById(int idCandidature);
	public Boolean delete(Candidature candidature);
	public List<Candidature> findAll();

}
