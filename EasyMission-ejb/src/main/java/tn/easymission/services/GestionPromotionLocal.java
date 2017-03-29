package tn.easymission.services;

import java.util.List;

import javax.ejb.Local;

import tn.easymission.entities.Promotion;

@Local
public interface GestionPromotionLocal {

	public Boolean addAndUpdate(Promotion p);

	public Promotion findById(int id);

	public Boolean delete(Promotion p);

	public List<Promotion> findAll();
}
