
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.TipoRequerimiento;
import ModeloDAO.TipoRequerimientoDAO;
import javax.servlet.RequestDispatcher;

public class TipoRequerimientoControlador extends HttpServlet {
       
    TipoRequerimiento TP = new TipoRequerimiento();
    TipoRequerimientoDAO TPDAO = new TipoRequerimientoDAO();
    int id;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String access = "";
        String action = request.getParameter("action");
        
        switch (action){
            case "listado" -> access = "Vistas/TipoRequerimiento/listar.jsp";
            case "insertar" -> access = "Vistas/TipoRequerimiento/insertar.jsp";
            case "actualizar" -> {
                request.setAttribute("id", request.getParameter("id"));
                access = "Vistas/TipoRequerimiento/actualizar.jsp"; 
            }
            case "borrar" -> {
                id = Integer.parseInt(request.getParameter("id"));
                TP.setId(id);
                TPDAO.borrarTipoRequerimiento(id);
                access = "Vistas/TipoRequerimiento/listar.jsp";   
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
                String descripcion = request.getParameter("descripcion");
                int funcionario_id = Integer.parseInt(request.getParameter("funcionario_id")); 
                
                //Se asigna el valor de las variables a través del método set 
                TP.setNombre(nombre);
                TP.setDescripcion(descripcion);
                TP.setFuncionario_Id(funcionario_id);
                TPDAO.insertarTipoRequerimiento(TP);
                response.sendRedirect("TipoRequerimientoControlador?action=listado");
            }   
            case "actualizar" ->{
                id = Integer.parseInt(request.getParameter("id")); 
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                int funcionario_id = Integer.parseInt(request.getParameter("funcionario_id"));
                System.err.println("Nombre: " + nombre);
                System.err.println("Descripcion: " + descripcion);
                System.err.println("Funcionario: " + funcionario_id);
                System.err.println("ID: " + id);
                TP.setId(id);
                TP.setNombre(nombre);
                TP.setDescripcion(descripcion);
                TP.setFuncionario_Id(funcionario_id);
                TPDAO.actualizarTipoRequerimiento(TP);
                response.sendRedirect("TipoRequerimientoControlador?action=listado");   
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

} 