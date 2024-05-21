<%-- 
    Document   : header
    Created on : 18/05/2024, 3:51:07?p.?m.
    Author     : ALEJANDRO
--%>  
        <nav class="navbar navbar-expand-lg bg-warning">
              <a class="navbar-brand" style="margin-left: 10px" href="http://localhost:8080/ProyectoJSP">Sistema PQRS</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Usuarios
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="UsuariosControlador?action=listado">Listado</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="UsuariosControlador?action=insertar">Crear nuevo</a></li>                     
                    </ul>
                  </li>                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Funcionarios
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="FuncionariosControlador?action=listado">Listado</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="FuncionariosControlador?action=insertar">Crear nuevo</a></li> 
                    </ul>
                  </li>
                                    <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Requerimientos
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="TipoRequerimientoControlador?action=listado">Listado</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="TipoRequerimientoControlador?action=insertar">Crear nuevo</a></li> 
                    </ul>
                  </li>
                    <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      PQRS
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="pqrsControlador?action=listado">Ver registrados</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="pqrsControlador?action=insertar">Radicar nuevo</a></li> 
                    </ul>
                  </li>
                  
                </ul>
                <form class="d-flex" role="search">
                    <div style="padding-right: 30px">
                        <a class="btn btn-outline-success" href="UsuariosControlador?action=login" type="submit">Login</a>
                        <a style="" class="btn btn-outline-danger" href="UsuariosControlador?action=logout" type="submit">Logout</a>
                    </div>
                </form>
              </div>
            </div>
          </nav>
