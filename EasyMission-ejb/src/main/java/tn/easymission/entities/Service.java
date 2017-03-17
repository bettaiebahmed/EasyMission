package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

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
	private Admin admin;
	private List<Sub_Service>sub_Services;
	private static final long serialVersionUID = 1L;

	public Service() {
		super();
		
	}   
	public Service(int idService, String nameService, String description, String categorie) {
		super();
		this.idService = idService;
		this.nameService = nameService;
		this.description = description;
		this.categorie = categorie;
		
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
	@ManyToOne
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@OneToMany(mappedBy = "service",fetch=FetchType.EAGER)
	public List<Sub_Service> getSub_Services() {
		return sub_Services;
	}
	public void setSub_Services(List<Sub_Service> sub_Services) {
		this.sub_Services = sub_Services;
	}
   
}
