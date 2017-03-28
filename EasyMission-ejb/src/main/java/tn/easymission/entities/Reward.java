package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reward
 *
 */
@Entity

public class Reward implements Serializable {

	
	private int idReward;
	private String nomReward;
	private float Reduction;
	private float tauxInteret;
	private Admin admin;
	private List<Service>services;
	private List<Agent>agents;
	private List<Client>clients;
	
	
	
	public float getTauxInteret() {
		return tauxInteret;
	}
	public void setTauxInteret(float tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	@OneToMany
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	@OneToMany
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	@OneToMany
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	private static final long serialVersionUID = 1L;

	public Reward() {
		super();
	}   
	@Id    
	public int getIdReward() {
		return this.idReward;
	}

	public void setIdReward(int idReward) {
		this.idReward = idReward;
	}   
	public String getNomReward() {
		return this.nomReward;
	}

	public void setNomReward(String nomReward) {
		this.nomReward = nomReward;
	}   
	public float getReduction() {
		return this.Reduction;
	}

	public void setReduction(float Reduction) {
		this.Reduction = Reduction;
	}
	@ManyToOne
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	//@OneToOne(mappedBy="reward",fetch=FetchType.EAGER)	
	//public Offre getOffre() {
		//return offre;
	//}
	//public void setOffre(Offre offre) {
		//this.offre = offre;
	//}
   
}
