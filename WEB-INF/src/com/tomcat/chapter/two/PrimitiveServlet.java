/*
  * Copyright (c) 2016 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.tomcat.chapter.two;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Sui Canghai
 * 2016年9月6日
 *
 */
public class PrimitiveServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}
	
	public void service(ServletRequest reuquest, ServletResponse response) 
		throws ServletException, IOException {
		System.out.println("from service");
		PrintWriter out = response.getWriter();
		out.println("Hello. Rose are red.");
		out.print("Viloets are blue.");
	}
	
	public void destroy() {
		System.out.println("destory");
	}
	
	public String getServletInfo() {
		return null;
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
}
