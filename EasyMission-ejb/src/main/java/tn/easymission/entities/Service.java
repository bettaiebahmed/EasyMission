package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Service
 *
 */
@Entity

public class Service implements Serializable {

	
	private int idService;
	private String nameService;
	private String description;
	private String categorie;
	private static final long serialVersionUID = 1L;

	public Service() {
		super();
	}   
	@Id    
	public int getIdService() {
		return this.idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}   
	public String getNameService() {
		return this.nameService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
   
}
