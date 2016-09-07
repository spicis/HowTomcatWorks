/*
  * Copyright (c) 2016 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.tomcat.chapter.two;

import java.io.IOException;

/**
 * @author Sui Canghai
 * 2016年9月6日
 *
 */
public class StaticResourceProcessor {

	public void process(Request request, Response response) {
		try {
			response.sendStaticResource();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
