package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sub_Service
 *
 */
@Entity

public class Sub_Service implements Serializable {

	
	private int idSub_Service;
	private String nameSub_Service;
	private String description;
	private static final long serialVersionUID = 1L;

	public Sub_Service() {
		super();
	}   
	@Id    
	public int getIdSub_Service() {
		return this.idSub_Service;
	}

	public void setIdSub_Service(int idSub_Service) {
		this.idSub_Service = idSub_Service;
	}   
	public String getNameSub_Service() {
		return this.nameSub_Service;
	}

	public void setNameSub_Service(String nameSub_Service) {
		this.nameSub_Service = nameSub_Service;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
