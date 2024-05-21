
package Interfaces;

import Modelo.Funcionario;
import java.util.List;

public interface FuncionarioCRUD {
    
    public List listarFuncionario();
    public boolean insertarFuncionario(Funcionario func);
    public Funcionario consultarFuncionario(int id);
    public boolean actualizarFuncionario (Funcionario func);
    public boolean borrarFuncionario (int id);
}
