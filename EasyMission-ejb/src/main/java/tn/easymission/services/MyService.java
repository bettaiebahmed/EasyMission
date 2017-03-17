package tn.easymission.services;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.easymission.entities.Service;

/**
 * Session Bean implementation class MyService
 */
@Stateless

public class MyService implements MyServiceRemote {

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean Delete(Service service) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
