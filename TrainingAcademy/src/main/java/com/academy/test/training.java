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
import com.academy.model.trainingTableP;

/**
 * Servlet implementation class training
 */
@WebServlet("/training")
public class training extends HttpServlet {
	private static final long serialVersionUID = 1L;
	trainingTableP table = new trainingTableP();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public training() {
		super();
		// TODO Auto-generated constructor stub
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
		System.out.println(action);
		switch (action) {

		case "register": {
			trainingImpl obj = new trainingImpl();
			try {
				if (obj.register(table)) {
					response.sendRedirect("landingpage.jsp");
				} else {
					request.setAttribute("errorMessage", "Account already there So please Login");
//					response.sendRedirect("landingpage.jsp");
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
					trainingTableP id = obj.getid(table);
					System.out.println(id);
					HttpSession session = request.getSession();
					System.out.println(id);
					session.setAttribute("userid", id);
//					response.sendRedirect("welcome.jsp");
//					trainingTableP check=obj.checkAdmin(table);
					String email1=table.getEmail();
					if(email1.endsWith("@coursehub.com"))
					{
						response.sendRedirect("admin.jsp");
					}
					else
					{
						response.sendRedirect("course.jsp");
					}
//					
				} else {

					response.sendRedirect("Register.jsp");
				}
			}

//				
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		}
        
//		try {
//			obj.insert(table);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		obj.register(obj);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
