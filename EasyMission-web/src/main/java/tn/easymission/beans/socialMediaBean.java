package tn.easymission.beans;

import java.util.Map;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;
import org.json.JSONObject;


import tn.easymission.entities.Admin;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="socialMediaBean")
@SessionScoped
public class socialMediaBean {
	private SocialAuthManager manager;
    private String            originalURL;
    private String            providerID;
    private Profile           profile;
    
    public SocialAuthManager getManager() {
		return manager;
	}

	public void setManager(SocialAuthManager manager) {
		this.manager = manager;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@ManagedProperty(value="#{navigationBean}")
    private NavigationBean navigationBean;
    @ManagedProperty(value="#{myLogBean}")
    private LogBean myLogBean;
	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}
	
	

	public LogBean getMyLogBean() {
		return myLogBean;
	}

	public void setMyLogBean(LogBean myLogBean) {
		this.myLogBean = myLogBean;
	}

	public void socialConnect() throws Exception
	{
		 Properties props = System.getProperties();
	     props.put("graph.facebook.com.consumer_key", "1044346032338255");
	     props.put("graph.facebook.com.consumer_secret", "98b351db4d4b2033ae6d8227ae5aa735");
	     // Define your custom permission if needed
	     props.put("graph.facebook.com.custom_permissions", "public_profile,email");
	     
	     // Initiate required components
	     SocialAuthConfig config = SocialAuthConfig.getDefault();
	     config.load(props);
	     manager = new SocialAuthManager();
	     manager.setSocialAuthConfig(config);
	     
	     // 'successURL' is the page you'll be redirected to on successful login
	     ExternalContext externalContext   = FacesContext.getCurrentInstance().getExternalContext();
	     String          successURL        = externalContext.getRequestContextPath() + "http://localhost.localdomain:8180/EasyMission-web/index"; 
	     String          authenticationURL = manager.getAuthenticationUrl(providerID, "http://localhost.localdomain:8180/EasyMission-web/index");
          myLogBean.setLoggedIn(true);
          myLogBean.setFromWhere("Social");
	     FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);
	     
	     
             
	}
	 public String pullUserInfo() {
	        try {
	            // Pull user's data from the provider
	            ExternalContext    externalContext = FacesContext.getCurrentInstance().getExternalContext();
	            HttpServletRequest request         = (HttpServletRequest) externalContext.getRequest();
	            Map<String,String>                map             = SocialAuthUtil.getRequestParametersMap(request);
	            if (this.manager != null) {
	                AuthProvider provider = manager.connect(map);
	                  this.profile=provider.getUserProfile();
	                  
	             //   this.profile          = provider.getUserProfile();
//	                FacesMessage msg = new FacesMessage(profile.getDisplayName(), "ERROR MSG");
//	    	        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//	    	        FacesContext.getCurrentInstance().addMessage(null, msg);

	            return provider.FULL_NAME;    
	            
	            } 
	            else
	            {
	            	return null;
	            }
	        } catch (Exception ex) {
	        	
	            System.out.println(ex.toString());
	            String exceptionMess=ex.toString();
	            int i=104;  
	            String ch="";
	            boolean found=false;
	            while (i<118)
	            {
	            
	            		ch=ch+Character.toString(exceptionMess.toString().charAt(i));
		            	i++;	
	            	}
	            	
	            return ch;	
	            }
	             
	        } 
	    }

