package tn.easymission.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.easymission.entities.Offre;
import tn.easymission.entities.Service;
import tn.easymission.entities.Sub_Service;

/**
 * Session Bean implementation class GestionOffre
 */
@Stateless
public class GestionOffre implements GestionOffreLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
    EntityManager em;
    public GestionOffre() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean add(Offre offre) {
		try
		{
			em.persist(offre);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Boolean update(Offre offre) {
		try
		{
			em.merge(offre);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Offre findById(int id) {
		try
		{
			return em.find(Offre.class, id);
		}
		catch(Exception e)
		{}
		return null;
	}

	@Override
	public Boolean delete(Offre offre) {
		try
		{
			em.remove(em.merge(offre));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Offre> findAll() {
		try
		{
			Query query = em.createQuery("select o from Offre o");
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void affectServiceToOffre(Offre offre, Service service) {
//		offre.assignService(service);
//		em.merge(offre);
//		
//	}

//	@Override
//	public void affectSub_ServiceToOffre(Offre offre, Sub_Service sub_service) {
//		offre.assignSub_Service(sub_service);
//		em.merge(offre);
//		
//	}
	
	@Override
	public List<Service> findServices() {
		Query  query = em.createQuery("Select s from Service s", Service.class);
		List<Service> list=query.getResultList();
		return list;
	}
//	
//	@Override
//	public Service findServiceByName(String name) {
//		Query  query = em.createQuery("Select s from Service s where s.nameService=:name", Service.class);
//		query.setParameter("name", name);
//		Service s =(Service) query.getResultList();
//		return s;
//	}
	
	
}
