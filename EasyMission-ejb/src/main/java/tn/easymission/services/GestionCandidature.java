package tn.easymission.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.easymission.entities.Candidature;
import tn.easymission.entities.User;

/**
 * Session Bean implementation class GestionCandidature
 */
@Stateless
@LocalBean
public class GestionCandidature implements GestionCandidatureLocal {

    
	@PersistenceContext
    EntityManager em;
	
    public GestionCandidature() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean add(Candidature candidature) {
		try{
			em.persist(candidature);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public Boolean update(Candidature candidature) {
		try {
			em.merge(candidature);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Candidature findById(int idCandidature) {
		try {
			return em.find(Candidature.class, idCandidature);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean delete(Candidature candidature) {
		try {
			em.remove(em.merge(candidature));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Candidature> findAll() {
		try {
			Query query = em.createQuery("Select u from User u", User.class);
			List<Candidature> list=query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	 	
}
