package tn.easymission.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.easymission.entities.Promotion;

/**
 * Session Bean implementation class GestionPromotion
 */
@Stateless
@LocalBean
public class GestionPromotion implements GestionPromotionLocal {

	
	 @PersistenceContext
	    EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionPromotion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addAndUpdate(Promotion p) {
		try{
			//eviter les erreurs ecraser par contre persist : erreur
			em.merge(p);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public Promotion findById(int id) {
		return em.find(Promotion.class, id);
	}

	@Override
	public Boolean delete(Promotion p) {
		try {
			em.remove(em.find(Promotion.class, p.getIdPromotion()));
			return true;

		} catch (Exception e) {
			System.err.println("Failed to delete Promotion");

			return false;
		}
	}

	@Override
	public List<Promotion> findAll() {
		Query  query = em.createQuery("Select p from promotion p", Promotion.class);
		List<Promotion> list=query.getResultList();
		return list;
	}

}
