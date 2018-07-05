package com.pram.MytestAPP_jul;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Throwable 
    {

ResourceConfig config = new ResourceConfig();
 config.packages("MytestAPP_jul");
 ServletHolder servlet = new ServletHolder(new ServletContainer(config));

Server server = new Server(9999);
 ServletContextHandler context = new ServletContextHandler(server, "/*");
 context.addServlet(servlet, "/*");
 HandlerList handlers = new HandlerList();
 handlers.addHandler(context);
 handlers.addHandler(new DefaultHandler());
 server.setHandler(handlers);


try {
	 server.start();
     server.join();
}
  //  catch(Exception e){
    	//System.out.println('Y');
  ///  }
finally {
		server.destroy();
	}


    }
}
