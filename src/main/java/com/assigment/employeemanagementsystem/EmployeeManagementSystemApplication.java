package com.assigment.employeemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		try{
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Person","root","can670767");
		Statement statement = connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from Person");
			while (resultSet.next()){
				System.out.println(resultSet.getString("firsName"));
			}

	}catch (Exception e){
			e.printStackTrace();
		}

}
}
