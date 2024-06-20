package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;
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

import com.academy.dao.TrainingImpl;
import com.academy.model.Result;

import com.academy.model.TrainingTable;


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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String> answersMap = new HashMap<>();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("answer")) {
                String questionId = paramName.substring("answer".length());
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues != null && paramValues.length > 0) {
                    answersMap.put(questionId, paramValues[0]);
                                      }
                
            }
        }

        
            TrainingImpl checkanswer=new  TrainingImpl();
            Map<String, String> correctAnswersMap = null;
			try {
				correctAnswersMap = checkanswer. getCorrectAnswersFromDatabase();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

        
            int correctCount = 0;
            int totalCount = answersMap.size(); 
            for (Map.Entry<String, String> entry : answersMap.entrySet()) {
                String questionId = entry.getKey();
                String userAnswer = entry.getValue();
                String correctAnswer = correctAnswersMap.get(questionId);
                if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
                    correctCount++;
                }
            }

        
            double percentage = (correctCount * 100.0) / totalCount;

            Result results= new Result();
            HttpSession session = request.getSession(false);
		    TrainingTable obj1 =(TrainingTable) session.getAttribute("userid");
		    String coursename=(String)session.getAttribute("course");
		    String name=obj1.getName();
            request.setAttribute("totalCount", totalCount);
            request.setAttribute("correctCount", correctCount);
            request.setAttribute("percentage", percentage);
            request.setAttribute("name",name);
		    session.setAttribute("count",correctCount);
		    results.setLearnerid(obj1.getId());
		    results.setLearnername(obj1.getName());
		    results.setCousename(coursename);
		    results.setCorrectanswer(correctCount);
		    results.setPercentage(percentage);
		    session.setAttribute("result",results);
		    
		    
		    
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);
        }

        }
	
	


	
