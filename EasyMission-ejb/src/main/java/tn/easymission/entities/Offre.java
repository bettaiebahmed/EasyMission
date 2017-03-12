package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Offre
 *
 */
@Entity

public class Offre implements Serializable {

	
	private int idOffre;
	private Date dateOffre;
	private String description;
	private Client client;
	private List<Agent>agents;
	private Reward reward;
	private static final long serialVersionUID = 1L;

	public Offre() {
		super();
	}   
	@Id    
	public int getIdOffre() {
		return this.idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}   
	public Date getDateOffre() {
		return this.dateOffre;
	}

	public void setDateOffre(Date dateOffre) {
		this.dateOffre = dateOffre;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@ManyToMany(mappedBy="offres",fetch=FetchType.EAGER)
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	@OneToOne
	public Reward getReward() {
		return reward;
	}
	public void setReward(Reward reward) {
		this.reward = reward;
	}
   
}
