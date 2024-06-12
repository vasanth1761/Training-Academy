package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academy.dao.trainingImpl;
import com.academy.model.trainingTableP;
import com.academy.model.videoP;

/**
 * Servlet implementation class videoCategory
 */
@WebServlet("/videoCategory")
public class videoCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public videoCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		String cours=(String) session.getAttribute("jack");
		System.out.println(cours);
		trainingImpl videoop= new trainingImpl();
		switch(cours)
		{
		case"java":
		{   
			try {
				List<videoP>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
		case"html":
		{   
			try {
				List<videoP>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
		}
		case"css":
		{   
			try {
				List<videoP>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
		case"angular":
		{   
			try {
				List<videoP>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
	}

	
	}
}

	

	
	


