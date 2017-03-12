package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Commentaire
 *
 */
@Entity

public class Commentaire implements Serializable {

	
	private int idCommentaire;
	private String description;
	private static final long serialVersionUID = 1L;

	public Commentaire() {
		super();
	}   
	@Id    
	public int getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
