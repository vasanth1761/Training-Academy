package com.academy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import com.academy.model.Course;
import com.academy.model.Questions;
import com.academy.model.Result;
import com.academy.model.TrainingTable;
import com.academy.model.VideoInsert;
import com.academy.test.Question;
import com.academy.util.tableConnection;
import com.mysql.cj.protocol.Resultset;






public class TrainingImpl implements TrainingDAO {
	

	

	public void insert(TrainingTable table) throws ClassNotFoundException, SQLException {
		Connection con = tableConnection.getConnection();
		String query = "insert into training_logindetails (user_name, user_email, user_phonenumber,user_password)values(?,?,?,?)";
		PreparedStatement p = con.prepareStatement(query);
		try {
		p.setString(1, table.getName());
		p.setString(2, table.getEmail());
		p.setString(3, table.getPhone());
		p.setString(4, table.getPassword());

		p.executeUpdate();
		}finally {
            try {
                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	@Override
	public boolean insert() throws ClassNotFoundException, SQLException {
		return false;
		
	}

   public boolean register(TrainingTable table) throws ClassNotFoundException, SQLException {
		
		Connection con = tableConnection.getConnection();
		
		String query = "SELECT user_mailid FROM users WHERE user_mailid=?";
		PreparedStatement prepare = con.prepareStatement(query);
		prepare.setString(1, table.getEmail());
		ResultSet result = prepare.executeQuery();
		try {
		if (!result.next()) {
			String check ="insert into users (user_name, user_mailid, user_phonenumber,user_password)values(?,?,?,?)";

			PreparedStatement p = con.prepareStatement(check);
			p.setString(1, table.getName());
			p.setString(2, table.getEmail());
			p.setString(3, table.getPhone());
			p.setString(4, table.getPassword());
			p.execute();
			return true;
		}
		 


		
		return false;
		}finally {
            try {
                prepare.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	
	}
   public boolean login(TrainingTable table) throws ClassNotFoundException, SQLException {
		
	
	    Connection con = tableConnection.getConnection();
		
		String query = "SELECT user_mailid,user_password FROM users WHERE user_mailid=?and user_password=?";
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1,table.getEmail() );
		p.setString(2,table.getPassword());
		ResultSet re = p.executeQuery();
		try {
		if (!re.next()) {
			return false;
		    
			

		}
		return true;
		}finally {
            try {
                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		

	}
   public TrainingTable getid(TrainingTable table)throws ClassNotFoundException,SQLException
   {
	   Connection con=tableConnection.getConnection();
	   String query="SELECT *FROM users WHERE user_mailid=?";
	   PreparedStatement p = con.prepareStatement(query);
	   p.setString(1, table.getEmail());
	   ResultSet re=p.executeQuery();
	   try
	   {
	   while(re.next())
	   {
		   int id=re.getInt("user_id");
		   String name=re.getString("user_name");
		   table.setId(id);
		   table.setName(name);
		   return table;
	   }
	return null;
	   }finally {
           try {
               p.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
	
	   	   
	   
   }
   
   public TrainingTable checkAdmin(TrainingTable table)throws ClassNotFoundException,SQLException
   {
	   Connection con=tableConnection.getConnection();
	   String query="SELECT user_mailid,user_password FROM users WHERE user_mailid=?and user_password=?";
	   PreparedStatement p = con.prepareStatement(query);
	   p.setString(1,table.getEmail() );
	   p.setString(2,table.getPassword());
	   ResultSet re = p.executeQuery();
	   try {
	    if (!re.next()) {
			return null;
		    

		}
	    else
	    {
	    	return table;
	    }
	   }finally {
           try {
               p.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
		
   }
   public void learnerdetails(Course learnerdetail,int iid,String name) throws ClassNotFoundException,SQLException
   {
	   Connection con=tableConnection.getConnection();
	   String date=learnerdetail.getDate();
	   String query="insert into learner_details (learner_id,leaner_name,course_id,course_name,enroll_date)values(?,?,?,?,?)";
	   PreparedStatement p = con.prepareStatement(query);
	   try {
	   p.setInt(1,iid);
       p.setString(2,name);
       p.setInt(3,learnerdetail.getCourseid());
       p.setString(4,learnerdetail.getCourseName());
       p.setString(5,learnerdetail.getDate());
       p.execute();
	   }finally {
           try {
               p.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }

  public void updatepayment(Course payment ,int id)throws ClassNotFoundException,SQLException
  {
	  Connection con=tableConnection.getConnection();
	 
	  String pay="paid";
	  String query="UPDATE learner_details SET accountnumber=?,payment=? WHERE learner_id=?";
	  PreparedStatement p = con.prepareStatement(query);
	  try {
	  p.setString(1,payment.getAccoutNumber());
	  p.setString(2,pay);
	  p.setInt(3, id);
	  p.executeUpdate();
	  }finally {
          try {
              p.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
	  
	  		
  }
  public void insertQuestion(Questions insert)throws ClassNotFoundException,SQLException
  {
	  Connection con=tableConnection.getConnection();
	  String query="insert into question (questions,option_1,option_2,option_3,option_4,correct_answer,category)values(?,?,?,?,?,?,?)";
	  PreparedStatement p = con.prepareStatement(query);
	  try {
	  p.setString(1,insert.getQuestion());
	  p.setString(2, insert.getOptionA());
	  p.setString(3, insert.getOptionB());
	  p.setString(4, insert.getOptionC());
	  p.setString(5, insert.getOptionD());
	  p.setString(6, insert.getCorrectAnswer());
	  p.setString(7,insert.getCourse());
	  p.executeUpdate();
	  }
	  finally {
          try {
              p.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }
  public List<Questions> getAllQuestionsByCategory(String category) throws ClassNotFoundException, SQLException {
      List<Questions> questions = new ArrayList<Questions>();
      Questions insert=new Questions();
      String course = insert.getCourse();
      String option=insert.getOptionA();
	Connection con=tableConnection.getConnection();
    String query = "SELECT * FROM question WHERE category = ?";
    PreparedStatement p = con.prepareStatement(query);
    p.setString(1, category);
    ResultSet re = p.executeQuery();
    try {
    while (re.next()) {
        Questions question = new Questions();
        question.setId(re.getString("id"));
        question.setQuestion(re.getString("questions"));
        question.setOptionA(re.getString("option_1"));
        question.setOptionB(re.getString("option_2"));
        question.setOptionC(re.getString("option_3"));
        question.setOptionD(re.getString("option_4"));
        question.setCorrectAnswer(re.getString("correct_answer"));
        questions.add(question);
    }
    return questions;
    }finally {
        try {
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  }
  public  void delete(int id) throws ClassNotFoundException, SQLException {


		Connection con = tableConnection.getConnection();
		String query = "DELETE FROM question WHERE id=?";
		PreparedStatement p = con.prepareStatement(query);
		try {
		p.setInt(1, id);
		p.executeUpdate();
		}finally {
            try {
                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
  public static  void insertVideo(VideoInsert video) throws ClassNotFoundException, SQLException{
	  Connection con = tableConnection.getConnection();
	  String inserting = "INSERT INTO Videos (VideoTitle, VideoLink, Category) VALUES (?, ?, ?)";
	  PreparedStatement p = con.prepareStatement(inserting);
	  try {
	  p.setString(1, video.getTitle());
      p.setString(2, video.getLink());
      p.setString(3, video.getCategory());
      p.executeUpdate();
	  }finally {
          try {
              p.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }
  
  public List<VideoInsert> getAllVideo(String cours ) throws ClassNotFoundException, SQLException {
      List<VideoInsert> videos = new ArrayList<VideoInsert>();
      Connection con = tableConnection.getConnection();
      
      String getvideo = "SELECT * FROM Videos WHERE category=?";
      PreparedStatement p = con.prepareStatement(getvideo);
      p.setString(1, cours);
      ResultSet re = p.executeQuery();
      try {
      while (re.next()) {
    	  VideoInsert get=new VideoInsert();
          get.setId(re.getString("VideoID")); 
          get.setTitle(re.getString("VideoTitle"));          
          get.setLink(re.getString("VideoLink"));
          videos.add(get);
      }


      return videos;
      }finally {
          try {
              p.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
}
  public Map<String, String> getCorrectAnswersFromDatabase() throws ClassNotFoundException, SQLException {
      
	  Map<String, String> answersMap = new HashMap<>();
	  Connection con = tableConnection.getConnection();
	  String query = "SELECT id,correct_answer from question";
	  PreparedStatement p = con.prepareStatement(query);
      ResultSet re = p.executeQuery();
      try {
      while (re.next()) {
    	 String id= re.getString("id"); 
    	 String option= re.getString("correct_answer");
    	 answersMap.put(id, option);
    	

      }
      return answersMap;
      }finally {
          try {
              p.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      
}
  public  void insertResult(Result result) throws ClassNotFoundException, SQLException{
	  Connection con = tableConnection.getConnection();
	  String insert = "INSERT INTO result_list (learner_id, learner_name, learner_course, learner_score, learner_percentage) " +
              "VALUES (?, ?, ?, ?, ?)";
      PreparedStatement p = con.prepareStatement(insert);
      try {
      p.setInt(1, result.getLearnerid());
      p.setString(2, result.getLearnername());
      p.setString(3, result.getCousename());
      p.setLong(4, result.getCorrectanswer());
      p.setDouble(5, result.getPercentage());
      p.executeUpdate();
      }finally {
          try {
              p.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

	  }

public List<Result> getAllResults() throws ClassNotFoundException, SQLException {
    List<Result> results = new ArrayList<>();
    Connection con = tableConnection.getConnection();
    String query = "SELECT learner_id, learner_name, learner_course, learner_score, learner_percentage FROM result_list";
    PreparedStatement p = con.prepareStatement(query);
    ResultSet re = p.executeQuery();
    try {
    while (re.next()) {
        Result resultop = new Result();
        resultop.setLearnerid(re.getInt("learner_id"));
        resultop.setLearnername(re.getString("learner_name"));
        resultop.setCousename(re.getString("learner_course"));
        resultop.setCorrectanswer(re.getInt("learner_score"));
        resultop.setPercentage( re.getDouble("learner_percentage"));
        results.add(resultop);
    }
    return results;
    }finally {
        try {
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}
public void insertComments(Result result, String comment) throws ClassNotFoundException, SQLException
{   
	Connection con = tableConnection.getConnection();
	  String insert = "INSERT INTO comments (learner_id, learner_name, learner_course, learner_comments) " +
            "VALUES (?, ?, ?, ?)";
    PreparedStatement p = con.prepareStatement(insert);
    try {
    p.setInt(1, result.getLearnerid());
    p.setString(2, result.getLearnername());
    p.setString(3, result.getCousename());
    p.setString(4, comment);
    p.executeUpdate();

	  }finally {
          try {
              p.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
}

public List<Result> getAllComments() throws ClassNotFoundException, SQLException {
    List<Result> results = new ArrayList<>();
    Connection con = tableConnection.getConnection();
    String query = "SELECT learner_id, learner_name, learner_course, learner_comments From comments";
    PreparedStatement p = con.prepareStatement(query);
    ResultSet re = p.executeQuery();
    try {
    while (re.next()) {
        Result resultop = new Result();
        resultop.setLearnerid(re.getInt("learner_id"));
        resultop.setLearnername(re.getString("learner_name"));
        resultop.setCousename(re.getString("learner_course"));
        resultop.setComments(re.getString("learner_comments"));
        results.add(resultop);
    }
    return results;
    }finally {
        try {
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

}
public List<Questions> getAllQuestionsByCategory() throws ClassNotFoundException, SQLException {
    List<Questions> questions = new ArrayList<Questions>();
    Questions insert=new Questions();
    String course = insert.getCourse();
    String option=insert.getOptionA();
	Connection con=tableConnection.getConnection();
  String query = "SELECT * FROM question";
  PreparedStatement p = con.prepareStatement(query);
  ResultSet re = p.executeQuery();
  try {
  while (re.next()) {
      Questions question = new Questions();
      question.setId(re.getString("id"));
      question.setQuestion(re.getString("questions"));
      question.setOptionA(re.getString("option_1"));
      question.setOptionB(re.getString("option_2"));
      question.setOptionC(re.getString("option_3"));
      question.setOptionD(re.getString("option_4"));
      question.setCorrectAnswer(re.getString("correct_answer"));
      question.setCourse(re.getString("category"));
      questions.add(question);
     
  }
  return questions;
  }finally {
      try {
          p.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
public static List<Questions> search (String course)throws ClassNotFoundException, SQLException{
	 
	Connection con=tableConnection.getConnection();
	List<Questions>val=new ArrayList<Questions>();
	String query="select *from question where category like?";
	PreparedStatement p=con.prepareStatement(query);
	p.setString(1,course);
    ResultSet re=p.executeQuery();
    try {
	while(re.next())
	{
		   Questions userp=new Questions();
			userp.setQuestion(re.getString("questions"));
			userp.setOptionA(re.getString("option_1"));
			userp.setOptionB(re.getString("option_2"));
			userp.setOptionC(re.getString("option_3"));
			userp.setOptionD(re.getString("option_4"));
			userp.setCorrectAnswer(re.getString("correct_answer"));
			userp.setCourse(re.getString("category"));
			val.add(userp);
		}
	return val;
    }finally {
        try {
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	}
public static  void updateQ(Questions question,String id) throws ClassNotFoundException, SQLException {
	
	Connection con=tableConnection.getConnection();
	String query=("update question set questions=?,option_1=?,option_2=?,option_3=?,option_4=?,correct_answer=? where id=?");
	PreparedStatement p = con.prepareStatement(query);
	try {
	p.setString(1,question.getQuestion());
	p.setString(2, question.getOptionA());
	p.setString(3, question.getOptionB());
	p.setString(4, question.getOptionC());
	p.setString(5, question.getOptionD());
	p.setString(6, question.getCorrectAnswer());
	p.setString(7,id );
	p.executeUpdate();
	}finally {
        try {
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
public  List<Questions> updatedQuestionTable() throws ClassNotFoundException, SQLException {
	List<Questions> user = new ArrayList<Questions>();
	Connection con = tableConnection.getConnection();
	String query = "SELECT questions,option_1,option_2,option_3,option_4,correct_answer FROM question";
	PreparedStatement p = con.prepareStatement(query);
	ResultSet re = p.executeQuery();
	try {
	while (re.next()) {
		Questions userp = new Questions();
		userp.setQuestion(re.getString("questions"));
		userp.setOptionA(re.getString("option_1"));
		userp.setOptionB(re.getString("option_2"));
		userp.setOptionC(re.getString("option_3"));
		userp.setOptionD(re.getString("option_4"));
		userp.setCorrectAnswer(re.getString("correct_answer"));
		user.add(userp);
	}

	return user;
	}finally {
        try {
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

}
public static  void delete(String id) throws ClassNotFoundException, SQLException {


	Connection con = tableConnection.getConnection();
	String query = "DELETE FROM questions WHERE id=?";
	PreparedStatement p = con.prepareStatement(query);
	p.setString(1, id);
	p.executeUpdate();

}
public List<VideoInsert> getAllVideo() throws ClassNotFoundException, SQLException {
    List<VideoInsert> videos = new ArrayList<VideoInsert>();
    Connection con = tableConnection.getConnection();
    
    String getvideo = "SELECT VideoID,VideoTitle,VideoLink,Category FROM Videos";
    PreparedStatement p = con.prepareStatement(getvideo);
    ResultSet re = p.executeQuery();
  
    while (re.next()) {
  	  VideoInsert get=new VideoInsert();
        get.setId(re.getString("VideoID")); 
        get.setTitle(re.getString("VideoTitle"));          
        get.setLink(re.getString("VideoLink"));
        get.setCategory(re.getString("Category"));
        videos.add(get);
    }
	return videos;
}
}
public static List<VideoInsert> search (String course)throws ClassNotFoundException, SQLException{
	 
	Connection con=tableConnection.getConnection();
	List<Questions>val=new ArrayList<Questions>();
	String query="select *from question where category like?";
	PreparedStatement p=con.prepareStatement(query);
	p.setString(1,course);
    ResultSet re=p.executeQuery();
    try {
	while(re.next())
	{
		   VideoInsert searchVideo=new VideoInsert();
			searchVideo.setCategory(re.getString("Category"));
			searchVideo.setTitle(re.getString("VideoTitle"));
			searchVideo.setLink(re.getString("VideoLink");
			val.add(searchVideo);
		}
	return val;
    }finally {
        try {
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	}}

