package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Offre
 *
 */
@Entity

public class Offre implements Serializable {

	
	private int idOffre;
	private Date dateOffre;
	private String descriptionJob;
	private String nomSociete;
	private String nomTravail;
	private String lieuTravail;
	private float salaire;
	private String typeSalaire;
	private String experience;
	private String anneeExperience;
	private Service service;
	//private List<Sub_Service>sub_Services;
	private static final long serialVersionUID = 1L;
	
	public Offre() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdOffre() {
		return this.idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}   
	public Date getDateOffre() {
		return this.dateOffre;
	}

	public void setDateOffre(Date dateOffre) {
		this.dateOffre = dateOffre;
	}
	
	public String getDescriptionJob() {
		return descriptionJob;
	}
	public void setDescriptionJob(String descriptionJob) {
		this.descriptionJob = descriptionJob;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	public String getNomTravail() {
		return nomTravail;
	}
	public void setNomTravail(String nomTravail) {
		this.nomTravail = nomTravail;
	}
	public String getLieuTravail() {
		return lieuTravail;
	}
	public void setLieuTravail(String lieuTravail) {
		this.lieuTravail = lieuTravail;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public String getTypeSalaire() {
		return typeSalaire;
	}
	public void setTypeSalaire(String typeSalaire) {
		this.typeSalaire = typeSalaire;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAnneeExperience() {
		return anneeExperience;
	}
	public void setAnneeExperience(String anneeExperience) {
		this.anneeExperience = anneeExperience;
	}
	
	
	
	
	//@OneToMany
	//public List<Sub_Service> getSub_Services() {
	//	return sub_Services;
	//}
//	public void setSub_Services(List<Sub_Service> sub_Services) {
//		this.sub_Services = sub_Services;
//	}
	
//	public void assignService(Service service)
//	{
//		this.setServices(services);
//		service.setOffre(this);
//	}
//	
//	public void assignSub_Service(Sub_Service sub_service)
//	{
//		this.setSub_Services(sub_Services);
//		sub_service.setOffre(this);
//	}
	public Offre(Date dateOffre, String descriptionJob, String nomSociete, String nomTravail, String lieuTravail,
			float salaire, String typeSalaire, String experience, String anneeExperience) {
		super();
		this.dateOffre = dateOffre;
		this.descriptionJob = descriptionJob;
		this.nomSociete = nomSociete;
		this.nomTravail = nomTravail;
		this.lieuTravail = lieuTravail;
		this.salaire = salaire;
		this.typeSalaire = typeSalaire;
		this.experience = experience;
		this.anneeExperience = anneeExperience;
	}
	@OneToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	
	   
   
}
