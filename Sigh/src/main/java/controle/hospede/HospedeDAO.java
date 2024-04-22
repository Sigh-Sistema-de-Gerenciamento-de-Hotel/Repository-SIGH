package controle.hospede;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Endereco;
import modelo.Hospede;

public class HospedeDAO implements IHospedeDAO{ //HospedeDAO  implementa a interface IHospedeDAO.//
	
	private static HospedeDAO instancia; 
	
	private HospedeDAO() { //evitar a criação de instâncias fora da classe.//
	}
		
	
	public static HospedeDAO getInstancia () { //retorna a instância única da classe HospedeDAO. Implementa o padrão Singleton.//
		if (instancia == null) {
			instancia = new HospedeDAO();
			}
		return instancia; 
	}

	@Override
	public int inserirHospede(Hospede hos) {
		// TODO Auto-generated method stub
		
		String SQL = "INSERT INTO Hospede (id_hospede, genero, data_nascimento, nacionalidade, cpf, passaporte, telefone, id_endereco, id_responsável) VALUES (?,?,?,?,?,?,?,?,?)"; 
		
		Conexao con = Conexao.getInstancia(); // conexão com o banco de dados.//
		
		Connection ConBD = con.conectar(); 
		
		int chaveGerada = 0;
		
		try {
			
			PreparedStatement ps = ConBD.prepareStatement(SQL);
			
			ps.setInt(1, hos.getId());
			ps.setString(2, hos.getGenero()); 
			ps.setString(3, String.valueOf(hos.getDataNascimento())); 
			ps.setString(4, hos.getNacionalidade()); 
			ps.setInt(5, hos.getCpf()); 
			ps.setString(6, hos.getPassaporte()); 
			ps.setInt(7, hos.getTelefone()); 
			Endereco end = hos.getEndereco();
			ps.setInt(8, end.getId()); 
			Hospede resp = hos.getResponsavel();
			ps.setInt(9, resp.getId()); 
			
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
	public ArrayList<Hospede> listarHospede() {
		// TODO Auto-generated method stub
		
		ArrayList <Hospede> Hospede = new ArrayList<Hospede>(); 
		
		
		String SQL = "SELECT * FROM hospedes INNER JOIN enderecos ON hospedes.id_endereco = enderecos.id_endereco";
		
		
		Conexao con = Conexao.getInstancia(); 
		
		Connection ConBD = con.conectar(); 
		
		try {
			PreparedStatement ps = ConBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Hospede hos = new Hospede(); 
				
				Integer id_hospede = rs.getInt("id_hospede"); 
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String genero = rs.getString("genero");
				Date dataNascimento = rs.getDate("dataNascimento");
				String nacionalidade = rs.getString("nacionalidade"); 
				Integer cpf = rs.getInt("cpf"); 
				String passaporte = rs.getString("passaporte"); 
				Integer telefone = rs.getInt("telefone"); 
				
				// Endereco
				
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
				
				// Responsavel
				Hospede respon  = new Hospede();
				
				Integer id_hospedeR = rs.getInt("id_hospede"); 
				String nomeR = rs.getString("nome");
				String sobrenomeR = rs.getString("sobrenome");
				String nomeSocialR = rs.getString("nome_social");
				String generoR = rs.getString("genero");
				Date dataNascimentoR = rs.getDate("dataNascimento");
				String nacionalidadeR = rs.getString("nacionalidade"); 
				Integer cpfR = rs.getInt("cpf"); 
				String passaporteR = rs.getString("passaporte"); 
				Integer telefoneR = rs.getInt("telefone"); 
				
				respon.setId(id_hospedeR);			
				respon.setGenero(genero);
				respon.setDataNascimento(LocalDate.parse(String.valueOf(dataNascimentoR)));
				respon.setNacionalidade(nacionalidadeR);
				respon.setCpf(cpfR);
				respon.setPassaporte(passaporteR);
				respon.setTelefone(telefoneR);
				
				/*
				 * for (Hospede h : Hospede) { if(h.getId() == id_responsavel) { respon = h;
				 * break; } }
				 */
				
				hos.setId(id_hospede);			
				hos.setGenero(genero);
				hos.setDataNascimento(LocalDate.parse(String.valueOf(dataNascimento)));
				hos.setNacionalidade(nacionalidade);
				hos.setCpf(cpf);
				hos.setPassaporte(passaporte);
				hos.setTelefone(telefone);
				hos.setEndereco(end);
				hos.setResponsavel(respon);
				
				Hospede.add(hos);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			con.fecharConexao();
			
		}
		
		
		return null;
	}

	@Override
	public boolean atualizarHospede(Hospede hos) {
	

		String SQL = "UPDATE Hospede SET genero = ?, cpf = ?, DataNascimento = ?,  Nacionalidade = ?, Passaporte = ?, "
				+ " Telefone = ?,  Endereco = ?,  Responsavel = ? WHERE id  = ? ";
		
		Conexao con = Conexao.getInstancia(); 
		Connection conBD = con.conectar(); 
		
		int retorno = 0; 
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, hos.getGenero());
			ps.setInt(2, hos.getCpf()); 
			/*ps.setInt(3, hos.getDataNascimento()); */
			ps.setString(4, hos.getNacionalidade());
			ps.setString(5, hos.getPassaporte());
			ps.setInt(6, hos.getTelefone());
			/*ps.setString(7, hos.getEndereco());
			ps.setString(8, hos.getResponsavel());*/
			
			
			
			retorno = ps.executeUpdate(); 
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			
		}
		
		
		return (retorno == 0? false: true);
	}

	@Override
	public boolean removerHospede(Hospede hos) {
		String SQL = "DELETE FROM Hospede WHERE id_Hospede = ?";
		
		Conexao con = Conexao.getInstancia(); // instanciando
		Connection conBD = con.conectar(); // cria "ponte"
		
		int retorno = 0;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, hos.getId());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
return (retorno == 0? false : true);}
}

			

	


