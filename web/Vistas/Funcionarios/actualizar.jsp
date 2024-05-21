<%-- 
    Document   : actualizar Funcionario
    Created on : 4/05/2024, 4:07:23 p. m.
    Author     : ALEJANDRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "Modelo.Funcionario"%>
<%@page import= "ModeloDAO.FuncionarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Actualizar funcionario</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <% 
            FuncionarioDAO FuncDAO = new FuncionarioDAO();
            int id = Integer.parseInt((String)request.getAttribute("id"));
            Funcionario Func =(Funcionario)FuncDAO.consultarFuncionario(id);
        %>
        <h1>Formulario actualizar funcionario</h1>
        <div class="container">
            <form action="FuncionariosControlador" method="POST">
                <div class="row">
                    <input type="hidden" name="id"  id="id" value="<%= Func.getId() %>">
                    <div class="col-md-4">
                        <label>Nombre:</label>
                        <input type="text" name="nombre" id="nombre" value="<%= Func.getNombre()%>" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Email:</label>
                        <input type="email" name="email" id="email" value="<%= Func.getEmail() %>" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label>Teléfono:</label>
                        <input type="number" name="celular" id="celular" value="<%= Func.getCelular() %>" class="form-control" required>
                    </div>
                </div>
                </div><br>
                <div class="centrarboton">
                    <input type="submit" value="actualizar" name="action" class="btn btn-primary" >
                </div>
            </form>
        </div>
    </body>
</html>
