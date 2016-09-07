/*
  * Copyright (c) 2016 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.tomcat.chapter.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Sui Canghai
 * 2016年9月6日
 *
 */
public class HttpServer1 {

	private static final String SHUTDOWN_COMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	public static void main(String[] args) {
		HttpServer1 server = new HttpServer1();
		server.await();
	}
	
	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while(!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				Request request = new Request(input);
				request.parse();
				Response response = new Response(output);
				response.setRequest(request);
				if(request.getUri().startsWith("/servlet/")) {
					ServletProcessor1 processor = new ServletProcessor1();
					processor.process(request, response);
				} else {
					StaticResourceProcessor processor = 
						new StaticResourceProcessor();
					processor.process(request, response);
				}
			}  catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
