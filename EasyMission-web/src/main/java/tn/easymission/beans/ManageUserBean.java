package tn.easymission.beans;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tn.easymission.entities.Admin;
import tn.easymission.entities.Agent;
import tn.easymission.entities.Analyse;
import tn.easymission.entities.Candidature;
import tn.easymission.entities.Client;
import tn.easymission.entities.EmployementHistory;
import tn.easymission.entities.Notification;
import tn.easymission.entities.Offre;
import tn.easymission.entities.User;
import tn.easymission.services.LocalUser;

@ManagedBean(name="ManageUserBean")
@ViewScoped
public class ManageUserBean {
	private String isValid;
	private String role;
	public boolean setVisible=false;
	private Admin admin;
	private User user = new User();
	private Agent agent= new Agent();
	private Client client= new Client();
	private Part file;
	private String skills;
	private String title;
	private String location;
	private boolean agentVisible=false;
	private boolean clientVisible=false;
	
	int i=0;	
    int j=0;
	
	private static final long serialVersionUID = 1L;


	@EJB  
	LocalUser myService;

	
	public boolean isAgentVisible() {
		return agentVisible;
	}



	public void setAgentVisible(boolean agentVisible) {
		this.agentVisible = agentVisible;
	}



	public boolean isClientVisible() {
		return clientVisible;
	}



	public void setClientVisible(boolean clientVisible) {
		this.clientVisible = clientVisible;
	}



	public User getUser() {
		return user;
		
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	public String getIsValid() {
		return isValid;
	}



	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}



	public LocalUser getMyService() {
		return myService;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public boolean isSetVisible() {
		return setVisible;
	}



	public void setSetVisible(boolean setVisible) {
		this.setVisible = setVisible;
	}



	public void setMyService(LocalUser myService) {
		this.myService = myService;
	}

	 public Part getFile() {
		return file;
	}



	public void setFile(Part file) {
		this.file = file;
	}
	
	
	

	public String getSkills() {
		return skills;
	}



	public void setSkills(String skills) {
		this.skills = skills;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}




	public Agent getAgent() {
		return agent;
	}



	public void setAgent(Agent agent) {
		this.agent = agent;
	}




	@ManagedProperty(value="#{navigationBean}")
	    private NavigationBean navigationBean;
	 
	 
	
	 public void setNavigationBean(NavigationBean navigationBean) {
	        this.navigationBean = navigationBean;
	    }
	 public static String getSubmittedFileName(Part filePart)
	    {
	        String header = filePart.getHeader("content-disposition");
	        if(header == null)
	            return null;
	        for(String headerPart : header.split(";"))
	        {
	            if(headerPart.trim().startsWith("filename"))
	            {
	                return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
	            }
	        }
	        return null;
	    }
	public String verifier() throws IOException{
        Part uploadedFile=getFile();
         skills="";
         title="";
         location="";
         
		 if (uploadedFile!=null)
		 {
			  final Path destination = Paths.get("C:/Users/Tibou/Desktop/upload/"+ FilenameUtils.getName(getSubmittedFileName(uploadedFile)));
		        InputStream bytes=null;
		        
		        if (null!=uploadedFile) {

		            bytes = uploadedFile.getInputStream();  //

		    //Copies bytes to destination.
		              Files.copy(bytes, destination);

		              XWPFDocument docx = new XWPFDocument(new FileInputStream(destination.toString()));
		              //using XWPFWordExtractor Class
		              XWPFWordExtractor we = new XWPFWordExtractor(docx);
		              skills=getSkillsFromDocument(we.getText());
		              location=getLocationFromDocument(we.getText());
		              title=getTitleFromDocument(we.getText());
		              
		               
		              
		        }
		 }
		 if(getRole().equals("Agent"))
		 {
			 Agent agent = new Agent(user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), title, null, location, 0, skills);
			 Boolean v = false;
			 v=myService.addAgent(agent);
			 if(v==true)
			 {
	               return navigationBean.toSuspendUser();
			 }
		 }
		 if(getRole().equals("Client"))
		 {
			 Client client = new Client(user.getLogin(), user.getPassword(), user.getFirstName(), user.getEmail(), user.getEmail());
			 Boolean v = false;
			 v=myService.addClient(client);
			 if(v==true)
			 {
	               return navigationBean.toSuspendUser();
			 }
		 }
		 if(getRole().equals("Admin"))
		 {
			 Admin admin = new Admin(user.getLogin(), user.getPassword(), user.getFirstName(),  user.getLastName(), user.getEmail());
			 Boolean v = false;
			 v=myService.addAdmin(admin);
			 if(v==true)
			 {
	               return navigationBean.toSuspendUser();
			 }
		 }
//		Agent agent = new Agent();
//		Client client = new Client();
//		Admin admin = new Admin();
//		
		
        

		
	        
        return "success";

	 }
	
