/*
  * Copyright (c) 2016 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.tomcat.chapter.two;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Sui Canghai
 * 2016年9月7日
 *
 */
public class TestClassLoader {

	public static void main(String[] args) throws Exception{
		File file = new File("D:/workspace/HowTomcatWorks/WEB-INF/classes/com/tomcat/chapter/two/PrimitiveServlet.class");
		System.out.println(file.exists());
		URL[] urls = 
			{new URL("file:PrimitiveServlet.class")};
		URLClassLoader loader = new URLClassLoader(urls);
		PrimitiveServlet p = (PrimitiveServlet)loader.loadClass("com.tomcat.chapter.two.PrimitiveServlet").newInstance();
		
		
//		URL[] urls = {new URL("file:mysql-connector-java-5.0.5.jar")};
//		URLClassLoader myClassLoader = new URLClassLoader(urls);
//		PrimitiveServlet p = (PrimitiveServlet)myClassLoader.
//				loadClass("PrimitiveServlet").newInstance();
	}
}
