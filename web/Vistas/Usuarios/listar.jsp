<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.List"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "Modelo.Usuario"%>
<%@page import = "ModeloDAO.UsuarioDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Listado de usuarios</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <div class="container">
        <h1>Listado de usuarios</h1>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                    <th>Dirección</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    UsuarioDAO UsuDAO = new UsuarioDAO();
                    List<Usuario> listaUsuario = UsuDAO.listarUsuario();
                    Iterator<Usuario> iterarUsuario = listaUsuario.iterator();
                    Usuario usu = null;
                    
                    while (iterarUsuario.hasNext()){
                        usu = iterarUsuario.next();
                %>
                <tr>
                    <td><%= usu.getId() %></td>
                    <td><%= usu.getNombre()%></td>
                    <td><%= usu.getUsername() %></td>
                    <td><%= usu.getEmail() %></td>
                    <td><%= usu.getTelefono() %></td>
                    <td><%= usu.getDireccion() %></td>
                    <td>
                        <a href="UsuariosControlador?action=actualizar&id=<%= usu.getId() %>" class = "btn btn-primary">Actualizar</a>
                        <!-- A través del id, vamos a direccionar el botón actualizar a la información del elemento seleccionado -->
                        <button class = "btn btn-danger" onclick="borrar(<%= usu.getId() %>)">Borrar</button>
                    </td>    
                </tr>
                <% } %> <!-- Si la llave del while no se cierra aquí, no se va a recorrer la totalidad de la tabla en la base de datos. -->
            </tbody>
        </table>
        </div>
            <script>
                function borrar (id){
                    var verificar = confirm("La información será borrada permanentemente. ¿Está seguro de borrar el funcionario con el id "+id+"?");
                    if (verificar){
                        location.href = "UsuariosControlador?action=borrar&id="+id;
                    }
                    else{
                        alert("No se pudo borrar el registro en la base de datos.");
                    }
                }
            </script>
    </body>
</html>

