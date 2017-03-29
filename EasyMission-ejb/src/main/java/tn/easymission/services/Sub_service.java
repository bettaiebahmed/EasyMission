package tn.easymission.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.easymission.entities.Promotion;

/**
 * Session Bean implementation class Sub_service
 */
@Stateless
@LocalBean
public class Sub_service implements Sub_serviceLocal {

    /**
     * Default constructor. 
     */
    public Sub_service() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Ajouter(Sub_service s1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Sub_service s1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean Delete(Sub_service s1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
