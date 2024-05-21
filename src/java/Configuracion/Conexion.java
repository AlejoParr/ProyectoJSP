/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.sql.*;

//Este método usa la el conector JDBC para establecer la conexión con la base de datos. 
//Se usa la versión 8.0.3 ya que la usada en el entrenamiento es muy antigua.  
public class Conexion {
    
    Connection con;
    

    //Método constructor que ejecuta la conexión una vez que se abre el programa. 
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdatabase", "root", "");
        } catch (ClassNotFoundException | SQLException EX) {
            System.err.println("Error en la conexion: "+EX);
        }
    }
    public Connection getConnection(){
        return con;
    }
    
}
