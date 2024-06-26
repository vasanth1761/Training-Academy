package com.academy.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.dao.TrainingImpl;
import com.academy.model.Questions;




/**
 * Servlet implementation class ViewQuestions
 */
@WebServlet("/ViewQuestions")
public class ViewQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewQuestions() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		TrainingImpl getquestion= new TrainingImpl();
		try {
			List<Questions>questions=getquestion.getAllQuestionsByCategory();
			request.setAttribute("questions",questions);
		
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		 RequestDispatcher req=request.getRequestDispatcher("viewquestion.jsp");
 		req.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	@Override
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TrainingImpl search=new TrainingImpl();
		String action=request.getParameter("action");
        if(action!=null)
        switch(action)
        {
        case"search":
        {
		String name=request.getParameter("searchname");
			try {
				List<Questions>obj=search.search(name);
	            request.setAttribute("questions", obj);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher req=request.getRequestDispatcher("viewquestion.jsp");
    		req.forward(request, response);
    		break;
        }
        case"update":
    	{
    		
    	 Questions question=new Questions();
    	 String upid=request.getParameter("updateid");
    	 System.out.println(upid);
    	 question.setId(upid);
    	 question.setQuestion(request.getParameter("Question"));
    	 question.setOptionA(request.getParameter("OptionA"));
    	 question.setOptionB(request.getParameter("OptionB"));
    	 question.setOptionC(request.getParameter("OptionC"));
    	 question.setOptionD(request.getParameter("OptionD"));
    	 question.setCorrectAnswer(request.getParameter("CorrectAnswer"));
    	 TrainingImpl updateQuestion=new TrainingImpl();
    	 try {
			updateQuestion.updateQ(question, upid);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
    	 try {
			List<Questions>updatedQuestions=updateQuestion.updatedQuestionTable();
			request.setAttribute("questions",updatedQuestions);
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
    	 RequestDispatcher req=request.getRequestDispatcher("viewquestion.jsp");
  		req.forward(request, response);
     	break;

		}
        case"Delete":
        {
        	int deleteid=Integer.parseInt(request.getParameter("delete"));
        	TrainingImpl userdelete=new TrainingImpl();
        
        	try {
				userdelete.delete(deleteid);
				
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
        	try {
        		request.setAttribute("questions",userdelete.getAllQuestionsByCategory());

                
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        
        	 RequestDispatcher req=request.getRequestDispatcher("viewquestion.jsp");
     		req.forward(request, response);
        	break;
        }

}
}
}
