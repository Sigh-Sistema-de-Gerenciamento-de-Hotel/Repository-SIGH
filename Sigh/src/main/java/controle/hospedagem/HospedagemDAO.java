package controle.hospedagem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;

public class HospedagemDAO implements IHospedagemDAO{

	private static HospedagemDAO instancia;

	public HospedagemDAO() {

	}

	public static HospedagemDAO getInstancia() {

		if(instancia==null) {
			instancia=new HospedagemDAO();
		}
		return instancia;
	}

	@Override
	public int inserirHospedagem(Hospedagem hosp) {
		String SQL = "INSERT INTO hospedagens (id_hospedagem, data_entrada, data_saida) VALUES (?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chaveGerada = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, hosp.getId());
			ps.setDate(2, Date.valueOf(hosp.getDataEntrada()));
			ps.setDate(3, Date.valueOf(hosp.getDataSaida()));

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
	public ArrayList<Hospedagem> listarHospedagem() {
		// ArrayList para armazenar resultado select
		ArrayList<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

		// Comando SQL a ser executado
		String SQL = "SELECT * FROM hospede_hospedagem "
				+ "INNER JOIN hospedagens ON hospede_hospedagem.id_hospedagem = hospedagens.id_hospedagem "
				+ "INNER JOIN hospedes ON hospede_hospedagem.id_hospede = hospedes.id_hospede "
				+ "INNER JOIN quartos ON hospede_hospedagem.id_quarto = quartos.id_quarto";

		// Cria a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Hospedagem hos = new Hospedagem();

				// Hospedagem 
				int id = rs.getInt("id_hospedagem");
				LocalDate dataEntrada = LocalDate.parse(rs.getString("data_entrada"));
				LocalDate dataSaida = LocalDate.parse(rs.getString("data_saida"));
				
				// Hospede
				ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
				Hospede hospede = new Hospede();
				Integer id_hospede = rs.getInt("id"); 
				String genero = rs.getString("genero");
				String dataNascimento = rs.getString("dataNascimento");
				String nacionalidade = rs.getString("nacionalidade"); 
				Integer cpf = rs.getInt("cpf"); 
				String passaporte = rs.getString("passaporte"); 
				Integer telefone = rs.getInt("telefone"); 
				
				hospede.setId(id_hospede);			
				hospede.setGenero(genero);
				hospede.setDataNascimento(LocalDate.parse( dataNascimento));
				hospede.setNacionalidade(nacionalidade);
				hospede.setCpf(cpf);
				hospede.setPassaporte(passaporte);
				hospede.setTelefone(telefone);
				
				hospedes.add(hospede);
				
				// Quarto
				Quarto quarto = new Quarto();
				int numero = rs.getInt("id_quarto");
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
				
				quarto.setNumero(numero);
				quarto.setNumCamaCasal(numCamaCasal);
				quarto.setNumCamaSolteiro(numCamaSolteiro);
				quarto.setNumMaxHospedes(numMaxHospedes);
				quarto.setArCondicionado(arCondicionado);
				quarto.setFrigobar(frigobar);
				quarto.setBanheira(banheira);
				quarto.setAcessibilidade(acessibilidade);
				quarto.setPreco(preco);
				quarto.setPrecisaLimpeza(precisaLimpeza);
				quarto.setPrecisaConserto(precisaConserto);
				
				hos.setId(id);
				hos.setDataEntrada(dataEntrada);
				hos.setDataSaida(dataSaida);
				hos.setHospedes(hospedes);
				hos.setQuarto(quarto);

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

		// Cria a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia(); // Instancia a conexao
		Connection conBD = con.conectar(); // Cria a ponte com o MySQL

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setDate(1, Date.valueOf(hosp.getDataSaida()));
			ps.setDate(2, Date.valueOf(hosp.getDataEntrada()));
			ps.setInt(3, hosp.getId());
			
			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0? false : true);

	}

	@Override
	public boolean removerHospedagem(Hospedagem hosp) {
		String SQL = "DELETE FROM hospedagens WHERE id_hospedagem = ?";
		
		Conexao con = Conexao.getInstancia(); // Instancia a conexao
		Connection conBD = con.conectar(); // Cria a ponte com o MySQL

		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, hosp.getId());
			
			retorno = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0? false : true);
	}

}
