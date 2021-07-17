package com.example.azureDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	
	public static   List<Course> getCourses() {
		
		List<Course> listOfCourses = null;
		
			String dbURL = "jdbc:sqlserver://dbservermpyla.database.windows.net:1433;database=myFirstDb;user=arunvasavi@dbservermpyla;password=adminUser@2021;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			 String user = "arunvasavi";
	         String pass = "adminUser@2021";
	         try(Connection conn = DriverManager.getConnection(dbURL)) {
	        	 if(conn != null) {
	        		String query = "select * from course";
	        		Statement stmt = conn.createStatement();
	        		ResultSet rset = stmt.executeQuery(query);
	        				
	        		if(rset != null) {
	        			listOfCourses = new ArrayList<Course>();
	        			while(rset.next()) {
	        				Course course = new Course();
	        				course.setCourseId(rset.getInt(1));
	        				course.setCourseName(rset.getString(2));
	        				course.setRating(rset.getFloat(3));
	        				listOfCourses.add(course);
	        			}
	        		}
	        	 }
         
		      } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	         return listOfCourses;
		
	}

}
