
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Insertar usuario</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 
        <%@include file="../Menu/footer.jsp"%>
        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->
        <h1>Formulario nuevos usuarios</h1>
        <div class="container">
            <form action="UsuariosControlador" method="POST">
                <div class="row">
                    <div class="col-md-4">
                        <label>Nombre:</label>
                        <input type="text" name="nombre" id="nombre" placeholder="Nombre y apellido:" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Nombre se usuario:</label>
                        <input type="text" name="username" id="username" placeholder="Username aquí:" class="form-control" required>
                    </div>
                    <div class="col-md-4">
                        <label>Su contraseña:</label>
                        <input type="password" name="contrasena" id="contrasena" placeholder="Ingrese una contraseña:" class="form-control" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label>Correo electrónico:</label>
                        <input type="email" name="email" id="email" placeholder="Email del nuevo usuario:" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Número telefónico:</label>
                        <input type="number" name="telefono" id="telefono" placeholder="Número de contacto aquí:" class="form-control" required>
                    </div>
                    <div class="col-md-4">    
                        <label>Dirección:</label>
                        <input type="text" name="direccion" id="direccion" placeholder="Direccón aquí:" class="form-control" required>
                    </div>
                </div>
        </div>
            <br>
            <div class="centrarboton">
                <input type="submit" value="Guardar" name="action" class="btn btn-success" >
            </div>
            </form>
    </body>
</html>