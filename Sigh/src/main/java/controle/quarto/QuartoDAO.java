package controle.quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Quarto;

public class QuartoDAO implements IQuartoDAO {

	private static QuartoDAO instancia;

	private QuartoDAO() {

	}

	public static QuartoDAO getInstacia() {

		if (instancia == null) {
			instancia = new QuartoDAO();
		}
		return instancia;

	}

	@Override
	public int inserirQuarto(Quarto qua) { 
		String SQL = "INSERT INTO quartos (id_quarto, conserto, limpeza, acessibilidade, banheira, frigobar, ar_condicionado, preco, nummax_hospedes, num_cama_solteiro, num_cama_casal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, qua.getNumero());
			ps.setBoolean(2, qua.isPrecisaConserto());
			ps.setBoolean(3, qua.isPrecisaLimpeza());
			ps.setString(4, qua.isAcessibilidade());
			ps.setBoolean(5, qua.isBanheira());
			ps.setBoolean(6, qua.isFrigobar());
			ps.setBoolean(7, qua.isArCondicionado());
			ps.setFloat(8, qua.getPreco());
			ps.setInt(9, qua.getNumMaxHospedes());
			ps.setInt(10, qua.getNumCamaSolteiro());
			ps.setInt(11, qua.getNumCamaCasal());

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
	public ArrayList<Quarto> listarQuarto() {

		ArrayList<Quarto> quartos = new ArrayList<Quarto>();

		String SQL = "SELECT * FROM quartos";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Quarto qua = new Quarto();

				int numero = rs.getInt("id_quarto");
				boolean precisaConserto = rs.getBoolean("conserto");
				boolean precisaLimpeza = rs.getBoolean("limpeza");
				String acessibilidade = rs.getString("acessibilidade");
				boolean banheira = rs.getBoolean("banheira");
				boolean frigobar = rs.getBoolean("frigobar");
				boolean arCondicionado = rs.getBoolean("ar_condicionado");
				float preco = rs.getFloat("preco");
				int numMaxHospedes = rs.getInt("nummax_hospedes");
				int numCamaSolteiro = rs.getInt("num_cama_solteiro");
				int numCamaCasal = rs.getInt("num_cama_casal");
			
				qua.setNumero(numero);
				qua.setPrecisaConserto(precisaConserto);
				qua.setPrecisaLimpeza(precisaLimpeza);
				qua.setAcessibilidade(acessibilidade);
				qua.setBanheira(banheira);
				qua.setFrigobar(frigobar);
				qua.setArCondicionado(arCondicionado);
				qua.setPreco(preco);
				qua.setNumMaxHospedes(numMaxHospedes);
				qua.setNumCamaSolteiro(numCamaSolteiro);
				qua.setNumCamaCasal(numCamaCasal);

				quartos.add(qua);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		// TODO Auto-generated method stub
		return quartos;
	}

	@Override
	public boolean atualizarQuarto(Quarto qua) { 

		String SQL = "UPDATE quartos SET conserto = ?, limpeza = ?, acessibilidade = ?, banheira = ?, frigobar = ?, ar_condicionado = ?, preco = ?, nummax_hospedes = ?, num_cama_solteiro = ?, num_cama_casal = ? WHERE id_quarto = ?";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
		
			ps.setBoolean(1, qua.isPrecisaConserto());
			ps.setBoolean(2, qua.isPrecisaLimpeza());
			ps.setString(3, qua.isAcessibilidade());
			ps.setBoolean(4, qua.isBanheira());
			ps.setBoolean(5, qua.isFrigobar());
			ps.setBoolean(6, qua.isArCondicionado());
			ps.setFloat(7, qua.getPreco());
			ps.setInt(8, qua.getNumMaxHospedes());
			ps.setInt(9, qua.getNumCamaSolteiro());
			ps.setInt(10, qua.getNumCamaCasal());
			ps.setInt(11, qua.getNumero());
			
			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean removerQuarto(Quarto qua) {
		String SQL = "DELETE FROM quartos WHERE id_quarto = ?";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int retorno = 0;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, qua.getNumero());

			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

}
