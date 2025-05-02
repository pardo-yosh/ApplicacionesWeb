<%@page import="java.util.Enumeration"%>
<%@page import="edu.pucp.mechatronics.model.Product"%>
<%@page import="edu.pucp.mechatronics.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        form {
            text-align: center;
        }
        input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus {
            border-color: #007bff;
            outline: none;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Edit Product Information</h1>
    <%
        ProductDAO dao = new ProductDAO();
        int id = Integer.parseInt((String)request.getAttribute("idProd"));
        Product p = dao.find(id);
    %>
    <form action="Controller">
        <label for="txtName">Product:</label><br>
        <input type="text" id="txtName" name="txtName" value="<%= p.getName()%>"><br>
        <label for="txtStock">Stock:</label><br>
        <input type="text" id="txtStock" name="txtStock" value="<%= p.getStock()%>"><br>
        <input type="hidden" name="txtId" value="<%= p.getId()%>">
        <input type="submit" name="action" value="Update"><br>
    </form>
</div>

</body>
</html>
