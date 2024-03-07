package controle.hospede;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Hospede;

public class HospedeDAO implements IHospedeDAO{
	
	private static HospedeDAO instancia; 
	
	private HospedeDAO() {
		
	}
	
	public static HospedeDAO getInstancia () { 
		if (instancia == null) {
			instancia = new HospedeDAO();
			}
		return instancia; 
	}

	@Override
	public int inserirHospede(Hospede hos) {
		// TODO Auto-generated method stub
		
		String SQL = "INSERT INTO Hospede (id_hospede, genero, data_nascimento, nacionalidade, cpf, passaporte, telefone, id_endereco, id_responsável) VALUES (?,?,?,?,?,?,?,?,?)"; 
		
		Conexao con = Conexao.getInstancia(); 
		
		Connection ConBD = con.conectar(); 
		try {
			
			PreparedStatement ps = ConBD.prepareStatement(SQL);
			
			ps.setInt(1, hos.getId());
			ps.setString(2, hos.getGenero()); 
			//*ps.setString(3, hos.getData_nascimento()); 
			ps.setString(4, hos.getNacionalidade()); 
			ps.setInt(5, hos.getCpf()); 
			ps.setString(6, hos.getPassaporte()); 
			ps.setInt(7, hos.getTelefone()); 
			//*	ps.setString(8, hos.getendereco()); 
			//*ps.setString(9, hos.getResponsavel()); 
			
			
			
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao(); 
		}
		
		return 0;
	}

	@Override
	public ArrayList<Hospede> listarHospede() {
		// TODO Auto-generated method stub
		
		ArrayList <Hospede> Hospede = new ArrayList<Hospede>(); 
		
		
		String SQL = "SELECT endereco, responsavel FROM Hospede INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID";
		
		
		Conexao con = Conexao.getInstancia(); 
		
		Connection ConBD = con.conectar(); 
		
		try {
			PreparedStatement ps = ConBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			
				
				Hospede hos = new Hospede(); 
				
				Integer id_hospede = rs.getInt("id"); 
				String genero = rs.getString("genero");
				String dataNascimento = rs.getString("dataNascimento");
				String nacionalidade = rs.getString("nacionalidade"); 
				Integer cpf = rs.getInt("cpf"); 
				String passaporte = rs.getString("passaporte"); 
				Integer telefone = rs.getInt("telefone"); 
				String id_endereco = rs.getString("endereco"); //* Erro mal resolvido (Gaby vai resolver) *// 
				Integer id_responsavel = rs.getInt("responsavel"); //* Erro mal resolvido (Gaby vai resolver) *// 
				
				Hospede respon  = new Hospede();
				respon = null;
				
				
				for (Hospede h : Hospede) {
					if(h.getId() == id_responsavel) {
						respon = h;
					}
				}
				
				
				hos.setId(id_hospede);			
				hos.setGenero(genero);
				hos.setDataNascimento(LocalDateTime.parse( dataNascimento));
				hos.setNacionalidade(nacionalidade);
				hos.setCpf(cpf);
				hos.setPassaporte(passaporte);
				hos.setTelefone(telefone);
				//*hos.setEndereco(endereco);
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
	

		String SQL = "UPDATE Hospede SET id  = ? WHERE genero = ?, WHERE cpf = ?, WHERE DataNascimento = ?, WHERE Nacionalidade = ?, WHERE Passaporte = ?, "
				+ "WHERE Telefone = ?, WHERE Endereco = ?, WHERE Responsavel = ?";
		
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
		// TODO Auto-generated method stub
		return false;
	}

}
