<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.List"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "Modelo.Funcionario"%>
<%@page import = "ModeloDAO.FuncionarioDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Listado funcionarios</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <div class="container">
        <h1>Listado de funcionarios</h1>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Celular</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    FuncionarioDAO FuncDAO = new FuncionarioDAO();
                    List<Funcionario> listaFuncionario = FuncDAO.listarFuncionario();
                    Iterator<Funcionario> iterarFuncionario = listaFuncionario.iterator();
                    Funcionario Func = null;
                    
                    while (iterarFuncionario.hasNext()){
                        Func = iterarFuncionario.next();
                %>
                <tr>
                    <td><%= Func.getId() %></td>
                    <td><%= Func.getNombre() %></td>
                    <td><%= Func.getEmail() %></td>
                    <td><%= Func.getCelular() %></td>
                    <td>
                        <a href="FuncionariosControlador?action=actualizar&id=<%= Func.getId() %>" class = "btn btn-primary">Actualizar</a>
                        <!-- A través del id, vamos a direccionar el botón actualizar a la información del elemento seleccionado -->
                        <button class = "btn btn-danger" onclick="borrar(<%= Func.getId() %>)">Borrar</button>
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
                        location.href = "FuncionariosControlador?action=borrar&id="+id;
                    }
                    else{
                        alert("No se pudo borrar el registro en la base de datos.");
                    }
                }
            </script>
    </body>
</html>
