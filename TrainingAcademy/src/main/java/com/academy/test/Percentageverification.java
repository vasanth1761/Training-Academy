package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academy.dao.TrainingImpl;
import com.academy.model.Result;
import com.academy.model.ResultTable;
import com.academy.model.TrainingTable;

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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
		String percentage = request.getParameter("percentage");
		System.out.println("vasanth");
		System.out.println(percentage);
		System.out.println("vasanth");
        double percentagee = Double.parseDouble(percentage);
        if (percentagee >= 80) {
        	TrainingImpl result=new TrainingImpl();
        	HttpSession session = request.getSession(false);
		    String course=(String)session.getAttribute("course");
		    Result obj1 =(Result) session.getAttribute("result");
		    try {
				result.insertResult(obj1);
			} catch (ClassNotFoundException | SQLException e) {
			
				e.printStackTrace();
			}
		    
		    
		    
            response.sendRedirect("Certificate.jsp");
                
            } else {
            	request.setAttribute("errorMessage", "you didnt pass the exam so learn again ");
            	RequestDispatcher dispatcher = request.getRequestDispatcher("Sorrypage.jsp");
	            dispatcher.forward(request, response);
            }
	}

}

