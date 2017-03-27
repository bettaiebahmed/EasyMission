package tn.easymission.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
* Simple navigation bean
* @author itcuties
*
*/
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

   private static final long serialVersionUID = 1520318172495977648L;

   /**
    * Redirect to login page.
    * @return Login page name.
    */
   public String redirectToLogin() {
       return "Login/login.xhtml?faces-redirect=true";
   }
    
   /**
    * Go to login page.
    * @return Login page name.
    */
   public String toLogin() {
       return "/EasyMission-web/login";
   }
    
   /**
    * Redirect to info page.
    * @return Info page name.
    */
   public String redirectToInfo() {
       return "HomePage/Home.xhtml?faces-redirect=true";
   }
    
   /**
    * Go to info page.
    * @return Info page name.
    */
   public String toInfo() {
       return "HomePage/Home.xhtml";
   }
    
   /**
    * Redirect to welcome page.
    * @return Welcome page name.
    */
   public String redirectToWelcome() {
       return "/EasyMission-web/index?faces-redirect=true";
   }
    
   /**
    * Go to welcome page.
    * @return Welcome page name.
    */
   public String toWelcome() {
       return "HomePage/secured/welcome.xhtml";
   }
   /**
    * Go to welcome page.
    * @return Welcome page name.
    */
   public String toSuspendUser() {
       return "Suspenduser.xhtml?faces-redirect=true";
   }
   public String downloadfile(String name)
   {
       return "file:///C:/Users/Tibou/Desktop/upload/"+name+"?faces-redirect=true";

   }
    
}