
package Modelo;

public class TipoRequerimiento {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private int funcionario_id;
    private String NombreFuncionario;
    
    public TipoRequerimiento(){} //Constructor vacío 
    
    public int getId (){
        return this.Id;
    }
    public void setId (int id){
        this.Id = id;
    }
    
    public String getNombre (){
        return this.Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    
    public String getDescripcion (){
        return this.Descripcion;
    }
    public void setDescripcion(String description){
        this.Descripcion = description;
    }
    
    public int getFuncionario_Id (){
        return this.funcionario_id;
    }
    public void setFuncionario_Id (int id_funcionario){
        this.funcionario_id = id_funcionario;
    }
    
        public String getNombreFuncionario (){
        return this.NombreFuncionario;
    }
    public void setNombreFuncionario(String nombrenuncionario){
        this.NombreFuncionario = nombrenuncionario;
    }
}
