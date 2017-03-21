package tn.easymission.services;

import java.util.List;

import javax.ejb.Local;

import tn.easymission.entities.Agent;
import tn.easymission.entities.Analyse;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.Feedback;
import tn.easymission.entities.Offre;
import tn.easymission.entities.User;

@Local
public interface LocalUser {
	public Boolean add(User u);
	public Boolean update(User u);
	public User findById(int id);
	public Agent findAgentById(int id);
	public Boolean delete(User u);
	public List<User> findAll();
	public List<EmployementHistory> getResume(int id);
	public User Login(String login, String pwd);
	public void Update(int id);
	public void doSuspend(int id);
	public void UnSuspend(int id);
	public List<EmployementHistory> getEndedContracts();
	public List<Offre> getNumberOffer();
	public void IncrementImpression();
	public Analyse getImpression();
	public List<Feedback> getFeedBacks();
}
