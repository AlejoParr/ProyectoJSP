
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Ingresar al sistema</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp"%> 

        <!-- Este include trae el header y el footer desde la carpeta de las vistas -->        
        <h1>Ingreso al sistema</h1>
        <div class="container">
            <form action="UsuariosControlador" method="POST">
                <div class="row">
                    <div class="col-md-6">    
                        <label>Nombre se usuario:</label>
                        <input type="text" name="username" id="username" placeholder="Ingrese su nombre de usuario:" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label>Su contraseña:</label>
                        <input type="password" name="contrasena" id="contrasena" placeholder="Ingrese su contraseña:" class="form-control" required>
                    </div>
                </div>
                </div>
                <br><br>
                <div style ="margin-left: 48%">
                    <input type="hidden"  name="action" value="login">
                    <input type="submit" value="Entrar" class="btn btn-success" >
                </div>
            </form>
        </div>
        <%@include file="../Menu/footer.jsp"%>
    </body>
</html>