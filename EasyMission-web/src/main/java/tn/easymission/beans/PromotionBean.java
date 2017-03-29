package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.easymission.entities.Promotion;
import tn.easymission.services.GestionPromotionLocal;


@ManagedBean(name="PromotionBean")
@ViewScoped
public class PromotionBean {
	private Promotion promotion= new Promotion();
	private List<Promotion>promotions = new ArrayList<Promotion>();
	
	  @EJB
	  GestionPromotionLocal myService;
	  private boolean visible=false;
	  

		public Promotion getPromotion() {
			return promotion;
		}

		public void setPromotion(Promotion promotion) {
			this.promotion = promotion;
		}

		public List<Promotion> getPromotions() {
			return promotions;
		}

		public void setPromotions(List<Promotion> promotions) {
			this.promotions = promotions;
		}
		
		public boolean isVisible() {
			return visible;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
		}
		public String doDelete(Promotion promotion){
			myService.delete(promotion);
			init();
			 return null;
		}
		
		@PostConstruct
		  public void init(){ 
				
			  	promotions=myService.findAll();

			}
		public String create(){
			myService.addAndUpdate(promotion);
			setVisible(false);
			init();
			return null;
		}

		public String doUpdate(){
			myService.addAndUpdate(promotion);
			setVisible(false);
			init();
			return null;
		}

		
		public String initialiser(){
			promotion=new Promotion();
			setVisible(true);
			return null;
		}
}



