package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reward
 *
 */
@Entity

public class Reward implements Serializable {

	
	private int idReward;
	private String nomReward;
	private float Reduction;
	private Admin admin;
	private Offre offre;
	private static final long serialVersionUID = 1L;

	public Reward() {
		super();
	}   
	@Id    
	public int getIdReward() {
		return this.idReward;
	}

	public void setIdReward(int idReward) {
		this.idReward = idReward;
	}   
	public String getNomReward() {
		return this.nomReward;
	}

	public void setNomReward(String nomReward) {
		this.nomReward = nomReward;
	}   
	public float getReduction() {
		return this.Reduction;
	}

	public void setReduction(float Reduction) {
		this.Reduction = Reduction;
	}
	@ManyToOne
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
   
}
