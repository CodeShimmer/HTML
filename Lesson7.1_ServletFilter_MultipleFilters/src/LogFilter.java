// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet(
		urlPatterns = { "/LogFilter" }
//		initParams = { 
//				@WebInitParam(name = "test-param", value = "testvalue")
//		})
		)
// Implements Filter class
public class LogFilter implements Filter  {
	private static final long serialVersionUID = 1L;

   public void  init(FilterConfig config) throws ServletException {
	   
      
      // Get init parameter 
      String testParam = config.getInitParameter("test-param"); 

      //Print the init parameter 
      System.out.println("Test Param: " + testParam); 
   }
   
   public void  doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws java.io.IOException, ServletException {

      // Get the IP address of client machine.
      String ipAddress = request.getRemoteAddr();

      // Log the IP address and current timestamp.
      System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());

      // Pass request back down the filter chain
      chain.doFilter(request,response);
   }

   public void destroy( ) {
      /* Called before the Filter instance is removed from service by the web container*/
   }
}