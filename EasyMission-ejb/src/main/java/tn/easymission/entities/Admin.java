package tn.easymission.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.easymission.entities.User;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends User implements Serializable {

	private List<Service>services;
	private List<Promotion>promotions;
	private List<Reward>rewards;
	private static final long serialVersionUID = 1L;

	
	public Admin() {
		super();
	}

	public Admin(String login, String password, String firstName, String lastName, String email) {
		super(login, password, firstName, lastName, email);
	}

	@OneToMany
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	@OneToMany
	public List<Promotion> getPromotions() {
		return promotions;
	}
	
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	@OneToMany
	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
   
}
