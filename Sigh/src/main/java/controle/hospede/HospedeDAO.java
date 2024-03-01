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
		
		String SQL = "INSERT INTO Hospede (id_hospede, primeiro_nome, sobrenome, nome_social, genero, data_nascimento, nacionalidade, cpf, passaporte, email, telefone, id_endereco, id_responsável) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		Conexao con = Conexao.getInstancia(); 
		
		Connection ConBD = con.conectar(); 
		try {
			PreparedStatement ps = ConBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery(); 
			
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
		
		String SQL = "SELECT * FROM Hospede"; 
		
		Conexao con = Conexao.getInstancia(); 
		
		Connection ConBD = con.conectar(); 
		
		try {
			PreparedStatement ps = ConBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				//* Erro mal resolvido (Gaby vai resolver) *// 
				//String SQL = "SELECT endereco, responsavel FROM Hospede INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID";
				
				
				
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
				// hos.setEndereco(endereco);
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
	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerHospede(Hospede hos) {
		// TODO Auto-generated method stub
		return false;
	}

}
