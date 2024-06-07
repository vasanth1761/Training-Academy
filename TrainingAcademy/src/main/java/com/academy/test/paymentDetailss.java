package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class paymentDetailss
 */
@WebServlet("/paymentDetailss")
public class paymentDetailss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	trainingImpl pay=new trainingImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentDetailss() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		courseP payment=new courseP();
        String accountnumber = request.getParameter("card_number");
		System.out.println(accountnumber);
		payment.setAccoutNumber(accountnumber);
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) 
		{
		case"paid":
		{  
	    
		HttpSession session = request.getSession(false);
		trainingTableP obj1 =(trainingTableP) session.getAttribute("userid");
	    int id= obj1.getId();
	    System.out.println(id);
	    try {
			pay.updatepayment(payment,id);
			response.sendRedirect("paymentsuccessfull.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
