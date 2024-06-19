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
import com.academy.model.TrainingTable;

/**
 * Servlet implementation class training
 */
@WebServlet("/training")
public class training extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrainingTable table = new TrainingTable();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public training() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("number");
		String password = request.getParameter("password");
		table.setName(userName);
		table.setEmail(email);
		table.setPhone(phonenumber);
		table.setPassword(password);
		String action = request.getParameter("action");
		switch (action) {

		case "register": {
			trainingImpl obj = new trainingImpl();
			try {
				if (obj.register(table)) {
					response.sendRedirect("landingpage.jsp");
				} else {
					request.setAttribute("errorMessage", "Account already there So please Login");
					request.getRequestDispatcher("landingpage.jsp").forward(request,response);
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		case "login":

		{
			trainingImpl obj = new trainingImpl();
			try {
				if (obj.login(table)) {
					TrainingTable id = obj.getid(table);
					HttpSession session = request.getSession();
					session.setAttribute("userid", id);
					String email1=table.getEmail();
					if(email1.endsWith("@coursehub.com"))
					{
						response.sendRedirect("admin.jsp");
					}
					else
					{
						response.sendRedirect("categories.jsp");
					}
//					
				} else {
					request.setAttribute("errorMessage", "you dont have an account please Register");
					response.sendRedirect("Register.jsp");
				}
			}

//				
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		}
	}
        


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
