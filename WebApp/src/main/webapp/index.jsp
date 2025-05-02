<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Prueba de Ingesta de Productos</title>
		<style>
		  body {
		    font-family: Arial, sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f8f9fa;
		  }
		  .container {
		    max-width: 800px;
		    margin: 50px auto;
		    padding: 20px;
		    background-color: #ffffff;
		    border-radius: 10px;
		    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
		  }
		  h1 {
		    color: #343a40;
		    text-align: center;
		  }
		  p {
		    color: #6c757d;
		    font-size: 18px;
		    text-align: center;
		  }
		  .button-container {
		    text-align: center;
		    margin-top: 30px;
		  }
		  .button-container a {
		    display: inline-block;
		    width: 200px;
		    margin: 10px;
		    padding: 15px;
		    background-color: #007bff;
		    color: #ffffff;
		    font-size: 20px;
		    text-align: center;
		    text-decoration: none;
		    border-radius: 5px;
		    transition: background-color 0.3s ease;
		  }
		  .button-container a:hover {
		    background-color: #0056b3;
		  }
		</style>
	</head>
	<body>
		<div class="container">
		  <h1>Bienvenido a la Prueba de Ingesta de Productos</h1>
		  <p>Esta es la página principal de nuestro programa de ingesta de productos. Comencemos!</p>
		  <div class="button-container">
		    <a href="Controller?action=list">Mostrar productos</a>
		  </div>
		</div>
	</body>
</html>
