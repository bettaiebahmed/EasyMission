package tn.easymission.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.easymission.entities.Agent;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.User;

@Stateless
public class UserService implements LocalUser {
	 @PersistenceContext
	    EntityManager em;
	 
	 User u =null;
	@Override
	public Boolean add(User u) {
		try{
			em.persist(u);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public Boolean update(tn.easymission.entities.User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public tn.easymission.entities.User findById(int id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public Boolean delete(tn.easymission.entities.User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<tn.easymission.entities.User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User Login(String login, String pwd) {
		
		 try{
			 Query query=em.createQuery("select u from User u where u.login=:login and u.password=:pwd",User.class);
			 query.setParameter("login", login);
			 query.setParameter("pwd", pwd);
			 u=(User) query.getSingleResult();
		   return u;
		 }
		 catch(Exception e){
			 return null;
		 }

	}

	@Override
	public List<EmployementHistory> getResume(int id) {
		Query  query = em.createQuery("Select e from EmployementHistory e", EmployementHistory.class);
		List<EmployementHistory> list=query.getResultList();
		
		return  list;
	}

}
