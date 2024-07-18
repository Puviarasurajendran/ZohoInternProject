<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dmart Supermarket Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="sidebar">
        <div class="sidebar-header">
            <h2>Dmart</h2>
        </div>
        <ul class="sidebar-menu">
            <li><a href="pages/customers.jsp"><i class="fas fa-users"></i> Customers</a></li>
            <li><a href="pages/products.jsp"><i class="fas fa-boxes"></i> Products</a></li>
            <li><a href="pages/sales_summary.jsp"><i class="fas fa-chart-line"></i> Sales Summary</a></li>
            <li><a href="pages/invoice_billing.jsp"><i class="fas fa-file-invoice-dollar"></i> Invoice Billing</a></li>
        </ul>
    </div>
    <div class="main-content">
        <jsp:include page="pages/customers.jsp" />
    </div>
    <script src="js/scripts.js"></script>
</body>
</html>
