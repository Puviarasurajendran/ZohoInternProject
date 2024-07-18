package com.zoho.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class InvalidInputNum2Filter
 */
public class InvalidInputNum2Filter extends HttpFilter implements Filter {
       


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		try {
		String num2= request.getParameter("number2");
		
		Double n2=Double.parseDouble(num2);
		if(n2>0) {
		chain.doFilter(request, response);
		}
		else {
			   out.println("<html><head>");
	            out.println("<style>");
	            out.println("body { display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; text-align: center; }");
	            out.println(".container { border: 1px solid #ccc; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 10px; }");
	            out.println("</style>");
	            out.println("</head><body>");
	            out.println("<div class='container'>");
	            out.println("<h1>Simple Calculator</h1>");
	            out.println("<p style='color: red;'>Number2 Negative value can n't be acceptable</p>");
	            out.println("<a href='index.jsp'>Try Again</a>");
	            out.println("</div>");
	            out.println("</body></html>");

	            out.close();
		}
		}
		catch (NumberFormatException e) {
         out.println("<html><head>");
         out.println("<style>");
         out.println("body { display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; text-align: center; }");
         out.println(".container { border: 1px solid #ccc; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 10px; }");
         out.println("</style>");
         out.println("</head><body>");
         out.println("<div class='container'>");
         out.println("<h1>Simple Calculator</h1>");
         out.println("<p style='color: red;'>Please enter valid numbers.</p>");
         out.println("<a href='index.jsp'>Try Again</a>");
         out.println("</div>");
         out.println("</body></html>");

         out.close();
     }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
//      System.out.println("<><><<><><><><><><><><>Filter Num2 is called<><><><><><><><><><><>");
	}
   
	public void destroy() {
//		System.out.println("<><><<><><><><><><><><>Filter Num2 is destroy<><><><><><><><><><><>");
	}

	
}
