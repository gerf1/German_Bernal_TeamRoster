package com.codingdojo.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("delete") != null) {
			Team.getTeams().remove(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("/Roster/Home");
		}else {
			request.getRequestDispatcher("/WEB-INF/lib/playerList.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("id") != null) {
			Team.getTeams().get(Integer.parseInt(request.getParameter("id"))).addPlayer(request.getParameter("first_name"), request.getParameter("last_name"), Integer.parseInt(request.getParameter("age")));
			response.sendRedirect("/Roster/Teams?id="+request.getParameter("id"));
		}else {
			doGet(request, response);
		}
		
	}

}