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

import com.academy.dao.trainingImpl;
import com.academy.model.videoP;

/**
 * Servlet implementation class Video
 */
@WebServlet("/Video")
public class Video extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Video() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		videoP video=new videoP();
		trainingImpl invideo=new trainingImpl();
		doGet(request, response);
        String title = request.getParameter("title");
        String link = request.getParameter("link");
        String category = request.getParameter("category");
        video.setTitle(title);
        video.setLink(link);
        video.setCategory(category);
        try {
			invideo.insertVideo(video);
//			List<videoP>videosop=invideo.getAllVideo();
//			request.setAttribute("opvideo",videosop);
//			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
//	            dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        

	}

}
;