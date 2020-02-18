package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Hierarchy:
 * 
 * Servlet (Interface)
 * GenericServlet
 * HttpServlet
 * YourServlet (you make this one)
 * 
 * 
 * 
 * Servlets are just normal Java classes.
 * A servlet should extend a class implementing the Servlet interface
 * or implement the interface itself.
 * 
 * There are a variety of servlets for various kinds of network 
 * communication.  We are interested in HTTP, so we will extend the
 * HttpServlet.
 */
public class HelloServlet extends HttpServlet {
	
	/**
	 * An object lifecycle is a collection of functions or methods
	 * that represent important stages for the object. These lifecycle
	 * methods are offered as 'hooks', allowing us to invoke our code
	 * when the object reaches this lifecycle.
	 * 
	 * 3 lifecycle stages
	 * 1. init - This stage is called when the servlet first
	 * 		initializes. init has a couple implementations, it's 
	 * 		recommended that you override the no-args init method.
	 * 
	 * 2. service - Service is called once for every request that is
	 * 		routed to this servlet. The service method represents the
	 * 		handling of the request.
	 * 
	 * 3. destroy - Final lifecycle method called once before the 
	 * 		servlet is shut down. Don't generally rely on destroy to
	 * 		do any final data persistence.  It's a dangerous idea.
	 * 
	 * Sservlet interface methods are necessarily PUBLIC
	 */
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet initializing");
	}
	
	/* Not the actual lifecycle method for service, but
	 * the one we should use in an HttpServlet 
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Request routed to servlet");
//		resp.().println("<!DOCTYPE html><html><head></head><body><h1>Hello!</h1></body></html>");
		super.service(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet being destroyed");
		super.destroy();
	}
	
	
	/*
	 * These methods are defined by the HttpServlet and are thus not public. 
	 * HttpServlet (class) methods are protected.
	 */
	
	/* These methods are called automatically by the service method. If we 
	 * override service with different behavior, they will not be called.
	 * If you must override service, be sure to call super.service() at the
	 * end to ensure the Http methods are called.
	 * 
	 * doGet - READ data
	 * doPost - CREATE data
	 * doPut - UPDATE (or create) data
	 * doDelete - DELETE data
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Routed to doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Routed to doPost");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Routed to doPut");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Routed to doDelete");
	}
}
