package com.academy.test;

import java.io.IOException;

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
import com.academy.model.Questions;


/**
 * Servlet implementation class question
 */
@WebServlet("/question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Questions>list= new ArrayList<Questions>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        trainingImpl inserttable = new trainingImpl();
        Questions insert = new Questions();
        
        String question = request.getParameter("question");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        String correctoption = request.getParameter("correctAnswer");
        String course = request.getParameter("course");
   
        
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
            List<Questions> questions = inserttable.getAllQuestionsByCategory(category);
            request.setAttribute("questions", questions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("javaquestions.jsp");
            dispatcher.forward(request, response);
        
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
           
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		doGet(request, response);
	}

	
}
