/*
  * Copyright (c) 2016 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.tomcat.chapter.two;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Sui Canghai
 * 2016年9月6日
 *
 */
public class ServletProcessor1 {

	public void process(Request request, Response response) {
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		URLClassLoader loader = null;
		try {
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File("D:/workspace/HowTomcatWorks/WEB-INF/classes/com/tomcat/chapter/two/");
			String repository = (new URL("file", null, 
					classPath.getCanonicalPath() + File.separator)).toString();
			urls[0] = new URL(null, repository, streamHandler);
			loader = new URLClassLoader(urls);
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		Class myClass =null;
		try {
			myClass = loader.loadClass("com.tomcat.chapter.two." + servletName);
		} catch(ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		try {
			servlet = (Servlet)myClass.newInstance();
			servlet.service((ServletRequest)request, (ServletResponse)response);
		} catch(Exception e) {
			System.out.println(e.toString());
		} catch(Throwable e) {
			System.out.println(e.toString());
		}
	}
}
