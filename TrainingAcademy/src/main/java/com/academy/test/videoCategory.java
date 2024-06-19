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
import com.academy.model.TrainingTable;
import com.academy.model.VideoInsert;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession(false);
		String cours=(String) session.getAttribute("course");
		trainingImpl videoop= new trainingImpl();
		switch(cours)
		{
		case"java":
		{   
			try {
				List<VideoInsert>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
		case"html":
		{   
			try {
				List<VideoInsert>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
				
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
		case"css":
		{   
			try {
				List<VideoInsert>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
		case"angular":
		{   
			try {
				List<VideoInsert>output=videoop.getAllVideo(cours);
				request.setAttribute("opvideo",output);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
		default:
			response.sendRedirect("readytopay.jsp");
		
	}

	
	}
}

	

	
	


