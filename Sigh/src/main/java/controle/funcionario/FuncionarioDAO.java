package controle.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controle.Conexao;

import modelo.Funcionario;
import modelo.Setor;

public  class FuncionarioDAO implements IFuncionarioDAO{
	
	    private static FuncionarioDAO instancia;
	    
	    public static FuncionarioDAO getInstancia() {
	    	
	    	if(instancia == null) {
	    		instancia = new FuncionarioDAO();
	    	}
	    	return instancia;
	    
		}
	    
	    public Funcionario funcAchado = null;

	@Override
	public boolean inserirFuncionario(Funcionario fun) {
		String SQL = "INSERT INTO funcionarios (id_funcionario, primeiro_nome, sobrenome, nome_social, usuario, senha, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, fun.getId());
			ps.setString(2, fun.getNome());
			ps.setString(3, fun.getSobrenome());
			ps.setString(4, fun.getNomeSocial());
			ps.setString(5, fun.getUsuario());
			ps.setString(6, fun.getSenha());
			ps.setString(7, fun.getCargo());
			
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
			
			while(rs.next()) {
				Funcionario fun = new Funcionario();
				
				int id = rs.getInt("id_funcionario");
				String primeiroNome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				
				fun.setId(id);
				fun.setNome(primeiroNome);
				fun.setSobrenome(sobrenome);
				fun.setNomeSocial(nomeSocial);
				fun.setUsuario(usuario);
				fun.setSenha(senha);
				fun.setCargo(cargo);
				
				funcionarios.add(fun);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		
		return funcionarios;
	}

	@Override
	public boolean atualizarFuncionario(Funcionario fun) {
		
		String SQL = "UPDATE funcionarios SET primeiro_nome = ?, sobrenome = ?, nome_social = ?, usuario = ?, senha = ?, cargo = ? WHERE id_funcionario = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, fun.getNome());
			ps.setString(2, fun.getSobrenome());
			ps.setString(3, fun.getNomeSocial());
			ps.setString(4, fun.getUsuario());
			ps.setString(5, fun.getSenha());
			ps.setString(6, fun.getCargo());
			ps.setInt(7, fun.getId());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0? false : true);
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
					
					retorno = ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					con.fecharConexao();
				}
				
		return (retorno == 0? false : true);
	}

	@Override
	public ArrayList<Funcionario> listarFuncionarioPorSetor(Setor s) {
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		String SQL = "SELECT * FROM funcionarios WHERE id_departamento = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, s.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario fun = new Funcionario();
				
				int id = rs.getInt("id_funcionario");
				String primeiroNome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				
				fun.setId(id);
				fun.setNome(primeiroNome);
				fun.setSobrenome(sobrenome);
				fun.setNomeSocial(nomeSocial);
				fun.setUsuario(usuario);
				fun.setSenha(senha);
				fun.setCargo(cargo);
				
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
	
	
	public Funcionario login(Funcionario fun) {
		for(Funcionario func : listarFuncionario()) {
			if(func.getUsuario().equals(fun.getUsuario()) && func.getSenha().equals(fun.getSenha())) {
				
				funcAchado = func;
				
				return funcAchado;
			}
		}
		return funcAchado;
	}
	
	public Funcionario logoff() {
		return funcAchado = null;
	}
	
	public Funcionario passalogado() {
		return funcAchado;
	}

	
	
}
