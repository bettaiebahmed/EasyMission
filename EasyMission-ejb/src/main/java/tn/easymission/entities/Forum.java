package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Forum
 *
 */
@Entity

public class Forum implements Serializable {

	
	private int idForum;
	private String titreForum;
	private String descriptionForum;
	private static final long serialVersionUID = 1L;

	public Forum() {
		super();
	}   
	@Id    
	public int getIdForum() {
		return this.idForum;
	}

	public void setIdForum(int idForum) {
		this.idForum = idForum;
	}   
	public String getTitreForum() {
		return this.titreForum;
	}

	public void setTitreForum(String titreForum) {
		this.titreForum = titreForum;
	}   
	public String getDescriptionForum() {
		return this.descriptionForum;
	}

	public void setDescriptionForum(String descriptionForum) {
		this.descriptionForum = descriptionForum;
	}
   
}
