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
    private String DateStart;
    private int idOffre;
    
    public EmployementHistoryPk()
    {
    	
    }
	public EmployementHistoryPk(int idAgent, int idClient, String dateStart, int idOffre) {
		super();
		this.idAgent = idAgent;
		this.idClient = idClient;
		DateStart = dateStart;
		this.idOffre = idOffre;
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
	public String getDateStart() {
		return DateStart;
	}
	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}
	public int getIdOffre() {
		return idOffre;
	}
	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateStart == null) ? 0 : DateStart.hashCode());
		result = prime * result + idAgent;
		result = prime * result + idClient;
		result = prime * result + idOffre;
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
		if (DateStart == null) {
			if (other.DateStart != null)
				return false;
		} else if (!DateStart.equals(other.DateStart))
			return false;
		if (idAgent != other.idAgent)
			return false;
		if (idClient != other.idClient)
			return false;
		if (idOffre != other.idOffre)
			return false;
		return true;
	}

	

   
}
