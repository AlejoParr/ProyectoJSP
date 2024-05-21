
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.pqrsCRUD;
import Modelo.PQRS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class pqrsDAO implements pqrsCRUD {
    /*Para establecer la conexión a la base de datos, necesitamos un preparedStatement
    y un resultSet ademas de la clase conectora que creamos y se está instanciando.
    */
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    PQRS pqrs = new PQRS();  
    
    
    @Override
    public List listarPQRS(){
        ArrayList<PQRS> listaPQRS = new ArrayList<>();
        String SQL = "SELECT tp.Id, tp.Nombre, tp.Descripcion, tp.funcionario_id, funcionarios.Nombre AS NombreFuncionario FROM tiporequerimiento AS tp INNER JOIN funcionarios ON tp.funcionario_id = funcionarios.Id";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
                    
        //Este while va a recorrer la tabla hasta que no haya un siguente. 
        while (rs.next()){
            PQRS pq = new PQRS();
            pq.setId(rs.getInt("Id"));
            pq.setFecha(rs.getString("Fecha"));
            pq.setDescripcion(rs.getString("Descripcion"));
            listaPQRS.add(pq);
        } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT PQRS ------> "+EX);
        } 
    return listaPQRS;
    }
    
    @Override
    public boolean insertarPQRS (PQRS p){
        String SQL = "INSERT INTO pqrs (Fecha, Descripcion, Estado, funcionario_id, tiporequerimiento_id) VALUES('"+p.getFecha()+"', '"+p.getDescripcion()+"', '"+p.getEstado()+"', '"+p.getUsuario_id()+"', '"+p.getTipoRequerimiento_id()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
            
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL INSERT PQRS ------> "+EX);
        }
        return false; 
    }
    
    @Override
    public PQRS consultarPQRS(int id){
        String SQL = "SELECT * FROM pqrs WHERE Id=" + id; 
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();  
        //La información llega como un objeto, así que aunque llegue un solo objeto, hay que recorrerlo. 
            while (rs.next()){    
                pqrs.setId(rs.getInt("Id"));
                pqrs.setFecha(rs.getString("Fecha"));
                pqrs.setDescripcion(rs.getString("Descripcion"));
                pqrs.setUsuario_id(Integer.parseInt(rs.getString("usuario_id")));
                pqrs.setTipoRequerimiento_id(Integer.parseInt(rs.getString("tiporequerimiento_id")));
            } 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL SELECT PQRS ------> "+EX);            
        }
        return pqrs;
    }
    
    @Override
    public boolean actualizarPQRS (PQRS p){
        String SQL = "UPDATE pqrs SET Fecha ='"+p.getFecha()+"', Estado = '"+p.getEstado()+"',  Descripcion= '"+p.getDescripcion()+"', usuario_id '"+p.getUsuario_id()+"', tiporequerimiento_id= '"+p.getTipoRequerimiento_id()+"' WHERE id="+p.getId();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate(); 
        } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL UPDATE PQRS ------> "+EX);            
        }
        return false;
    }
        
    @Override
    public boolean borrarPQRS (int id){
        String SQL = "DELETE FROM pqrs WHERE Id=" + id;
          try{
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.executeUpdate();
          } catch (SQLException EX) {
            System.err.println("Error en la consulta SQL DELETE PQRS ------> "+EX);            
        }
        return false;
    }
}
