package com.kattyolv.prime.pizza.api.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kattyolv.prime.pizza.api.dao.DAOClient;
import com.kattyolv.prime.pizza.api.model.Client;


@WebServlet("/client")
public class ClientController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		
		if(email == null) {
			response.setStatus(400);
		}
		else {
			DAOClient clientDAO = new DAOClient();
			
			Client client = clientDAO.selectClientByEmail(email);
			
			if(client != null) {
				
				Gson gson = new Gson();
				String clientJson = gson.toJson(client);
				
				response.setContentType("application/json");
				
				PrintWriter out = response.getWriter();
				out.print(clientJson);
				
				response.setStatus(200);
			}
			else {
				response.setStatus(204);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DAOClient clientDAO = new DAOClient();
			Client client = new Client();
			
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			client.setName(name);
			client.setAddress(address);
			client.setEmail(email);
			client.setPassword(password);
			
			boolean wasInserted = clientDAO.insertData(client);
			
			if(wasInserted == true) {
				response.setStatus(200);
			}
			else {
				response.setStatus(400);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
		
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
}
