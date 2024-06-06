package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academy.dao.trainingImpl;
import com.academy.model.courseP;
import com.academy.model.trainingTableP;

/**
 * Servlet implementation class courseDetails
 */
@WebServlet("/courseDetails")
public class courseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		System.out.println(action);
		courseP learnerdetail=new courseP();
		switch (action) {
		
		case "Java":
		{
			trainingImpl obj = new trainingImpl();
			int id=4000;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
//		    String duedate=due.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    System.out.println(date);
		    response.sendRedirect("payment.jsp");
		    HttpSession session = request.getSession(false);
		    trainingTableP obj1 =(trainingTableP) session.getAttribute("userid");
		    int iid= obj1.getId();
		    String name=obj1.getName();
		    System.out.println(iid);
		    System.out.println(name);
		   
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    break;
		    
		}
		
		case "Html":
		{
			trainingImpl obj = new trainingImpl();
			int id=4001;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    System.out.println(date);
		    response.sendRedirect("payment.jsp");
		    HttpSession session = request.getSession(false);
		    trainingTableP obj1 =(trainingTableP) session.getAttribute("userid");
		    int iid= obj1.getId();
		    String name=obj1.getName();
		    System.out.println(iid);
		    System.out.println(name);
		   
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    break;
		    
		}
		
		case"css":
		{
			trainingImpl obj = new trainingImpl();
			int id=4002;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    System.out.println(date);
		    response.sendRedirect("payment.jsp");
		    HttpSession session = request.getSession(false);
		    trainingTableP obj1 =(trainingTableP) session.getAttribute("userid");
		    int iid= obj1.getId();
		    String name=obj1.getName();
		    System.out.println(iid);
		    System.out.println(name);
		   
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    break;
		}
		
		case"angular":
		{
			trainingImpl obj = new trainingImpl();
			int id=4003;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    System.out.println(date);
		    int amount=2000;
		    response.sendRedirect("payment.jsp");
		    HttpSession session = request.getSession(false);
		    trainingTableP obj1 =(trainingTableP) session.getAttribute("userid");
		    int iid= obj1.getId();
		    String name=obj1.getName();
		    System.out.println(iid);
		    System.out.println(name);
		   
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    break;
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
