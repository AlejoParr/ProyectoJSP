<%-- 
    Document   : insertar
    Created on : 4/05/2024, 4:07:23 p. m.
    Author     : ALEJANDRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Insertar funcionario</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <h1>Formulario para nuevos funcionarios</h1>
        <div class="container">
            <form action="FuncionariosControlador" method="POST">
                <div class="row">
                    <div class="col-md-4">
                        <label>Nombre y apellido:</label>
                        <input type="text" name="nombre" id="nombre" placeholder="Nombre completo del funcionario:" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Correo eléctronico:</label>
                        <input type="email" name="email" id="email" placeholder="Email del nuevo funcionario:" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label>Número telefónico:</label>
                        <input type="number" name="celular" id="celular" placeholder="Teléfono del funcionario:" class="form-control" required>
                    </div>
                </div><br>
                <div class="centrarboton">
                    <input type="submit" value="Guardar" name="action" class="btn btn-success" >
                </div>
            </form>
        </div>
    </body>
</html>
