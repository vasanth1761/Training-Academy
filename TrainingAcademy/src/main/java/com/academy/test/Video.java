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
import com.academy.model.VideoInsert;


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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VideoInsert video=new VideoInsert();
		trainingImpl invideo=new trainingImpl();
		doGet(request, response);
        String title = request.getParameter("title");
        String link = request.getParameter("link");
        String category = request.getParameter("category");
        video.setTitle(title);
        video.setLink(link);
        video.setCategory(category);
        String course=video.getCategory();
        
        try {
			invideo.insertVideo(video);
			List<VideoInsert>videosop=invideo.getAllVideo(course);
			request.setAttribute("opvideo",videosop);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("videooutput.jsp");
	            dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
        
        

	}

	

}
