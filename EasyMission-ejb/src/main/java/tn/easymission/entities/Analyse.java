package tn.easymission.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Analyse
 *
 */
@Entity

public class Analyse implements Serializable {

	
	private int idAnalyse;
	private int countVisit;
	private Agent agent;
	private Client client;
	private static final long serialVersionUID = 1L;

	public Analyse() {
		super();
	}   
	@Id    
	public int getIdAnalyse() {
		return this.idAnalyse;
	}

	public void setIdAnalyse(int idAnalyse) {
		this.idAnalyse = idAnalyse;
	}   
	public int getCountVisit() {
		return this.countVisit;
	}

	public void setCountVisit(int countVisit) {
		this.countVisit = countVisit;
	}
	@OneToOne(mappedBy = "analyse",fetch=FetchType.EAGER)
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@OneToOne(mappedBy = "analyse",fetch=FetchType.EAGER)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
   
}
