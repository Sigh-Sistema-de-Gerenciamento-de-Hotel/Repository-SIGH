package controle.quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Quarto;

public class QuartoDAO implements IQuartoDAO{
	
	private static QuartoDAO instancia;
	
	private QuartoDAO() {
		
	}
	
	public static QuartoDAO getInstacia() {
		
		if(instancia == null) {
			instancia = new QuartoDAO();
		}
		return instancia;
	}

	@Override
	public int inserirQuarto(Quarto qua) {
		String SQL = "INSERT INTO quartos (numero, numCamaCasal, numCamaSolteiro, numMaxHospedes, arCondicionado, frigobar, banheira, acessibilidade, preco, precisaLimpeza, precisaConserto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();
        
        try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, qua.getNumero());
			ps.setInt(2, qua.getNumCamaCasal());
			ps.setInt(3, qua.getNumCamaSolteiro());
			ps.setInt(4, qua.getNumMaxHospedes());
			ps.setBoolean(5, qua.isArCondicionado());
			ps.setBoolean(6, qua.isFrigobar());
			ps.setBoolean(7,  qua.isBanheira());
			ps.setBoolean(8, qua.isAcessibilidade());
			ps.setFloat(9, qua.getPreco());
			ps.setBoolean(10, qua.isPrecisaLimpeza());
			ps.setBoolean(11, qua.isPrecisaConserto());
			
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
			
			while(rs.next()) {
				Quarto qua = new Quarto();
				
				int numero = rs.getInt("numero");
				int numCamaCasal = rs.getInt("numCamaCasal");
				int numCamaSolteiro = rs.getInt("numCamaSolteiro");
				int numMaxHospedes = rs.getInt("numMaxHospedes");
				boolean arCondicionado = rs.getBoolean("arCondicionado");
				boolean frigobar = rs.getBoolean("frigobar");
				boolean banheira = rs.getBoolean("banheira");
				boolean acessibilidade = rs.getBoolean("acessibilidade");
				float preco = rs.getFloat("preco");
				boolean precisaLimpeza = rs.getBoolean("precisaLimpexa");
				boolean precisaConserto = rs.getBoolean("precisaConserto");
				
				qua.setNumero(numero);
				qua.setNumCamaCasal(numCamaCasal);
				qua.setNumCamaSolteiro(numCamaSolteiro);
				qua.setNumMaxHospedes(numMaxHospedes);
				qua.setArCondicionado(arCondicionado);
				qua.setFrigobar(frigobar);
				qua.setBanheira(banheira);
				qua.setAcessibilidade(acessibilidade);
				qua.setPreco(preco);
				qua.setPrecisaLimpeza(precisaLimpeza);
				qua.setPrecisaConserto(precisaConserto);
				
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
		
		String SQL = "UPDATE quartos SET numCamaCasal = ?, numCamaSolteiro = ?, numMaxHospedes = ?, arCondicionado = ?, frigobar = ?, banheira = ?, acessibilidade = ?, preco = ?, precisaLimpeza = ?, precisaConserto = ? WHERE numero = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, qua.getNumero());
			ps.setInt(2, qua.getNumCamaCasal());
			ps.setInt(3, qua.getNumCamaSolteiro());
			ps.setInt(4, qua.getNumMaxHospedes());
			ps.setBoolean(5, qua.isArCondicionado());
			ps.setBoolean(6, qua.isFrigobar());
			ps.setBoolean(7, qua.isBanheira());
			ps.setBoolean(8, qua.isAcessibilidade());
			ps.setFloat(9, qua.getPreco());
			ps.setBoolean(10, qua.isPrecisaLimpeza());
			ps.setBoolean(11, qua.isPrecisaConserto());
			
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
	public boolean removerQuarto(Quarto qua) {
		String SQL = "DELETE FROM quartos WHERE numero = ?";
		
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
		
		return (retorno == 0? false : true);
	}

}
