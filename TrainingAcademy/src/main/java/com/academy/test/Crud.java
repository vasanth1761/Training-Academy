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

import com.academy.dao.trainingImpl;
import com.academy.model.Questions;

/**
 * Servlet implementation class Crud
 */
@WebServlet("/Crud")
public class Crud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crud() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		Questions insert = new Questions();
		String action=request.getParameter("action");
        if(action!=null)
        {
        switch(action)
        {
        case"Delete":
        {
        	int deleteid=Integer.parseInt(request.getParameter("delete"));
        	trainingImpl userdelete=new trainingImpl();
        
        	try {
				userdelete.delete(deleteid);
				
				
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
        	try {
        		List<Questions> questions=userdelete.getAllQuestionsByCategory(action);
        		request.setAttribute("questions",questions);
        		 RequestDispatcher req=request.getRequestDispatcher("javaquestions.jsp");
         		req.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
       	    

        

	}
       
        }
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