	public String getSkillsFromDocument(String ch)
	{
		String skillsFromDocument="";
		boolean found=false;
		while (found!=true)
		{
			skillsFromDocument=skillsFromDocument+Character.toString(ch.charAt(i));
			i++;
			if (skillsFromDocument.equals("Skills:"))
			{
				found=true;
			}
		}
		found=false;
		skillsFromDocument="";
		while(found!=true)
		{
			if (Character.toString(ch.charAt(i)).equals("."))
			{
				found=true;
			}
			else
			{
				
			
			skillsFromDocument=skillsFromDocument+Character.toString(ch.charAt(i));
			
			i++;
			}
		}
		
		return skillsFromDocument;
	}
	public String getLocationFromDocument(String ch)
	{
		 j=i+2;
		boolean found=false;
		String slocationFromDocument ="";
		while(found!=true)
		{
			if (slocationFromDocument.equals("Location:"))
			{
				found=true;
			}
			else
			{
	slocationFromDocument=slocationFromDocument+Character.toString(ch.charAt(j));
            j++;
			}
		}
		found=false;
		 slocationFromDocument ="";

		while (found!=true)
		{
			if ((Character.toString(ch.charAt(j)).equals(".")))
			{
				found=true;
			}
			else
			{
				slocationFromDocument=slocationFromDocument+Character.toString(ch.charAt(j));
                j++;
			}
		}
		return slocationFromDocument;
	}

	public int getUserNumber()
	{ int i = 0;
	  
		List<User> users=  myService.findAll();
		for (User user : users) {
			i++;
		}
		
		return i;
	}
	
	public String getTitleFromDocument(String ch)
	{
		int k=j+2;
		boolean found=false;
		String slocationFromDocument ="";
		while(found!=true)
		{
			if (slocationFromDocument.equals("Title:"))
			{
				found=true;
			}
			else
			{
	       slocationFromDocument=slocationFromDocument+Character.toString(ch.charAt(k));
            k++;
			}
		}
		found=false;
		 slocationFromDocument ="";

		while (found!=true)
		{
			if ((Character.toString(ch.charAt(k)).equals(".")))
			{
				found=true;
			}
			else
			{
				slocationFromDocument=slocationFromDocument+Character.toString(ch.charAt(k));
                k++;
			}
		}
		return slocationFromDocument;	}
	
	public void changeRole(AjaxBehaviorEvent  e)
	{
		if (role.equals("Agent"))
		{
			setSetVisible(true);

		}
		else
		{
			setSetVisible(false);

		}
	}
	public void changeListing(AjaxBehaviorEvent  e)
	{
		if (role.equals("Agent"))
		{
			setAgentVisible(true);
			setClientVisible(false);

		}
		if (role.equals("Client"))
		{
			setClientVisible(true);
			setAgentVisible(true);

		}
	}
	
	public Agent getAgentbyId(int id)
	{
		agent =myService.findAgentById(id);
		return agent;
	}
	
	public Client getClientbyId(int id)
	{
		client=myService.findClientById(id);
		return client;
	}
	
	public String updateAgent()
	{
		myService.updateAgent(agent);
		return "sucess";
	}
	public String updateClient()
	{
		myService.updateClient(client);
		return "sucess";
	}
 public List<Agent> getAgents()
 {
	 return myService.getAgents();
 }
 public List<Client> getClients()
 {
	 return myService.getClients();
 }
 
