<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Property File Content</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f9f9f9;
        }
        .container {
            border: 1px solid #ccc;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            background-color: #fff;
            text-align: left;
            width: 50%;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Property File Content</h1>
        <%
            Properties properties = new Properties();
            InputStream input = null;
            try {
        
                input = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
                if (input != null) {
                    properties.load(input);
        %>
                    <table>
                        <tr>
                            <th>Key</th>
                            <th>Value</th>
                        </tr>
        <%
                    for (String key : properties.stringPropertyNames()) {
                        String value = properties.getProperty(key);
        %>
                        <tr>
                            <td><%= key %></td>
                            <td><%= value %></td>
                        </tr>
        <%
                    }
                } else {
        %>
                    <p style="color: red;">Property file not found!</p>
        <%
                }
            } catch (IOException ex) {
                out.println("<p style='color: red;'>Error reading property file: " + ex.getMessage() + "</p>");
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        %>
                    </table>
    </div>
</body>
</html>
