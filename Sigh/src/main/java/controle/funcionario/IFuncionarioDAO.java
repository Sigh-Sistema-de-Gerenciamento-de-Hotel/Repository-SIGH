package controle.funcionario;

import java.util.ArrayList;

import modelo.Funcionario;
import modelo.Setor;

public interface IFuncionarioDAO {

	public boolean inserirFuncionario(Funcionario fun);

	public ArrayList<Funcionario> listarFuncionario();

	public boolean atualizarFuncionario(Funcionario fun);

	public boolean removerFuncionarios(Funcionario fun);

	public ArrayList<Funcionario> listarFuncionarioPorSetor(Setor s);

	public Funcionario login(String usuario, String senha);

	public Funcionario logoff();

	public Funcionario passalogado();

}
