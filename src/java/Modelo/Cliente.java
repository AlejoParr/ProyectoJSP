/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente {
    private String Nombre;
    private String Apellido; 
    private String Telefono;
    private String Direccion;
    private String Email;
    
    public String getNombre(){
    return this.Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    
     public String getApellido(){
    return this.Apellido;
    }
    public void setApellido(String apellido){
        this.Apellido = apellido;
    }
    
     public String getTelefono(){
    return this.Telefono;
    }
    public void setTelefono(String telefono){
        this.Telefono = telefono;
    }
    
     public String getDireccion(){
    return this.Direccion;
    }
    public void setDireccion(String direccion){
        this.Direccion = direccion;
    }
    
    public String getEmail(){
        return this.Email;
    }
    public void setEmail(String email){
        this.Email = email;
    }
}
    

