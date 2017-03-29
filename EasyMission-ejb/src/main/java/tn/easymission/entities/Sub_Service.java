package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

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
	private Service service;
	private List<Promotion>promotions;
	private Offre offre;
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
	@ManyToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	@ManyToMany
	public List<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	@ManyToOne
	public Offre getOffre() {
		return offre;
	}
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
   
}
