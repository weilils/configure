package com.o2o.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

class db
{
	public db() {
		// TODO Auto-generated constructor stub
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("success");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/o2o", "root", "2849923947");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}

}

public class test {

	
	public static void main(String[] args)
	{
//		new db();
//		System.out.print("test");
	}

}

