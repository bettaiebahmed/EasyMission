package tn.easymission.services;

import java.util.List;

import javax.ejb.Local;

import tn.easymission.entities.Reward;

@Local
public interface GestionRewardsLocal {
	public Boolean add(Reward reward);
	public Boolean update(Reward reward);
	public Reward findById(int id);
	public Boolean delete(Reward reward);
	public List<Reward> findAll();

}
