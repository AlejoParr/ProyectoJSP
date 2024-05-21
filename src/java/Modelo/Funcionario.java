
package Modelo;

public class Funcionario {
    private int Id;
    private String Nombre; 
    private String Email;
    private String Celular;
    
    public  Funcionario(){ } //Método contructor
    
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
    
    public String getEmail(){
        return this.Email;
    }
    public void setEmail(String email){
        this.Email = email;
    }
    
    public String getCelular(){
        return this.Celular;
    }
    public void setCelular(String celular){
        this.Celular = celular;
    }
}
