package controle.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controle.Conexao;

import modelo.Funcionario;
import modelo.Setor;

public class FuncionarioDAO implements IFuncionarioDAO {

	private static FuncionarioDAO instancia;

	public static FuncionarioDAO getInstancia() {

		if (instancia == null) {
			instancia = new FuncionarioDAO();
		}
		return instancia;

	}

	public Funcionario funcAchado = null;

	@Override
	public boolean inserirFuncionario(Funcionario fun) {
		String SQL = "INSERT INTO funcionarios (id_funcionario, primeiro_nome, sobrenome, nome_social, id_setor, cargo, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, fun.getId());
			ps.setString(2, fun.getNome());
			ps.setString(3, fun.getSobrenome());
			ps.setString(4, fun.getNomeSocial());
			ps.setInt(5, fun.getSetor().getId());
			ps.setString(6, fun.getCargo());
			ps.setString(7, fun.getUsuario());
			ps.setString(8, fun.getSenha());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			con.fecharConexao();
		}

		return true;
	}

	@Override
	public ArrayList<Funcionario> listarFuncionario() {

		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		String SQL = "SELECT * FROM funcionarios";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario fun = new Funcionario();

				int id = rs.getInt("id_funcionario");
				String primeiroNome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				int idSetor = rs.getInt("id_setor");
				Setor setor = null;
				
				for (Setor setorS : Setor.values()) {
					if(setorS.getId() == idSetor) {
						setor = setorS;
					}
				}			

				fun.setId(id);
				fun.setNome(primeiroNome);
				fun.setSobrenome(sobrenome);
				fun.setNomeSocial(nomeSocial);
				fun.setUsuario(usuario);
				fun.setSenha(senha);
				fun.setCargo(cargo);
				fun.setSetor(setor);

				funcionarios.add(fun);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return funcionarios;
	}

	@Override
	public boolean atualizarFuncionario(Funcionario fun) {

		String SQL = "UPDATE funcionarios SET primeiro_nome = ?, sobrenome = ?, nome_social = ?, id_setor = ?, cargo = ?, usuario = ?, senha = ?  WHERE id_funcionario = ?";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, fun.getNome());
			ps.setString(2, fun.getSobrenome());
			ps.setString(3, fun.getNomeSocial());
			ps.setInt(4, fun.getSetor().getId());
			ps.setString(5, fun.getCargo());
			ps.setString(6, fun.getUsuario());
			ps.setString(7, fun.getSenha());
			ps.setInt(8, fun.getId());

			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean removerFuncionarios(Funcionario fun) {
		String SQL = "DELETE FROM funcionarios WHERE id_funcionario = ?";

		Conexao con = Conexao.getInstancia(); // instanciando
		Connection conBD = con.conectar(); // cria "ponte"

		int retorno = 0;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, fun.getId());
			System.out.println(ps);
			

			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public ArrayList<Funcionario> listarFuncionarioPorSetor(Setor s) {

		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		String SQL = "SELECT * FROM funcionarios WHERE id_setor = ?";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, s.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario fun = new Funcionario();

				int id = rs.getInt("id_funcionario");
				String primeiroNome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				int idSetor = rs.getInt("id_setor");
				
				Setor setor = null;
				
				for (Setor setorS : Setor.values()) {
					if(setorS.getId() == idSetor) {
						setor = setorS;
					}
				}			

				fun.setId(id);
				fun.setNome(primeiroNome);
				fun.setSobrenome(sobrenome);
				fun.setNomeSocial(nomeSocial);
				fun.setUsuario(usuario);
				fun.setSenha(senha);
				fun.setCargo(cargo);
				fun.setSetor(setor);

				funcionarios.add(fun);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return funcionarios;
	}

	public Funcionario login(String usuario, String senha) {

		String SQL = "SELECT * FROM funcionarios WHERE usuario LIKE ? AND senha LIKE ?";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		Funcionario fun = null;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, usuario);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				fun = new Funcionario();

				int id = rs.getInt("id_funcionario");
				String primeiroNome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String cargo = rs.getString("cargo");
				int idSetor = rs.getInt("id_setor");				
				Setor setor = null;
				
				for (Setor setorS : Setor.values()) {
					if(setorS.getId() == idSetor) {
						setor = setorS;
					}
				}			

				fun.setId(id);
				fun.setNome(primeiroNome);
				fun.setSobrenome(sobrenome);
				fun.setNomeSocial(nomeSocial);
				fun.setUsuario(usuario);
				fun.setSenha(senha);
				fun.setCargo(cargo);
				fun.setSetor(setor);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return fun;

	}

	public Funcionario logoff() {
		return funcAchado = null;
	}

	public Funcionario passalogado() {
		return funcAchado;
	}

}
