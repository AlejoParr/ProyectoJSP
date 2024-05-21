<%-- 
    Document   : actualizar
    Created on : 4/05/2024, 4:07:23 p. m.
    Author     : ALEJANDRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "Modelo.Usuario"%>
<%@page import= "ModeloDAO.UsuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Actualizar usuario</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <% 
            UsuarioDAO UsuaDAO = new UsuarioDAO();
            int id = Integer.parseInt((String)request.getAttribute("id"));
            Usuario usua =(Usuario) UsuaDAO.consultarUsuario(id);
        %>
        <h1>Formulario actualizar usuario</h1>
        <div class="container">
            <form action="UsuariosControlador" method="POST">
                <div class="row">   
                    <input type="hidden" name="id"  id="id" value="<%= usua.getId() %>">
                    <div class="col-md-4">
                        <label>Nombre:</label>
                        <input type="text" name="nombre" id="nombre" value="<%= usua.getNombre() %>" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Nombre se usuario:</label>
                        <input type="text" name="username" id="username" value="<%= usua.getUsername() %>" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label>Su contraseña:</label>
                        <input type="password" name="contrasena" id="contrasena" placeholder="Nueva contraseña:" class="form-control" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label>Correo electrónico:</label>
                        <input type="email" name="email" id="email" value="<%= usua.getEmail() %>" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Número telefónico:</label>
                        <input type="number" name="telefono" id="telefono" value="<%= usua.getTelefono() %>" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Dirección:</label>
                        <input type="text" name="direccion" id="direccion" value="<%= usua.getDireccion() %>" class="form-control" required>
                    </div>
                </div><br>
                <div class="centrarboton">
                    <input type="submit" value="actualizar" name="action" class="btn btn-primary" >
                </div>
            </form>
        </div>
    </body>
</html>
