package com.academy.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet("/Percentageverification")
public class Percentageverification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Percentageverification() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
		String percentage = request.getParameter("percentage");
		System.out.println("percentage");
        double percentagee = Double.parseDouble(percentage);
        if (percentagee >= 80) {
            	
                response.sendRedirect("certificatePage.jsp");
            } else {
            	String confirmMessage = "Your percentage mark is not enough .Do you like to get retest";
                request.setAttribute("confirmMessage", confirmMessage);
                System.out.println(confirmMessage);
                response.sendRedirect("questionoutput.jsp");
            }
	}

}

