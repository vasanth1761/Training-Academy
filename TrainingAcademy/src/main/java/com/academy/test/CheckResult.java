package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academy.dao.trainingImpl;
import com.academy.model.resultP;
import com.academy.model.trainingTableP;


/**
 * Servlet implementation class CheckResult
 */
@WebServlet("/CheckResult")
public class CheckResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String> answersMap = new HashMap<>();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName);
            if (paramName.startsWith("answer")) {
                String questionId = paramName.substring("answer".length());
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues != null && paramValues.length > 0) {
                    answersMap.put(questionId, paramValues[0]);
                                      }
                
            }
        }

        
            trainingImpl checkanswer=new  trainingImpl();
            Map<String, String> correctAnswersMap = null;
			try {
				correctAnswersMap = checkanswer. getCorrectAnswersFromDatabase();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Validate answers
            int correctCount = 0;
            int totalCount = answersMap.size(); // Total number of questions attempted
            for (Map.Entry<String, String> entry : answersMap.entrySet()) {
                String questionId = entry.getKey();
                String userAnswer = entry.getValue();
                String correctAnswer = correctAnswersMap.get(questionId);
                if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
                    correctCount++;
                }
            }

            // Calculate percentage
            double percentage = (correctCount * 100.0) / totalCount;

            // Set result attributes to be forwarded to the result JSP page
            HttpSession session = request.getSession(false);
		    trainingTableP obj1 =(trainingTableP) session.getAttribute("userid");
		    String course=(String) session.getAttribute("jack");
		    String name=obj1.getName();
            request.setAttribute("totalCount", totalCount);
            request.setAttribute("correctCount", correctCount);
            request.setAttribute("percentage", percentage);
            request.setAttribute("name",name);
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);
        }

        }
	
	


	
