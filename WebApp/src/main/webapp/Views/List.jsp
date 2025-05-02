<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        td a {
            margin-right: 5px;
            text-decoration: none;
        }
        td a:hover {
            text-decoration: underline;
        }
        .btn-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .back-btn, .create-btn {
            width: 150px;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-btn:hover, .create-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Productos</h1>
    <div class="btn-container">
        <a class="back-btn" href="index.jsp">Pagina principal</a>
        <a class="create-btn" href="Controller?action=goAdd">Crear un nuevo producto</a>
    </div>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Product</th>
                <th>Stock</th>
                <th>Actions</th>
            </tr>    
        </thead>
        <tbody>
        <c:forEach var="element" items="${products}">
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.stock}</td>
                <td>
                    <a href="Controller?action=goEdit&id=${element.id}">Editar</a>
                    <a href="Controller?action=Delete&id=${element.id}">Eliminar</a>                 
                </td>
            </tr>
        </c:forEach> 
        </tbody>
    </table>
</div>

</body>
</html>
