package tn.easymission.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmployementHistory
 *
 */
@Entity

public class EmployementHistory implements Serializable {
      
	private EmployementHistoryPk idEmployment;
	private String title;
	private String location;
	private String DateStart;
	private String DateEnd;
	private String Responsabilities;
	private String Skills;
	private Agent agent;
	private Client client;
	
	
	private static final long serialVersionUID = 1L;
      
	public EmployementHistory() {
		super();
	}

	public EmployementHistory(EmployementHistoryPk idEmployment, String title, String location, String dateStart,
			String dateEnd, String responsabilities, String skills) {
		super();
		this.idEmployment = idEmployment;
		this.title = title;
		this.location = location;
		DateStart = dateStart;
		DateEnd = dateEnd;
		Responsabilities = responsabilities;
		Skills = skills;
	}

	@EmbeddedId
	public EmployementHistoryPk getIdEmployment() {
		return idEmployment;
	}

	public void setIdEmployment(EmployementHistoryPk idEmployment) {
		this.idEmployment = idEmployment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateStart() {
		return DateStart;
	}

	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}

	public String getDateEnd() {
		return DateEnd;
	}

	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}

	public String getResponsabilities() {
		return Responsabilities;
	}

	public void setResponsabilities(String responsabilities) {
		Responsabilities = responsabilities;
	}

	public String getSkills() {
		return Skills;
	}

	public void setSkills(String skills) {
		Skills = skills;
	}

	
	@ManyToOne
	@JoinColumn(name="idAgent",referencedColumnName="idUser",insertable=false,updatable=false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@ManyToOne
	@JoinColumn(name="idClient",referencedColumnName="idUser",insertable=false,updatable=false)
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
   
}
