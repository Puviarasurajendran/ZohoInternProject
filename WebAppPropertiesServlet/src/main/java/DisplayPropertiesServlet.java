


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/displayProperties")
public class DisplayPropertiesServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Properties properties = new Properties();
        InputStream input = null;
        
        try {
            // Load the properties file from the classpath
            input = getServletContext().getResourceAsStream("/WEB-INF/configuration.properties");
            if (input != null) {
                properties.load(input);
            } else {
                out.println("<p style='color: red;'>Property file not found!</p>");
                return;
            }
        } catch (IOException ex) {
            out.println("<p style='color: red;'>Error reading property file: " + ex.getMessage() + "</p>");
            return;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Property File Content</title>");
        out.println("<style>");
        out.println("body { display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f9f9f9; }");
        out.println(".container { border: 1px solid #ccc; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 10px; background-color: #fff; text-align: left; width: 50%; }");
        out.println("table { width: 100%; border-collapse: collapse; }");
        out.println("th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Property File Content</h1>");
        out.println("<table>");
        out.println("<tr><th>Key</th><th>Value</th></tr>");

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            out.println("<tr><td>" + key + "</td><td>" + value + "</td></tr>");
        }

        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
