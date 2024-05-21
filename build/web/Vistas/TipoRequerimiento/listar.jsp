<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.List"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "Modelo.TipoRequerimiento"%>
<%@page import = "Modelo.PQRS"%>
<%@page import = "ModeloDAO.TipoRequerimientoDAO"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Listado de requerimientos</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <div class="container">
        <h1>Listado de requerimientos</h1>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tipo de requerimiento</th>
                    <th>Funcionario responsable</th>
                    <th>Descripción</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    TipoRequerimientoDAO TipoReqDAO = new TipoRequerimientoDAO();
                    List<TipoRequerimiento> listaTipoRequerimiento = TipoReqDAO.listarTipoRequerimiento(); 
                    Iterator<TipoRequerimiento> iterarTipoRequerimiento = listaTipoRequerimiento.iterator();
                    TipoRequerimiento TipoReq = null;
                    
                    while (iterarTipoRequerimiento.hasNext()){
                        TipoReq = iterarTipoRequerimiento.next();
                %>
                <tr>
                    <td><%= TipoReq.getId() %></td>
                    <td><%= TipoReq.getNombre()%></td>
                    <td><%= TipoReq.getNombreFuncionario() %></td>
                    <td><%= TipoReq.getDescripcion()%></td>
                    <td>
                        <a href="TipoRequerimientoControlador?action=actualizar&id=<%= TipoReq.getId() %>" class = "btn btn-primary">Actualizar</a>
                        <button class = "btn btn-danger" onclick="borrar(<%= TipoReq.getId() %>)">Borrar</button>
                    </td>    
                </tr>
                <% } %> <!-- Si la llave del while no se cierra aquí, no se va a recorrer la totalidad de la tabla en la base de datos. -->
            </tbody>
        </table>
        </div>
            <script>
                function borrar (id){
                    var verificar = confirm("La información será borrada permanentemente. ¿Está seguro de borrar el requerimiento con el id "+id+"?");
                    if (verificar){
                        location.href = "TipoRequerimientoControlador?action=borrar&id="+id;
                    }
                    else{
                        alert("No se pudo borrar el registro en la base de datos.");
                    }
                }
            </script>
    </body>
</html>
