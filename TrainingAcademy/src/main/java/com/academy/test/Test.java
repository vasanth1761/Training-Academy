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

import com.academy.dao.TrainingImpl;
import com.academy.model.Questions;
import com.academy.model.VideoInsert;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
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
		doGet(request, response);
		HttpSession session = request.getSession(false);
		String category=(String) session.getAttribute("course");
		TrainingImpl testop= new TrainingImpl();
		switch(category)
		{
		case"java":
		{   
			try {
				List<Questions>output=testop.getAllQuestionsByCategory(category);
				request.setAttribute("testop",output);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("questionoutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
		case"html":
		{
			try {
				List<Questions>output=testop.getAllQuestionsByCategory(category);
				request.setAttribute("testop",output);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("questionoutput.jsp");
	            dispatcher.forward(request, response);
	            break;
		}
	}

}
}

