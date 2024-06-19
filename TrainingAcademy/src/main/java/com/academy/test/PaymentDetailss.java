package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class paymentDetailss
 */
@WebServlet("/paymentDetailss")
public class PaymentDetailss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrainingImpl pay=new TrainingImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentDetailss() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Course payment=new Course();
        String accountnumber = request.getParameter("card_number");
		payment.setAccoutNumber(accountnumber);
		String action = request.getParameter("action");
		switch (action) 
		{
		case"paid":
		{  
	    
		HttpSession session = request.getSession(false);
		TrainingTable obj1 =(TrainingTable) session.getAttribute("userid");
	    int id= obj1.getId();
	    try {
			pay.updatepayment(payment,id);
			response.sendRedirect("paymentsuccessfull.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	@Override
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
