
package Controlador;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import javax.servlet.RequestDispatcher;

public class UsuariosControlador extends HttpServlet {

    Usuario usua = new Usuario();
    UsuarioDAO UsuaDAO = new UsuarioDAO();
    int id;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String access = "";
        String action = request.getParameter("action");
        
        switch (action){
            case "listado" -> access = "Vistas/Usuarios/listar.jsp";
            case "insertar" -> access = "Vistas/Usuarios/insertar.jsp";
            case "actualizar" -> {
                request.setAttribute("id", request.getParameter("id"));
                access = "Vistas/Usuarios/actualizar.jsp"; 
            }
            case "borrar" -> {
                id = Integer.parseInt(request.getParameter("id"));
                usua.setId(id);
                UsuaDAO.borrarUsuario(id);
                access = "Vistas/Usuarios/listar.jsp";   
            }
        }
        
     RequestDispatcher cargarVista = request.getRequestDispatcher(access);
        cargarVista.forward(request, response);
    }
    
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuariosControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuariosControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Nota: El método POST se ejecuta del lado del servidor y se usa con el 
        propósito de proteger información sensible. */
        String action = request.getParameter("action");
        
        switch (action){
            case "Guardar" -> {
                //Estos valores vienen desde los input de la vista insertar.
                String nombre = request.getParameter("nombre");
                String username = request.getParameter("username");
                String contrasena = request.getParameter("contrasena");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                String direccion = request.getParameter("direccion");
                //Se asigna el varios de las variables a través del método set 
                usua.setNombre(nombre);
                usua.setUsername(username);
                usua.setContrasena(contrasena);
                usua.setEmail(email);
                usua.setTelefono(telefono);
                usua.setDireccion(direccion);
                UsuaDAO.insertarUsuario(usua);
                response.sendRedirect("UsuariosControlador?action=listado");
            }   
            case "actualizar" ->{
                //Capturar valores desde la vista
                id = Integer.parseInt(request.getParameter("id")); 
                String nombre = request.getParameter("nombre");
                String username = request.getParameter("username");
                String contrasena = request.getParameter("contrasena");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                String direccion = request.getParameter("direccion");
                //Asignar a la tabla mediante el ID
                usua.setId(id);
                usua.setNombre(nombre);
                usua.setUsername(username);
                usua.setContrasena(contrasena);
                usua.setEmail(email);
                usua.setTelefono(telefono);
                usua.setDireccion(direccion);
                UsuaDAO.actualizarUsuario(usua); 
                response.sendRedirect("UsuariosControlador?action=listado&id="+id);   
            }
            case "login" ->{
                id = Integer.parseInt(request.getParameter("id"));
                String username = request.getParameter("username");
                String contrasena = request.getParameter("contrasena");
                usua.setUsername(username);
                usua.setContrasena(contrasena);
                UsuaDAO.consultarUsuarioLogin(username);
        }
    }

    //@Override
    //public String getServletInfo() {
        //return "Short description";
    }// </editor-fold>
}
