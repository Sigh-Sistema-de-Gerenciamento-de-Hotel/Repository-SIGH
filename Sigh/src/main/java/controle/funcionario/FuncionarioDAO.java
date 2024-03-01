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
	public int inserirFuncionario(Funcionario fun) {
		String SQL = "INSERT INTO funcionaios (id_funcionario, nome, usuario, nome_social, email, id_cargo, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return 0;
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
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				String cargo = rs.getString("cargo");
				
				fun.setId(id);
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
		// TODO Auto-generated method stub
		return false;
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
