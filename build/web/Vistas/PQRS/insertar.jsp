<%-- 
    Document   : insertar PQRS
    Created on : 4/05/2024, 4:07:23 p. m.
    Author     : ALEJANDRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ModeloDAO.TipoRequerimientoDAO"%>
<%@page import="Modelo.TipoRequerimiento"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Nuevo PQRS</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <h1>Formulario de radicación nuevo PQRS</h1>
        <div class="container">
            <form action="pqrsControlador" method="POST">
                <div class="row">
                    <div class="col-md-4">
                        <label>Fecha:</label> 
                        <input type="date" name="fecha" id="fecha" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Tipo de requerimiento:</label>
                        <select name="requerimiento" id="requerimiento" class="form-control" required>
                            <% 
                                TipoRequerimientoDAO tpDAO = new TipoRequerimientoDAO();
                                List<TipoRequerimiento> listaTipoRequerimiento = tpDAO.listarTipoRequerimiento();
                                Iterator<TipoRequerimiento> iterarTipoRequerimiento = listaTipoRequerimiento.iterator();
                                TipoRequerimiento TP = null;

                                    while (iterarTipoRequerimiento.hasNext()){
                                        TP = iterarTipoRequerimiento.next();
                            %>
                            <option value="<%= TP.getId() %>" ><%= TP.getNombre() %></option>
                        <% } %>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label>Descripción:</label>
                        <textarea name="descripcion" id="descricpion" placeholder="Una breve descripción de la PQRS:" class="form-control" required></textarea>
                    </div>
                </div><br>
                <div class="centrarboton">
                    <input type="submit" value="Guardar" name="action" class="btn btn-success" >
                </div>
            </form>
        </div>
    </body>
</html>
