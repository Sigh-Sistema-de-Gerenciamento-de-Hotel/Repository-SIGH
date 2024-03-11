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
	    
	    private FuncionarioDAO(){
	    
	    }
	    
	    public static FuncionarioDAO getInstancia() {
	    	
	    	if(instancia == null) {
	    		instancia = new FuncionarioDAO();
	    	}
	    	return instancia;
	    
		}

	@Override
	public boolean inserirFuncionario(Funcionario fun) {
		String SQL = "INSERT INTO funcionarios (id_funcionario, primeiroNome, sobrenome, nomeSocial, usuario, senha, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, fun.getId());
			ps.setString(2, fun.getPrimeiroNome());
			ps.setString(3, fun.getSobrenome());
			ps.setString(4, fun.getNomeSocial());
			ps.setString(4, fun.getUsuario());
			ps.setString(5, fun.getSenha());
			ps.setString(6, fun.getCargo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return false;
	}

	@Override
	public ArrayList<Funcionario> listarFuncionario() {
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		String SQL = "SELECT * FROM funcionarios INNER JOIN usuarios_senhas ON funcionarios.usuario = usuarios_senhas.usuario INNER JOIN cargos ON funcionarios.id_cargo = cargos.id_cargo";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario fun = new Funcionario();
				
				int id = rs.getInt("id_funcionario");
				String primeiroNome = rs.getString("primeiroNome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nomeSocial");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				
				fun.setId(id);
				fun.setPrimeiroNome(primeiroNome);
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
		
		String SQL = "UPDATE funcionarios SET primeiroNome = ?, sobrenome = ?, nomeSocial = ?, usuario = ?, senha = ?, cargo = ? WHERE id_funcionario = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, fun.getId());
			ps.setString(2, fun.getNomeSocial());
			ps.setString(3, fun.getSobrenome());
			ps.setString(4, fun.getNomeSocial());
			ps.setString(5, fun.getUsuario());
			ps.setString(6, fun.getSenha());
			ps.setString(7, fun.getCargo());
			
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Funcionario> listarFuncionarioPorSetor(Setor s) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
