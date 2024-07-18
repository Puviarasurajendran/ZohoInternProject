<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zoho calci</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f9f9f9; /* Optional: Adds a light background color */
    }
    .container {
        border: 1px solid #ccc;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        background-color: #fff;
        text-align: center;
    }
    form {
        display: inline-block;
        margin: 0;
    }
    label{
        display: block;
        text-align: left;
    }
    input{
       text-align: center;
    }
</style>
</head>
<body>
    <div class="container">
        <form method="post" action="calculate">
            <h1>Simple Calculator</h1>
            <label for="number1">Number 1:</label>
            <input type="text" id="number1" name="number1" required>
             <br></br>
            <label for="number2">Number 2:</label>
            <input type="text" id="number2" name="number2" required>
            <br></br>
            <input type="submit" value="Calculate">
        </form>
    </div>
</body>
</html>
