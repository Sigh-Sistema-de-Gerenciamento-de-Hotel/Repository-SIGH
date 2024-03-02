package controle.hospedagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Hospedagem;

public class HospedagemDAO implements IHospedagemDAO{

	private static HospedagemDAO instancia;

	private HospedagemDAO() {

	}

	public static HospedagemDAO getInstancia() {

		if(instancia==null) {
			instancia=new HospedagemDAO();
		}
		return instancia;
	}

	@Override
	public int inserirHospedagem(Hospedagem hosp) {
		String SQL = "insert into hospedagens (id_hospedagem, data_saida, data_entrada) values (?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, hosp.getId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return 0;
	}

	@Override
	public ArrayList<Hospedagem> listarHospedagem() {
		// ArrayList para armazenar resultado select
		ArrayList<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

		// Comando SQL a ser executado
		String SQL = "SELECT * FROM hospedagens";

		// Cria a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Hospedagem hos = new Hospedagem();
				
				int id = rs.getInt("id_hospedagem");
				String dataHorarioSaida = rs.getString("data_saida");
				String dataHorarioEntrada = rs.getString("data_entrada");
				
				hos.setId(id);
				hos.setDataHorarioEntrada(LocalDateTime.parse(dataHorarioEntrada));
				hos.setDataHorarioSaida(LocalDateTime.parse(dataHorarioSaida));
				
				hospedagens.add(hos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return hospedagens;
	}

	@Override
	public boolean atualizarHospedagem(Hospedagem hosp) {
		String SQL = "UPDATE hospedagens SET data_saida = ?, data_entrada = ? WHERE id_hospedagem = ?";
		return false;
	}

	@Override
	public boolean removerHospedagem(Hospedagem hosp) {
		String SQL = "DELETE FROM hospedagens WHERE id_hospedagem = ?";
		return false;
	}

}
