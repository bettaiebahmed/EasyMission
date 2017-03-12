package tn.easymission.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.easymission.entities.User;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}
   
}
