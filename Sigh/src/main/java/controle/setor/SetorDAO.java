package controle.setor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Setor;

public class SetorDAO implements ISetorDAO {
	
	private static SetorDAO instancia;
	
	private SetorDAO() {

	}

	public static SetorDAO getInstacia() {

		if (instancia == null) {
			instancia = new SetorDAO();
		}
		return instancia;

	}

	public ArrayList<Setor> listarSetor() {
		
		ArrayList<Setor> setores = new ArrayList<Setor>();

		String SQL = "SELECT * FROM setores";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Setor setor = new Setor();

				int id = rs.getInt("id_setor");
				String nome = rs.getString("nome");

				setor.setId(id);
				setor.setNome(nome);
				
				setores.add(setor);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return setores;
	}

}
