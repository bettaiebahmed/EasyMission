package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import tn.easymission.entities.Reward;
import tn.easymission.entities.Service;
import tn.easymission.services.GestionRewards;
import tn.easymission.services.GestionRewardsLocal;

@ManagedBean(name="RewardBean")
@SessionScoped
public class RewardBean {
	private Reward reward=new Reward();
	private List<Reward> rewards=new ArrayList<Reward>();
	@EJB
	GestionRewardsLocal service;
	private boolean visible=false;
	public List<Reward> getrewards() {
		return rewards;
	}
	public void setrewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
	public Reward getReward() {
		return reward;
	}
	public void setReward(Reward reward) {
		this.reward = reward;
	}
	public String Doadd()
	{System.out.println("in!!!");
	service.add(reward);

		System.out.println("succus...!!");
		return null;
	}
	public String doDelete(Reward reward){
		service.delete(reward);
		 return null;
	}
	public List<Reward> rewards()
	{
		List<Reward> l = service.findAll();
       return l;
	}
	
	
	
	public String initialiser(){
		reward=new Reward();
		setVisible(true);
		return null;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public String doUpdate(){
		service.update(reward);
		setVisible(false);

		return null;
	}
	}