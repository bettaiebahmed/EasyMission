package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity

public class Promotion implements Serializable {

	
	private int idPromotion;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private Admin admin;
	private List<Sub_Service>sub_Services;
	private static final long serialVersionUID = 1L;

	public Promotion() {
		super();
	}   
	@Id    
	public int getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}   
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	@ManyToOne
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@ManyToMany(mappedBy="promotions",fetch=FetchType.EAGER)
	public List<Sub_Service> getSub_Services() {
		return sub_Services;
	}
	public void setSub_Services(List<Sub_Service> sub_Services) {
		this.sub_Services = sub_Services;
	}
   
}
