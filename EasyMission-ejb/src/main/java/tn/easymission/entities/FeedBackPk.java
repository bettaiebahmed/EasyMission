package tn.easymission.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FeedBackPk
 *
 */
@Embeddable

public class FeedBackPk implements Serializable {
	
	private int idUserleft;
	private int idUserRight;
	public int getIdUserleft() {
		return idUserleft;
	}
	public void setIdUserleft(int idUserleft) {
		this.idUserleft = idUserleft;
	}
	public int getIdUserRight() {
		return idUserRight;
	}
	public void setIdUserRight(int idUserRight) {
		this.idUserRight = idUserRight;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUserRight;
		result = prime * result + idUserleft;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedBackPk other = (FeedBackPk) obj;
		if (idUserRight != other.idUserRight)
			return false;
		if (idUserleft != other.idUserleft)
			return false;
		return true;
	}
	
	
	
   
}
