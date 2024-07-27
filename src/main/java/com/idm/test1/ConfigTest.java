package com.idm.test1;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;

public class ConfigTest{

	public static void main(String[] args) {
		testDataSource();
	}
	
	public static void testDataSource() {
		   
		   AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Beans.class); 
		   
		   DataSource ds = factory.getBean("dataSource", DataSource.class); 
		   System.out.println(factory.containsBean("dataSource"));
		   
		   Connection connection=null;
		   try {
			   connection = (Connection)ds.getConnection();
		   } catch (SQLException e) {
				e.printStackTrace();
		   }
		   System.out.println(connection);
		   factory.close();    
   }
	
	

	  
	  



		   
}
