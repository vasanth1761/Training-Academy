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
import com.academy.model.questionsP;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		questionsP insert=new questionsP();
		String action=request.getParameter("action");
		System.out.println(action);
        if(action!=null)
        switch(action)
        {
        case"Delete":
        {
        	int deleteid=Integer.parseInt(request.getParameter("delete"));
        	System.out.println(deleteid);
        	trainingImpl userdelete=new trainingImpl();
        
        	try {
				userdelete.delete(deleteid);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
        		List<questionsP> questions=userdelete.getAllQuestionsByCategory(action);
        		request.setAttribute("questions",questions);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//        	
        	RequestDispatcher req=request.getRequestDispatcher("javaquestions.jsp");
    		req.forward(request, response);

        

	}
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
