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

import com.academy.dao.TrainingImpl;
import com.academy.model.Course;
import com.academy.model.TrainingTable;

/**
 * Servlet implementation class courseDetails
 */
@WebServlet("/courseDetails")
public class CourseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDetails() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		Course learnerdetail=new Course();
		switch(action) {
		
		case "java":
		{
			TrainingImpl obj = new TrainingImpl();
			int id=4000;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    String course=learnerdetail.getCourseName();
		    response.sendRedirect("readytopay.jsp");
		    HttpSession session = request.getSession(false);
		    TrainingTable obj1 =(TrainingTable) session.getAttribute("userid");
		    session.setAttribute("course",course);
		    int iid= obj1.getId();
		    String name=obj1.getName();
		    
		   
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		    break;
		    
		}
		
		case "html":
		{
			TrainingImpl obj = new TrainingImpl();
			int id=4001;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    String course=learnerdetail.getCourseName();
		    response.sendRedirect("readytopay.jsp");
		    HttpSession session = request.getSession(false);
		    TrainingTable obj1 =(TrainingTable) session.getAttribute("userid");
		    session.setAttribute("course",course);
		    int iid= obj1.getId();
		    String name=obj1.getName();
		    
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		    break;
		    
		}
		
		case"css":
		{
			TrainingImpl obj = new TrainingImpl();
			int id=4002;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    String course=learnerdetail.getCourseName();
		    response.sendRedirect("readytopay.jsp");
		    HttpSession session = request.getSession(false);
		    TrainingTable obj1 =(TrainingTable) session.getAttribute("userid");
		    session.setAttribute("course",course);
		    int iid= obj1.getId();
		    String name=obj1.getName();
		   
		   
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		    break;
		}
		
		case"angular":
		{
			TrainingImpl obj = new TrainingImpl();
			int id=4003;
			String courseName =action;
			LocalDate d=LocalDate.now();
		    String date=d.toString();
		    learnerdetail.setCourseid(id);
		    learnerdetail.setCourseName(courseName);
		    learnerdetail.setDate(date);
		    String course=learnerdetail.getCourseName();
		    response.sendRedirect("readytopay.jsp");
		    HttpSession session = request.getSession(false);
		    TrainingTable obj1 =(TrainingTable) session.getAttribute("userid");
		    session.setAttribute("course",course);
		    int iid= obj1.getId();
		    String name=obj1.getName();
		    
		   
		    try {
				obj.learnerdetails(learnerdetail,iid,name);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		    break;
		}
		
		
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
