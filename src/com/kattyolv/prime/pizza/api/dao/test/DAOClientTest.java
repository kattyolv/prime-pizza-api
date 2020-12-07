package com.kattyolv.prime.pizza.api.dao.test;

import com.kattyolv.prime.pizza.api.dao.DAOClient;
import com.kattyolv.prime.pizza.api.model.Client;

public class DAOClientTest {

	public static void main(String[] args) {
		
		DAOClientTest.insertTest();
			

	}
	
	public static void insertTest() {
		
		System.out.println("INSERT TEST");
		
		DAOClient clientDAO = new DAOClient();
		Client client = new Client();
		
		// NOTE: if you want to execute this method again, it's necessary to change the info below
		
		client.setName("John");
		client.setAddress("Porto");
		client.setEmail("john@gmail.com");
		client.setPassword("54321");
		
		boolean wasInserted = clientDAO.insertData(client);
		
		if(wasInserted == true) {
			System.out.println("Data inserted successfully.");
		}
		else {
			System.out.println("Fail to insert data.");
		}
	}

}