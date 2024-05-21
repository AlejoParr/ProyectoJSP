
package ModeloDAO;

import Modelo.Usuario;
import Interfaces.UsuarioCRUD;
import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO implements UsuarioCRUD  {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario us = new Usuario();
    
    
    @Override
    public List listarUsuario(){
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        String SQL = "SELECT * FROM usuarios"; 
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
                    
        //Este while va a recorrer la tabla hasta que no haya un siguente. 
        while (rs.next()){
            Usuario us = new Usuario();
            us.setId(rs.getInt("Id"));
            us.setNombre(rs.getString("Nombre"));
            us.setUsername(rs.getString("Username"));
            us.setEmail(rs.getString("Email"));
            us.setTelefono(rs.getString("Telefono"));
            us.setDireccion(rs.getString("Direccion"));
            listaUsuario.add(us);
        } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT * USUARIO ------> "+EX);
        } 
    return listaUsuario;
    }
    
    @Override
    public boolean insertarUsuario (Usuario us){
        String SQL = "INSERT INTO usuarios (Nombre, Username, Contrasena, Email, Telefono, Direccion) VALUES('"+us.getNombre()+"', '"+us.getUsername()+"', '"+us.getContrasena()+"', '"+us.getEmail()+"', '"+us.getTelefono()+"', '"+us.getDireccion()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
            
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL INSERT USUARIO ------> "+EX);
        }
        return false; 
    }
    
    @Override
    public Usuario consultarUsuario(int id){
        String SQL = "SELECT * FROM usuarios WHERE Id=" + id; 
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
                    
        //La información llega como un objeto, así que aunque llegue un solo objeto, hay que recorrerlo. 
        while (rs.next()){
            us.setId(rs.getInt("Id"));
            us.setNombre(rs.getString("Nombre"));
            us.setUsername(rs.getString("Username"));
            us.setContrasena(rs.getString("Contrasena"));
            us.setEmail(rs.getString("Email"));
            us.setTelefono(rs.getString("Telefono"));
            us.setDireccion(rs.getString("Direccion"));
        } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT USUARIO ID ------> "+EX);            
        }
        return us;
    }
    
    @Override
    public boolean actualizarUsuario (Usuario us){
        String SQL = "UPDATE usuarios SET Nombre ='"+us.getNombre()+"',Username ='"+us.getUsername()+"', Contrasena ='"+us.getContrasena()+"', Email= '"+us.getEmail()+"', Telefono= '"+us.getTelefono()+"', Direccion= '"+us.getDireccion()+"' WHERE id="+ us.getId();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate(); 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL UPDATE USUARIO ------> "+EX);            
        }
        return false;
    }
        
    @Override
    public boolean borrarUsuario (int id){
        String SQL = "DELETE FROM usuarios WHERE Id=" + id;
          try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
          } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL DELETE USUARIO ------> "+EX);            
        }
        return false;
    }
        @Override
    public Usuario consultarUsuarioLogin(String username){
        String SQL = "SELECT * FROM usuarios WHERE Username=" + username; 
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
                    
        //La información llega como un objeto, así que aunque llegue un solo objeto, hay que recorrerlo. 
        while (rs.next()){
            us.setId(rs.getInt("Id"));
            us.setNombre(rs.getString("Nombre"));
            us.setUsername(rs.getString("Username"));
            us.setContrasena(rs.getString("Contrasena"));
            us.setEmail(rs.getString("Email"));
            us.setTelefono(rs.getString("Telefono"));
            us.setDireccion(rs.getString("Direccion"));
        } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT USUARIO ID ------> "+EX);            
        }
        return us;
    }

}
