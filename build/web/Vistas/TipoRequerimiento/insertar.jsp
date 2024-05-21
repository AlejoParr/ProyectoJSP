<%-- 
    Document   : insertar TipoRequerimiento
    Created on : 4/05/2024, 4:07:23 p. m.
    Author     : ALEJANDRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ModeloDAO.FuncionarioDAO"%>
<%@page import="Modelo.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Insertar requerimiento</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <h1>Formulario para nuevos requerimientos</h1>
        <div class="container">
            <form action="TipoRequerimientoControlador" method="POST">
                <div class="row">
                    <div class="col-md-4">
                        <label>Nombre:</label>
                        <input type="text" name="nombre" id="nombre" placeholder="Tipo de requerimiento:" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Descripción:</label>
                        <input type="text" name="descripcion" id="descripcion" placeholder="Breve descripción:" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label>Funcionario:</label>
                        <select name="funcionario_id" id="funcionario_id" class="form-control">
                    <% 
                        FuncionarioDAO FuncDAO = new FuncionarioDAO();
                        List<Funcionario> listaFuncionario = FuncDAO.listarFuncionario();
                        Iterator<Funcionario> iterarFuncionario = listaFuncionario.iterator();
                        Funcionario Func = null;

                        while (iterarFuncionario.hasNext()){
                            Func = iterarFuncionario.next();
                    %>
                <option value="<%= Func.getId() %>"><%= Func.getNombre() %></option>
                        <% } %>
                        </select>
                    </div>
                </div><br>
                <div class="centrarboton">
                    <input type="submit" value="Guardar" name="action" class="btn btn-success" >
                </div>
            </form>
        </div>
    </body>
</html>

