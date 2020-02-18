package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.HttpException;
import com.revature.services.PokemonService;

public class PokemonServlet extends HttpServlet {

	PokemonService pokemonService = new PokemonService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		System.out.println(request.getContextPath()); // "/my-first-servlet-app"
//		System.out.println(request.getPathInfo());
//		System.out.println(request.getPathTranslated());
//		System.out.println(request.getRequestURI()); // "/my-first-servlet-app/pokemon"
//		System.out.println(request.getRequestURL()); // "http://local...."
		
		String pathInfo = request.getPathInfo();
		String[] parts = pathInfo.split("/");
//		Arrays.asList(parts).forEach(System.out::println);
		int id = Integer.parseInt(parts[1]);
		response.setContentType("application/json");
		try {
			String pokemon = pokemonService.getPokemon(id);
			
			response.getWriter().write(pokemon);			
		} catch (HttpException e) {
			response.setStatus(e.getStatusCode());
			response.getWriter().write(String
					.format("{\"message\": \"%s\"}", e.getMessage()));
		}
	}
}
