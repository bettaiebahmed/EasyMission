package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import tn.easymission.entities.CandidaturePk;

/**
 * Entity implementation class for Entity: Candidature
 *
 */
@Entity

public class Candidature implements Serializable {

	
	private CandidaturePk idCandidature;
	private Date dateSubmit;
	private String status;
	private Client client;
	private Agent agent;
	private static final long serialVersionUID = 1L;

	public Candidature() {
		super();
	}   
	public Candidature(Date dateSubmit, String status, Client client, Agent agent) {
		super();
		this.dateSubmit=dateSubmit;
		this.status=status;
		this.client=client;
		this.agent=agent;
		this.idCandidature=new CandidaturePk(client.getIdUser(),agent.getIdUser());	
	}   
	@EmbeddedId
	public CandidaturePk getIdCandidature() {
		return this.idCandidature;
	}

	public void setIdCandidature(CandidaturePk idCandidature) {
		this.idCandidature = idCandidature;
	}   
	public Date getDateSubmit() {
		return this.dateSubmit;
	}

	public void setDateSubmit(Date dateSubmit) {
		this.dateSubmit = dateSubmit;
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne
	@JoinColumn(name="idClient",referencedColumnName="idUser",insertable=false,updatable=false)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@ManyToOne
	@JoinColumn(name="idAgent",referencedColumnName="idUser",insertable=false,updatable=false)
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
   
}
