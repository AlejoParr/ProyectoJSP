
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.PQRS;
import ModeloDAO.pqrsDAO;
import javax.servlet.RequestDispatcher;

public class pqrsControlador extends HttpServlet {
       
    PQRS pqrs = new PQRS();
    pqrsDAO pqrsDAO = new pqrsDAO();
    int id;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String access = "";
        String action = request.getParameter("action");
        
        switch (action){
            case "listado" -> access = "Vistas/PQRS/listar.jsp";
            case "insertar" -> access = "Vistas/PQRS/insertar.jsp";
            case "actualizar" -> {
                request.setAttribute("id", request.getParameter("id"));
                access = "Vistas/PQRS/actualizar.jsp"; 
            }
            case "borrar" -> {
                id = Integer.parseInt(request.getParameter("id"));
                pqrs.setId(id);
                pqrsDAO.borrarPQRS(id); /// 
                access = "Vistas/PQRS/listar.jsp";   
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
                String fecha = request.getParameter("fecha");
                String descripcion = request.getParameter("descripcion");
                String estado = "En proceso";
                int tiporequerimiento_id = Integer.parseInt(request.getParameter("tiporequerimiento_id"));
                
                //Se asigna el valor de las variables a través del método set 
                pqrs.setFecha(fecha);
                pqrs.setDescripcion(descripcion);
                pqrs.setEstado(estado);
                pqrs.setUsuario_id(id); //Viene directamente del login
                pqrs.setTipoRequerimiento_id(tiporequerimiento_id);
                pqrsDAO.insertarPQRS(pqrs);
                response.sendRedirect("pqrsControlador?action=listado");
            }   
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

} 