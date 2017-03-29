package tn.easymission.services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.easymission.entities.Service;

/**
 * Session Bean implementation class MyService
 */
@Stateless
@LocalBean

public class MyService implements MyServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public MyService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Ajouter(Service service) {
	
		em.persist(service);
		
	}

	
	
	@Override
	public void Update(Service service) {
		
		
			em.merge(service);
			
		
	}

	

	@Override
	public void Delete(Service service) {
		// TODO Auto-generated method stub
		em.remove(em.merge(service));
		
	}

	@Override
	public List<Service> getAll() {
		Query query=em.createQuery("select s from Service s");
		return query.getResultList();
	}
	
	
}
