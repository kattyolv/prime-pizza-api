package com.kattyolv.prime.pizza.api.dao.test;

import java.util.ArrayList;

import com.kattyolv.prime.pizza.api.dao.DAOOrder;
import com.kattyolv.prime.pizza.api.model.Client;
import com.kattyolv.prime.pizza.api.model.Order;
import com.kattyolv.prime.pizza.api.model.Pizza;

public class DAOOrderTest {

	public static void main(String[] args) {
		
		DAOOrderTest.insertData();
		DAOOrderTest.selectDetailsOrder();
		DAOOrderTest.updateStatus();
	}
	
	public static void insertData() {
		
		System.out.println("INSERT TEST");
		
		DAOOrder orderDAO = new DAOOrder();
		
		Pizza pizza = new Pizza();
		pizza.setId(3);
		
		Client client = new Client();
		client.setId(1);
		
		Order order = new Order();
		order.setQuantity(5);
		order.setStatus("Processing");
		order.setPizza(pizza);
		order.setClient(client);
		
		boolean wasInserted = orderDAO.insertData(order);
		
		if(wasInserted == true) {
			System.out.println("Data was inserted successfully.");
		}
		else {
			System.out.println("Failed to insert data.");
		}
	}
	
	public static void selectDetailsOrder() {
	
		System.out.println("SELECT TEST - LISTING ORDERS");
		
		DAOOrder orderDAO = new DAOOrder();
		
		ArrayList<Order> orderList = orderDAO.selectDetailsOrder();
		
		for (Order order : orderList) {
			System.out.println("Order id: " + order.getId() + "\n" +
					"quantity: " + order.getQuantity() + "\n" +
					"pizza: " + order.getPizza().getName() + "\n" +
					"status: " + order.getStatus() + "\n" +
					"employee: " + order.getEmployee().getName() + "\n");
		}
	}
	
	public static void updateStatus() {

		System.out.println("UPDATE TEST");
		
		DAOOrder orderDAO = new DAOOrder();
		Order order = new Order();
		
		order.setStatus("processing");
		order.setId(1);
		
		boolean wasUpdated = orderDAO.updateStatus(order);
		
		if(wasUpdated == true) {
			System.out.println("Status updated succefully.");
		}
		else {
			System.out.println("Failed to update status.");
		}	
	}

}
