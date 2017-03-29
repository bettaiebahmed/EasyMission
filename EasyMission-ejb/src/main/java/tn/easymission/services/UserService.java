package tn.easymission.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.easymission.entities.Admin;
import tn.easymission.entities.Agent;
import tn.easymission.entities.Analyse;
import tn.easymission.entities.Client;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.Feedback;
import tn.easymission.entities.Offre;
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
	public Boolean delete(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		Query  query = em.createQuery("Select u from User u", User.class);
		List<User> list=query.getResultList();
		return list;
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
		Query  query = em.createQuery("Select e from EmployementHistory e where e.idEmployment.idAgent=:idAgent", EmployementHistory.class);
		query.setParameter("idAgent", id);
		List<EmployementHistory> list=query.getResultList();
		
		return  list;
	}
  
	
	@Override
	public void doSuspend(int id)
	{
		Query  query = em.createQuery("Update User u set u.suspended=:status where u.idUser=:id");
         query.setParameter("status", "closed");
         query.setParameter("id", id);
         query.executeUpdate();

		
	}

	@Override
	public void Update(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UnSuspend(int id) {
		Query  query = em.createQuery("Update User u set u.suspended=:status where u.idUser=:id");
        query.setParameter("status", "opened");
        query.setParameter("id", id);
        query.executeUpdate();
		
	}

	@Override
	public Agent findAgentById(int id) {
		
		return em.find(Agent.class, id);
	}

	@Override
	public List<EmployementHistory> getEndedContracts() {
		Query  query = em.createQuery("Select e from EmployementHistory e where e.dateEnd<>'Present' ", EmployementHistory.class);
		List<EmployementHistory> list=query.getResultList();
		return list;
	}

	@Override
	public List<Offre> getNumberOffer() {
		
		Query  query = em.createQuery("Select o from Offre o ", Offre.class);
		List<Offre> list=query.getResultList();
		return list;
	}

	@Override
	public void IncrementImpression() {
		Query  query = em.createQuery("Update Analyse o set o.countVisit=o.countVisit+1 where idAnalyse=1");
     
        query.executeUpdate();		
	}

	@Override
	public Analyse getImpression() {
		return em.find(Analyse.class, 1);

	}

	@Override
	public List<Feedback> getFeedBacks() {
		Query  query = em.createQuery("Select f from Feedback f ", Feedback.class);
		List<Feedback> list=query.getResultList();
		return list;
	}

	@Override
	public Boolean addAgent(Agent a) {
		try{
			em.persist(a);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public Boolean addClient(Client c) {
		try{
			em.persist(c);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public Boolean addAdmin(Admin admin) {
		try{
			em.persist(admin);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public Client findClientById(int id) {
		return em.find(Client.class, id);

	}

	@Override
	public Boolean updateAgent(Agent agent) {
		try
		{
			em.merge(agent);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public Boolean updateClient(Client client) {
		try
		{
			em.merge(client);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
//	select postalcarrier from reward p
//	inner join p. postalcarrier
//	where p.id = :postOfficeId
//	and postalcarrier.area.code = :areaCode
	@Override
	public List<Agent> getAgents() {
		Query  query = em.createQuery("select distinct u from Agent u left join fetch u.offres");
		List<Agent> list=query.getResultList();
		return list;
	}

	@Override
	public List<Client> getClients() {
		Query  query = em.createQuery("Select c from Client c ", Client.class);
		List<Client> list=query.getResultList();
		return list;
	}

	@Override
	public List<Agent> getAgentsbyName(String name) {
		Query  query = em.createQuery("Select a from Agent a where a.location like :name", Agent.class);
		query.setParameter("name", name);
		List<Agent> list=query.getResultList();
		
		return  list;
	}

}
