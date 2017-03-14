package tn.easymission.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmployementHistoryPk
 *
 */
@Embeddable


public class EmployementHistoryPk implements Serializable {
     
	private int idAgent;
	private int idClient;
	

	public EmployementHistoryPk() {
		super();
	}

	public EmployementHistoryPk(int idAgent, int idClient) {
		super();
		this.idAgent = idAgent;
		this.idClient = idClient;
	}
	

	public int getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
		EmployementHistoryPk other = (EmployementHistoryPk) obj;
		if (idAgent != other.idAgent)
			return false;
		if (idClient != other.idClient)
			return false;
		return true;
	}
	
   
}
