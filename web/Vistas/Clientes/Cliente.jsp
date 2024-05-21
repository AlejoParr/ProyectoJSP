
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Cliente"%> <%-- page nos permite importar archivos dentro de la vista--%>
<!DOCTYPE html>
<%-- JSP nos permite usar código JAVA dentro de archivos html--%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/style.css" /> 
        <title>Clientes</title>
    </head>
    <body>
        <h1>Datos Clientes</h1>
        <% Cliente cliente = new Cliente(); %>
        <div className="container">
        <h3>Nombre: <%= cliente.getNombre()%> </h3>
        <h3>Apellido: <%= cliente.getApellido()%> </h3>
        <h3>Teléfono: <%= cliente.getTelefono()%> </h3>
        <h3>Dirección: <%= cliente.getDireccion()%> </h3>
        <h3>Correo: <%= cliente.getEmail()%> </h3>
        
        </div>
        
        <script src="../JS/Aplicacion.js"></script>
    </body>
</html>
