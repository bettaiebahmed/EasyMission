package tn.easymission.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CandidaturePk implements Serializable {

	private int idClient;
	private int idAgent;
	
	public CandidaturePk(){
		
	}
	
public CandidaturePk(int idClient, int idAgent){
	super();
	this.idClient=idClient;
	this.idAgent=idAgent;
		
	}

public int getIdClient() {
	return idClient;
}

public void setIdClient(int idClient) {
	this.idClient = idClient;
}

public int getIdAgent() {
	return idAgent;
}

public void setIdAgent(int idAgent) {
	this.idAgent = idAgent;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + idAgent;
	result = prime * result + idClient;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CandidaturePk other = (CandidaturePk) obj;
	if (idAgent != other.idAgent)
		return false;
	if (idClient != other.idClient)
		return false;
	return true;
}
	
}
