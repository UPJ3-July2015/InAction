package net.lermex.inaction.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import net.lermex.inaction.data.CDataGenerator;

/**
 * Application Lifecycle Listener implementation class H2ContextListener
 *
 */
@WebListener
public class H2ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public H2ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent evnt)  { 
    	ServletContext ctx = evnt.getServletContext();
    	try {
    	 CDataGenerator.generateData();
    	} catch(Exception ex) {
    		ctx.setAttribute("DataException", ex);
    	}
    }
	
}
