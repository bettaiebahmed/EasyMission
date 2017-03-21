package tn.easymission.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.easymission.entities.Reward;

/**
 * Session Bean implementation class GestionRewards
 */
@Stateless
@LocalBean
public class GestionRewards implements GestionRewardsLocal {

	@PersistenceContext
    EntityManager em;
    public GestionRewards() {
       
    }

	@Override
	public Boolean add(Reward reward) {
		try
		{
			em.persist(reward);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Boolean update(Reward reward) {
		try
		{
			em.merge(reward);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Reward findById(int id) {
		try
		{
			return em.find(Reward.class, id);
		}
		catch(Exception e)
		{}
		return null;
	}

	@Override
	public Boolean delete(Reward reward) {
		try
		{
			em.remove(em.merge(reward));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Reward> findAll() {
		try
		{
			Query query = (Query) em.createQuery("select r from Reward r");
			return ((javax.persistence.Query) query).getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}