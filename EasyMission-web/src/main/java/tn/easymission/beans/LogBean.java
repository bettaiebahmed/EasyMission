package tn.easymission.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.easymission.controllers.Home;
import tn.easymission.entities.Admin;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="myLogBean")
@SessionScoped
public class LogBean {
	private String login;
	private String pwd;
	private User u=null;
	private boolean loggedIn;
	private String role;
	private String suspended;
	@EJB  
	LocalUser myService;

    @ManagedProperty(value="#{navigationBean}")
    private NavigationBean navigationBean;
    
	public String getLogin() {
		return login;
	}
	
	
	
	 public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public void setLogin(String login) {
		this.login = login;
	}
	 public String getPwd() {
		return pwd;
	}
	 public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	 public User getU() {
		return u;
	}
	 public void setU(User u) {
		this.u = u;
	}
	 
	 
	 public String verifier(){
		 User u = null;
		 String s=null;
		 u=myService.Login(login, pwd);
		 try {
			s=u.getSuspended();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if(u!=null)
		 {
			 
			 if (u instanceof Admin)
			 {
				 role="Admin";
			 }
			 if (s.equals("closed"))
			 {
				 suspended="closed";
				 

			 }
			
			 
			    loggedIn = true;
			    login=u.getLogin();
                return navigationBean.redirectToWelcome();
		 }
		 FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
	        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	         
	        // To to login page
	        return navigationBean.toLogin();
	 }
	 
	 
	 
	 public String getSuspended() {
		return suspended;
	}



	public void setSuspended(String suspended) {
		this.suspended = suspended;
	}



	public boolean isLoggedIn() {
	        return loggedIn;
	    }
	 
	    public void setLoggedIn(boolean loggedIn) {
	        this.loggedIn = loggedIn;
	    }
	 
	    public void setNavigationBean(NavigationBean navigationBean) {
	        this.navigationBean = navigationBean;
	    }

}
