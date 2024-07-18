package com.zoho;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CalculateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        System.out.println("<><><><><><><><><><>><><>Inside CalculateServlet Class<><><><><><><><><><>");
        String number1Str = request.getParameter("number1");
        String number2Str = request.getParameter("number2");

        PrintWriter out = response.getWriter();
        try {

            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);

            double sum = number1 + number2;


            out.println("<html><head>");
            out.println("<style>");
            out.println("body { display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; text-align: center; }");
            out.println(".container { border: 1px solid #ccc; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 10px; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<div class='container'>");
            out.println("<h1>Simple Calculator</h1>");
            out.println("<p>" + number1 + " + " + number2 + " = " + "<b>"+sum +"</b>"+ "</p>");
            out.println("<a href='index.jsp'>Try Again</a>");
            out.println("</div>");
            out.println("</body></html>");
            } catch (NumberFormatException e) {
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
}
