package com.academy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.academy.model.courseP;
import com.academy.model.trainingTableP;
import com.academy.util.tableConnection;




public class trainingImpl implements trainingDAO {
	

	public void insert(trainingTableP table) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = tableConnection.getConnection();
		String query = "insert into training_logindetails (user_name, user_email, user_phonenumber,user_password)values(?,?,?,?)";
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, table.getName());
		p.setString(2, table.getEmail());
		p.setString(3, table.getPhone());
		p.setString(4, table.getPassword());

		p.executeUpdate();

	}

	@Override
	public boolean insert() throws ClassNotFoundException, SQLException {
		return false;
		// TODO Auto-generated method stub
		
	}

   public boolean register(trainingTableP table) throws ClassNotFoundException, SQLException {
		
		Connection con = tableConnection.getConnection();
		
		String query = "SELECT user_mailid FROM users WHERE user_mailid=?";
		PreparedStatement prepare = con.prepareStatement(query);
		prepare.setString(1, table.getEmail());
		ResultSet result = prepare.executeQuery();
		if (!result.next()) {
			String check ="insert into users (user_name, user_mailid, user_phonenumber,user_password)values(?,?,?,?)";

			PreparedStatement p = con.prepareStatement(check);
			p.setString(1, table.getName());
			p.setString(2, table.getEmail());
			p.setString(3, table.getPhone());
			p.setString(4, table.getPassword());
			p.execute();
			System.out.println("registered  successfull");
			return true;
		}  
//			Systemelse.err.println("you already have an account");
//			System.err.println("please login ");
////			login();
//			System.out.println("Registered Successfully ");

		
		return false;
	
	}
   public boolean login(trainingTableP table) throws ClassNotFoundException, SQLException {
		
	
		Scanner sc = new Scanner(System.in);
		Connection con = tableConnection.getConnection();
		
		String query = "SELECT user_mailid,user_password FROM users WHERE user_mailid=?and user_password=?";
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1,table.getEmail() );
		p.setString(2,table.getPassword());
		ResultSet re = p.executeQuery();
		if (!re.next()) {
			return false;
		    
			

		}
		return true;
		

	}
   public trainingTableP getid(trainingTableP table)throws ClassNotFoundException,SQLException
   {
	   Connection con=tableConnection.getConnection();
	   String query="SELECT *FROM users WHERE user_mailid=?";
	   PreparedStatement p = con.prepareStatement(query);
	   p.setString(1, table.getEmail());
	   ResultSet re=p.executeQuery();
	   while(re.next())
	   {
		   int id=re.getInt("user_id");
		   String name=re.getString("user_name");
		   System.out.println(id);
		   System.out.println(name);
		   table.setId(id);
		   table.setName(name);
		   return table;
	   }
	return null;
	
	   	   
	   
   }
   
   public trainingTableP checkAdmin(trainingTableP table)throws ClassNotFoundException,SQLException
   {
	   Connection con=tableConnection.getConnection();
	   String query="SELECT user_mailid,user_password FROM users WHERE user_mailid=?and user_password=?";
	   PreparedStatement p = con.prepareStatement(query);
	   p.setString(1,table.getEmail() );
	   p.setString(2,table.getPassword());
	   ResultSet re = p.executeQuery();
	    if (!re.next()) {
			return null;
		    

		}
	    else
	    {
	    	return table;
	    }
		
   }
   public void learnerdetails(courseP learnerdetail,int iid,String name) throws ClassNotFoundException,SQLException
   {
	   Connection con=tableConnection.getConnection();
	   String date=learnerdetail.getDate();
	   System.out.println(date);
	   String query="insert into learner_details (learner_id,leaner_name,course_id,course_name,enroll_date)values(?,?,?,?,?)";
	   PreparedStatement p = con.prepareStatement(query);
	   p.setInt(1,iid);
       p.setString(2,name);
       p.setInt(3,learnerdetail.getCourseid());
       p.setString(4,learnerdetail.getCourseName());
       p.setString(5,learnerdetail.getDate());
       p.execute();
   }


}
	

