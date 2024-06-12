package com.academy.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class question
 */
@WebServlet("/question")
public class question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<questionsP>list= new ArrayList<questionsP>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public question() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        trainingImpl inserttable = new trainingImpl();
        questionsP insert = new questionsP();
        
        String question = request.getParameter("question");
        System.out.println(question);
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        String correctoption = request.getParameter("correctAnswer");
        System.out.println(correctoption);
        String course = request.getParameter("course");
        System.out.println(course);
        
        insert.setQuestion(question);
        insert.setOptionA(option1);
        insert.setOptionB(option2);
        insert.setOptionC(option3);
        insert.setOptionD(option4);
        insert.setCorrectAnswer(correctoption);
        insert.setCourse(course);
        
        try {
            inserttable.insertQuestion(insert);
            String category = insert.getCourse();
            System.out.println(category);
            List<questionsP> questions = inserttable.getAllQuestionsByCategory(category);
            request.setAttribute("questions", questions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("javaquestions.jsp");
            dispatcher.forward(request, response);
          //  response.sendRedirect("javaquestions.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception
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
