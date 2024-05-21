
package Interfaces;

import Modelo.Usuario;
import java.util.List;


public interface UsuarioCRUD {
    public List listarUsuario();
    public boolean insertarUsuario (Usuario usu);
    public Usuario consultarUsuario(int id);
    public boolean actualizarUsuario (Usuario usu);
    public boolean borrarUsuario (int id);
    public Usuario consultarUsuarioLogin(String username);
}
