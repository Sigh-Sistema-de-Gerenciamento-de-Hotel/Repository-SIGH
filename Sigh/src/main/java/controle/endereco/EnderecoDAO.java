package controle.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Endereco;

public class EnderecoDAO implements IEnderecoDAO {

	private static EnderecoDAO instancia;

	private EnderecoDAO() {

	}

	public static EnderecoDAO getInstancia() {

		if(instancia==null) {
			instancia=new EnderecoDAO();
		}
		return instancia;
	}

	@Override
	public int inserirEndereco(Endereco end) {
		String SQL = "INSERT INTO enderecos (cep, estado, cidade, endereco, complemento, numero) VALUES (?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chaveGerada = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, end.getCep());
			ps.setString(2, end.getEstado());
			ps.setString(3, end.getCidade());
			ps.setString(4, end.getEndereco());
			ps.setString(5, end.getComplemento());
			ps.setInt(6, end.getNumero());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				chaveGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chaveGerada;
	}

	@Override
	public ArrayList<Endereco> listarEnderecos() {
		
		// ArrayList para armazenar resultado select
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		// Comando SQL a ser executado
		String SQL = "SELECT * FROM enderecos";
		
		// Cria a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Endereco end = new Endereco();
				
				int id = rs.getInt("id_endereco");
				int cep = rs.getInt("cep");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String endereco = rs.getString("endereco");
				String complemento = rs.getString("complemento");
				int numero = rs.getInt("numero");
				
				end.setId(id);
				end.setCep(cep);
				end.setEstado(estado);
				end.setCidade(cidade);
				end.setEndereco(endereco);
				end.setComplemento(complemento);
				end.setNumero(numero);
				
				enderecos.add(end);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return enderecos;
	}

	@Override
	public boolean atualizarEndereco(Endereco end) {
		
		String SQL = "UPDATE enderecos SET cep = ?, estado = ?, cidade = ?, endereco = ?, complemento = ?, numero = ?  WHERE id_endereco = ?";
		
		// Cria a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia(); // Instancia a conexao
		Connection conBD = con.conectar(); // Cria a ponte com o MySQL
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, end.getCep());
			ps.setString(2, end.getEstado());
			ps.setString(3, end.getCidade());
			ps.setString(4, end.getEndereco());
			ps.setString(5, end.getComplemento());
			ps.setInt(6, end.getNumero());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return (retorno == 0? false : true);
	}

	@Override
	public boolean removerEndereco(Endereco end) {
		String SQL = "DELETE FROM enderecos WHERE id_endereco = ?";
		
		Conexao con = Conexao.getInstancia(); // Instancia a conexao
		Connection conBD = con.conectar(); // Cria a ponte com o MySQL

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, end.getId());
			
			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0? false : true);
	}

	@Override
	public ArrayList<Endereco> buscarEnderecoPorCep(int cep) {
		
		// ArrayList para armazenar resultado select
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		String SQL = "SELECT * FROM enderecos WHERE cep = ?";
		
		// Cria a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Endereco end = new Endereco();
				
				int id = rs.getInt("id_endereco");
				int cepE = rs.getInt("cep");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String endereco = rs.getString("endereco");
				String complemento = rs.getString("complemento");
				int numero = rs.getInt("numero");
				
				end.setId(id);
				end.setCep(cepE);
				end.setEstado(estado);
				end.setCidade(cidade);
				end.setEndereco(endereco);
				end.setComplemento(complemento);
				end.setNumero(numero);
				
				enderecos.add(end);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return enderecos;
	}



}
