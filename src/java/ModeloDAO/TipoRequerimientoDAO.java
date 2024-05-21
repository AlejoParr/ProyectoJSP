
package ModeloDAO;

import Modelo.TipoRequerimiento;
import Interfaces.TipoRequerimientoCRUD;
import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class TipoRequerimientoDAO implements TipoRequerimientoCRUD {
    /*Para establecer la conexión a la base de datos, necesitamos un preparedStatement
    y un resultSet ademas de la clase conectora que creamos y se está instanciando.
    */
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    TipoRequerimiento TP = new TipoRequerimiento();  
    
    
    @Override
    public List listarTipoRequerimiento(){
        ArrayList<TipoRequerimiento> listaTipoRequerimiento = new ArrayList<>();
        String SQL = "SELECT tp.Id, tp.Nombre, tp.Descripcion, tp.funcionario_id, funcionarios.Nombre AS NombreFuncionario FROM tiporequerimiento AS tp INNER JOIN funcionarios ON tp.funcionario_id = funcionarios.Id";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
                    
        //Este while va a recorrer la tabla hasta que no haya un siguente. 
        while (rs.next()){
            TipoRequerimiento tp = new TipoRequerimiento();
            tp.setId(rs.getInt("Id"));
            tp.setNombre(rs.getString("Nombre"));
            tp.setDescripcion(rs.getString("Descripcion"));
            tp.setFuncionario_Id(rs.getInt("funcionario_id")); 
            tp.setNombreFuncionario(rs.getString("NombreFuncionario"));
            listaTipoRequerimiento.add(tp);
        } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT TipoRequerimiento ------> "+EX);
        } 
    return listaTipoRequerimiento;
    }
    
    @Override
    public boolean insertarTipoRequerimiento (TipoRequerimiento tp){
        String SQL = "INSERT INTO tiporequerimiento (Nombre, Descripcion, funcionario_id) VALUES('"+tp.getNombre()+"', '"+tp.getDescripcion()+"', '"+tp.getFuncionario_Id()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
            
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL INSERT TipoRequerimiento ------> "+EX);
        }
        return false; 
    }
    
    @Override
    public TipoRequerimiento consultarTipoRequerimiento(int id){
        String SQL = "SELECT * FROM tiporequerimiento WHERE Id=" + id; 
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();  
        //La información llega como un objeto, así que aunque llegue un solo objeto, hay que recorrerlo. 
            while (rs.next()){    
                TP.setId(rs.getInt("Id"));
                TP.setNombre(rs.getString("Nombre"));
                TP.setDescripcion(rs.getString("Descripcion"));
                TP.setFuncionario_Id(Integer.parseInt(rs.getString("funcionario_id")));
            } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT TipoRequerimiento ------> "+EX);            
        }
        return TP;
    }
    
    @Override
    public boolean actualizarTipoRequerimiento (TipoRequerimiento tp){
        String SQL = "UPDATE tiporequerimiento SET Nombre ='"+tp.getNombre()+"', Descripcion= '"+tp.getDescripcion()+"', funcionario_id= '"+tp.getFuncionario_Id()+"' WHERE id="+tp.getId();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate(); 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL UPDATE TipoRequerimiento ------> "+EX);            
        }
        return false;
    }
        
    @Override
    public boolean borrarTipoRequerimiento (int id){
        String SQL = "DELETE FROM tiporequerimiento WHERE Id=" + id;
          try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
          } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL DELETE TipoRequerimiento ------> "+EX);            
        }
        return false;
    }
}
