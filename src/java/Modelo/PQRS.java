
package Modelo;


public class PQRS {
    
    private int Id;
    private String Fecha; 
    private String Descripcion;
    private String Estado;
    private int usuario_id;
    private int tiporequerimiento_id;
    
    public PQRS (){}
    
    public int getId(){
        return this.Id;
    }
    public void setId(int id){
        this.Id = id;
    }
    
    public String getFecha(){
        return this.Fecha;
    }
    public void setFecha(String fecha){
        this.Fecha = fecha;
    }
    
    public String getDescripcion (){
        return this.Descripcion;
    }
    public void setDescripcion(String descripcion){
        this.Descripcion = descripcion;
    }
    
    public String getEstado(){
        return this.Estado;
    }
    public void setEstado(String estado){
        this.Estado = estado;
    }
    
    public int getUsuario_id(){
        return usuario_id;
    }
    public void setUsuario_id(int id_usuario){
        this.usuario_id = id_usuario;
    }
    
    public int getTipoRequerimiento_id(){
        return this.tiporequerimiento_id;
    }
    public void setTipoRequerimiento_id(int id_tiporequerimiento){
        this.tiporequerimiento_id = id_tiporequerimiento;
    }
}
