package tn.easymission.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.easymission.entities.User;

/**
 * Entity implementation class for Entity: Profile
 *
 */
@Entity

public class Profile extends User implements Serializable {

	
	private String privilege;
	private static final long serialVersionUID = 1L;

	public Profile() {
		super();
	}   
	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
   
}
