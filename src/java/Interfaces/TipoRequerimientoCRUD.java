
package Interfaces;

import Modelo.TipoRequerimiento;
import java.util.List;


public interface TipoRequerimientoCRUD {
    
    public boolean actualizarTipoRequerimiento (TipoRequerimiento tp);
    public boolean borrarTipoRequerimiento (int id);
    public TipoRequerimiento consultarTipoRequerimiento(int id);
    public boolean insertarTipoRequerimiento (TipoRequerimiento tp);
    public List listarTipoRequerimiento();
}
