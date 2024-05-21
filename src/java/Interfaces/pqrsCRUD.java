
package Interfaces;

import Modelo.PQRS;
import java.util.List;

public interface pqrsCRUD {
    public List listarPQRS();
    public boolean insertarPQRS (PQRS p);
    public PQRS consultarPQRS(int id);
    public boolean actualizarPQRS (PQRS p);
    public boolean borrarPQRS (int id);
}
