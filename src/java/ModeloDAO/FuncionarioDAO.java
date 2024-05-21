
package ModeloDAO;

import Modelo.Funcionario;
import Interfaces.FuncionarioCRUD;
import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioDAO implements FuncionarioCRUD {
    /*Para establecer la conexión a la base de datos, necesitamos un preparedStatement
    y un resultSet ademas de la clase conectora que creamos y se está instanciando.
    */
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Funcionario func = new Funcionario();
    
    
    @Override
    public List listarFuncionario(){
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        String SQL = "SELECT * FROM funcionarios"; 
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
                    
        //Este while va a recorrer la tabla hasta que no haya un siguente. 
        while (rs.next()){
            Funcionario func = new Funcionario();
            func.setId(rs.getInt("Id"));
            func.setNombre(rs.getString("Nombre"));
            func.setEmail(rs.getString("Email"));
            func.setCelular(rs.getString("Celular"));
            listaFuncionario.add(func);
        } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT ------> "+EX);
        } 
    return listaFuncionario;
    }
    
    @Override
    public boolean insertarFuncionario (Funcionario func){
        String SQL = "INSERT INTO funcionarios (Nombre, Email, Celular) VALUES('"+func.getNombre()+"', '"+func.getEmail()+"', '"+func.getCelular()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
            
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL INSERT ------> "+EX);
        }
        return false; 
    }
    
    @Override
    public Funcionario consultarFuncionario(int id){
        String SQL = "SELECT * FROM funcionarios WHERE Id=" + id; 
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
                    
        //La información llega como un objeto, así que aunque llegue un solo objeto, hay que recorrerlo. 
        while (rs.next()){
            func.setId(rs.getInt("Id"));
            func.setNombre(rs.getString("Nombre"));
            func.setEmail(rs.getString("Email"));
            func.setCelular(rs.getString("Celular"));
        } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT ------> "+EX);            
        }
        return func;
    }
    
    @Override
    public boolean actualizarFuncionario (Funcionario func){
        String SQL = "UPDATE funcionarios SET Nombre ='"+func.getNombre()+"', Email= '"+func.getEmail()+"', Celular= '"+func.getCelular()+"' WHERE id="+ func.getId();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate(); 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL UPDATE ------> "+EX);            
        }
        return false;
    }
        
    @Override
    public boolean borrarFuncionario (int id){
        String SQL = "DELETE FROM funcionarios WHERE Id=" + id;
          try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
          } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL DELETE ------> "+EX);            
        }
        return false;
    }

}
