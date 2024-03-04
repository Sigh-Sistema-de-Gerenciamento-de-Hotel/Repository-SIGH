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
		String SQL = "INSERT INTO enderecos (id_endereco, estado, cidade, endereco, complemento, numero) VALUES (?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, end.getId());
			ps.setString(2, end.getEstado());
			ps.setString(3, end.getCidade());
			ps.setString(4, end.getEndereco());
			ps.setString(5, end.getComplemento());
			ps.setInt(6, end.getNumero());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return 0;
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
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String endereco = rs.getString("endereco");
				String complemento = rs.getString("complemento");
				int numero = rs.getInt("numero");
				
				end.setId(id);
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
		String SQL = "UPDATE enderecos SET estado = ?, cidade = ?, endereco = ?, complemento = ?, numero = ?  WHERE id_endereco = ?";
		return false;
	}

	@Override
	public boolean removerEndereco(Endereco end) {
		String SQL = "DELETE FROM enderecos WHERE id_endereco = ?";
		return false;
	}

	@Override
	public Endereco buscarEnderecoPorCep(int cep) {
		String SQL = "SELECT * FROM enderecos WHERE id_endereco = ?";
		return null;
	}



}