 public void downloadFileAgent(int id,String name) throws IOException
 {
	 Agent agent = new Agent();
	 agent=myService.findAgentById(id);
	  XWPFDocument document= new XWPFDocument(); 
      
      //Write the Document in file system
      FileOutputStream out = new FileOutputStream(new File("C:/Users/Tibou/Desktop/Download/"+name+".docx"));
        
      //create paragraph
      XWPFParagraph paragraph = document.createParagraph();
        
      //First Name
      XWPFRun paragraphOneRunOne = paragraph.createRun();
      paragraphOneRunOne.setBold(true);
      paragraphOneRunOne.setItalic(true);
      paragraphOneRunOne.setText("First Name:");
      paragraphOneRunOne.addBreak();
        
      XWPFRun paragraphOneRunTwo = paragraph.createRun();
      paragraphOneRunTwo.setText(agent.getFirstName());
      paragraphOneRunTwo.setTextPosition(100);
      paragraphOneRunTwo.addBreak();
      
      
    //Last Name
      XWPFRun firstName = paragraph.createRun();
      firstName.setBold(true);
      firstName.setItalic(true);
      firstName.setText("Last Name:");
      firstName.addBreak();
        
      XWPFRun firstNameContent = paragraph.createRun();
      firstNameContent.setText(agent.getLastName());
      firstNameContent.setTextPosition(100);
      firstNameContent.addBreak();
      
    //Title
      XWPFRun title = paragraph.createRun();
      title.setBold(true);
      title.setItalic(true);
      title.setText("Title:");
      title.addBreak();
        
      XWPFRun titleContent = paragraph.createRun();
      titleContent.setText(agent.getTitle());
      titleContent.setTextPosition(100);
      titleContent.addBreak();
      
      //Location
      XWPFRun location = paragraph.createRun();
      location.setBold(true);
      location.setItalic(true);
      location.setText("Title:");
      location.addBreak();
        
      XWPFRun locationContent = paragraph.createRun();
      locationContent.setText(agent.getLocation());
      locationContent.setTextPosition(100);
      locationContent.addBreak();
      
      
      //agentSkills
      XWPFRun agentSkills = paragraph.createRun();
      agentSkills.setBold(true);
      agentSkills.setItalic(true);
      agentSkills.setText("Title:");
      agentSkills.addBreak();
        
      XWPFRun agentSkillsContent = paragraph.createRun();
      agentSkillsContent.setText(agent.getAgentSkills());
      agentSkillsContent.setTextPosition(100);
      agentSkillsContent.addBreak();
      
      //Employment History
      
      XWPFRun employement = paragraph.createRun();
      employement.setBold(true);
      employement.setItalic(true);
      employement.setText("Employment History:");
      employement.setFontSize(28);
      employement.addBreak();
      
      
      List<EmployementHistory> employmentHistory = new ArrayList<>();
      employmentHistory=myService.getResume(id);
      for (EmployementHistory e : employmentHistory) {
    	  XWPFRun clientName = paragraph.createRun();
    	  clientName.setBold(true);
    	  clientName.setItalic(true);
    	  clientName.setColor("red");
    	  clientName.setFontSize(16);
    	  clientName.setText(e.getClient().getFirstName());
    	  clientName.addBreak();
    	  
    	  XWPFRun titleE = paragraph.createRun();
    	  titleE.setText("Title : "+e.getTitle());
    	  titleE.setTextPosition(100);
    	  titleE.addBreak();
    	  
    	  XWPFRun dateStart = paragraph.createRun();
    	  dateStart.setText("From "+e.getIdEmployment().getDateStart()+" to "+e.getDateEnd());
    	  dateStart.setTextPosition(100);
    	  dateStart.addBreak();
    	  
    	  XWPFRun locationE = paragraph.createRun();
    	  locationE.setText("Location : "+e.getLocation());
    	  locationE.setTextPosition(100);
    	  locationE.addBreak();
    	  
    	  XWPFRun responsablitiesE = paragraph.createRun();
    	  responsablitiesE.setText("Reponsabilitie : "+e.getResponsabilities());
    	  responsablitiesE.setTextPosition(100);
    	  responsablitiesE.addBreak();
    	  
    	  XWPFRun skillsE = paragraph.createRun();
    	  skillsE.setText("Skills : "+e.getSkills());
    	  skillsE.setTextPosition(100);
    	  skillsE.addBreak();
    	  
    	  XWPFRun OffreId = paragraph.createRun();
    	  OffreId.setText("Offre deposed on platform : "+e.getOffre().getDescription());
    	  OffreId.setTextPosition(100);
    	  OffreId.addBreak();
    	  
		
	}
 
 
      //Set Strike through and Font Size and Subscript
     
        
      document.write(out);
      
      out.close();
      File file = new File("C:/Users/Tibou/Desktop/Download/"+name+".docx");

      FacesContext facesContext = FacesContext.getCurrentInstance();

      HttpServletResponse response = 
              (HttpServletResponse) facesContext.getExternalContext().getResponse();

      response.reset();
      response.setHeader("Content-Type", "application/octet-stream");
      response.setHeader("Content-Disposition", "attachment;filename="+name+".docx");

      OutputStream responseOutputStream = response.getOutputStream();

      InputStream fileInputStream = new FileInputStream(file);

      byte[] bytesBuffer = new byte[10000];
      int bytesRead;
      while ((bytesRead = fileInputStream.read(bytesBuffer)) > 0) 
      {
          responseOutputStream.write(bytesBuffer, 0, bytesRead);
      }

      responseOutputStream.flush();

      fileInputStream.close();
      responseOutputStream.close();

      facesContext.responseComplete();

      
 }
	
	
	

}
