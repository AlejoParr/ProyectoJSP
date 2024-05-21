
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Funcionario;
import ModeloDAO.FuncionarioDAO;
import javax.servlet.RequestDispatcher;

public class FuncionariosControlador extends HttpServlet {
    
    String listado = "Vistas/Funcionarios/listar.jsp";
    String insertar = "Vistas/Funcionarios/insertar.jsp";
    String actualizar = "Vistas/Funcionarios/actualizar.jsp";
       
    Funcionario Func = new Funcionario();
    FuncionarioDAO FuncDAO = new FuncionarioDAO();
    int id;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String access = "";
        String action = request.getParameter("action");
        
        switch (action){
            case "listado" -> access = listado;
            case "insertar" -> access = insertar;
            case "actualizar" -> {
                request.setAttribute("id", request.getParameter("id"));
                access = actualizar; 
            }
            case "borrar" -> {
                id = Integer.parseInt(request.getParameter("id"));
                Func.setId(id);
                FuncDAO.borrarFuncionario(id);
                access = listado;   
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
                String email = request.getParameter("email");
                String celular = request.getParameter("celular");
                //Se asigna el varios de las variables a través del método set 
                Func.setNombre(nombre);
                Func.setEmail(email);
                Func.setCelular(celular);
                FuncDAO.insertarFuncionario(Func);
                response.sendRedirect("FuncionariosControlador?action=listado");
            }   
            case "actualizar" ->{
                id = Integer.parseInt(request.getParameter("id")); 
                String nombre = request.getParameter("nombre");
                String email = request.getParameter("email");
                String celular = request.getParameter("celular");
                Func.setId(id);
                Func.setNombre(nombre);
                Func.setEmail(email);
                Func.setCelular(celular);
                FuncDAO.actualizarFuncionario(Func); 
                response.sendRedirect("FuncionariosControlador?action=listado&id="+id);   
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

} 
