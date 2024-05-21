/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Usuario {
    private int Id;
    private String Username;
    private String Nombre;
    private String Contrasena;
    private String Email; 
    private String Telefono; 
    private String Direccion; 
    
    public Usuario() {} // Constructor vacío
    
    public int getId(){
    return this.Id;
    }
    public void setId(int id){
        this.Id = id;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    
        public String getUsername(){
        return this.Username;
    }
    public void setUsername(String username){
        this.Username = username;
    }
    
        public String getContrasena(){
        return this.Contrasena;
    }
    public void setContrasena(String contrasena){
        this.Contrasena = contrasena;
    }
    
        public String getEmail(){
        return this.Email;
    }
    public void setEmail(String email){
        this.Email = email;
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
}
