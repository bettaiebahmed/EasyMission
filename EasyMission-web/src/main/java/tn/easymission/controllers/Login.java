package tn.easymission.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.easymission.beans.LogBean;

/**
 * Servlet implementation class Home
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LogBean loginBean = (LogBean)((HttpServletRequest)request).getSession().getAttribute("myLogBean");
         
	        // For the first application request there is no loginBean in the session so user needs to log in
	        // For other requests loginBean is present but we need to check if user has logged in successfully
	        if (loginBean == null || !loginBean.isLoggedIn()) {
	        	RequestDispatcher view = request.getRequestDispatcher("Views/Login/login.xhtml");
	    		view.forward(request, response);    
	        }
	        else 
	        {
	        String contextPath = ((HttpServletRequest)request).getContextPath();
         ((HttpServletResponse)response).sendRedirect(contextPath + "/index/");
	        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
