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

	
	public Profile(String login, String password, String firstName, String lastName, String email, String privilege) {
		super(login, password, firstName, lastName, email);
		this.privilege = privilege;
	}

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
   
}
