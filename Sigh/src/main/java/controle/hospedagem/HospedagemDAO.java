package controle.hospedagem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.util.ArrayList;

import controle.Conexao;
import controle.hospede.HospedeDAO;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;

public class HospedagemDAO implements IHospedagemDAO {

	private static HospedagemDAO instancia;

	public HospedagemDAO() {

	}

	public static HospedagemDAO getInstancia() {;
		if(instancia==null) {
			instancia=new HospedagemDAO();
		}
		return instancia;
	}

	@Override
	public int inserirHospedagem(Hospedagem hosp) {
		
		// Inserindo hospedagem na tabela Hospedagens
		String SQL = "INSERT INTO hospedagens (data_entrada, data_saida) VALUES (?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chaveGerada = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL , Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, Date.valueOf(hosp.getDataEntrada()));
			ps.setDate(2, Date.valueOf(hosp.getDataSaida()));

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				chaveGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		hosp.setId(chaveGerada);
		
		boolean erro = false;
		// Inserindo dados na tabela Hospede_hopedagem
		
		for (Hospede h : hosp.getHospedes()) {
			String SQLh = "INSERT INTO hospede_hospedagem (id_hospedagem, id_hospede, id_quarto) VALUES (?, ?, ?)";

			Connection conBDh = con.conectar();

			try {
				PreparedStatement ps = conBD.prepareStatement(SQLh);

				ps.setInt(1, chaveGerada);
				ps.setInt(2, h.getId());
				ps.setInt(3, hosp.getQuarto().getNumero());

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		con.fecharConexao();

		if(erro == false) {
			return chaveGerada;
		} else {
			return chaveGerada = 0;
		}
	}

	@Override
	public ArrayList<Hospedagem> listarHospedagem() {
		// ArrayList para armazenar resultado select
		ArrayList<Hospedagem> hospedagens = null;

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
			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			hospedagens = new ArrayList<Hospedagem>();

			while (rs.next()) {
				Hospedagem hos = new Hospedagem();

				// Hospedagem
				int id = rs.getInt("id_hospedagem");
				LocalDate dataEntrada = LocalDate.parse(rs.getString("data_entrada"));
				String dataSaidatxt = rs.getString("data_saida");
				LocalDate dataSaida = null;
				if (dataSaidatxt != null) {
					dataSaida = LocalDate.parse(dataSaidatxt);
				}

				// Hospede
				Hospede hospede = new Hospede();
				Integer id_hospede = rs.getInt("id_hospede");
				String genero = rs.getString("genero");
				String dataNascimento = rs.getString("data_nascimento");
				String nacionalidade = rs.getString("nacionalidade");
				String cpf = rs.getString("cpf");
				String passaporte = rs.getString("passaporte");
				String telefone = rs.getString("telefone");
				String primeiro_nome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nome_social = rs.getString("nome_social");
				String email = rs.getString("email");


				hospede.setId(id_hospede);
				hospede.setGenero(genero);
				hospede.setDataNascimento(LocalDate.parse(dataNascimento));
				hospede.setNacionalidade(nacionalidade);
				hospede.setCpf(cpf);
				hospede.setPassaporte(passaporte);
				hospede.setTelefone(telefone);
				hospede.setNome(primeiro_nome);
				hospede.setNomeSocial(nome_social);
				hospede.setSobrenome(sobrenome);
				hospede.setEmail(email);

				// Quarto
				Quarto quarto = new Quarto();
				int numero = rs.getInt("id_quarto");
				int numCamaCasal = rs.getInt("num_cama_casal");
				int numCamaSolteiro = rs.getInt("num_cama_solteiro");
				int numMaxHospedes = rs.getInt("nummax_hospedes");
				boolean arCondicionado = rs.getBoolean("ar_condicionado");
				boolean frigobar = rs.getBoolean("frigobar");
				boolean banheira = rs.getBoolean("banheira");
				String acessibilidade = rs.getString("acessibilidade");
				float preco = rs.getFloat("preco");
				boolean precisaLimpeza = rs.getBoolean("limpeza");
				boolean precisaConserto = rs.getBoolean("conserto");

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

				// Conferindo se a hospedagem já existe

				boolean novaHosp = true;
				for (Hospedagem hospedagem : hospedagens) {
					if (hospedagem.getId() == id) {
						hospedagem.getHospedes().add(hospede);
						novaHosp = false;
					}
				}

				// Se a hospedagem não estiver listada ainda, adiciona a listagem
				if (novaHosp == true) {
					ArrayList<Hospede> hospedes = new ArrayList<>();
					hospedes.add(hospede);
					hos.setHospedes(hospedes);
					hos.setId(id);
					hos.setDataEntrada(dataEntrada);
					hos.setDataSaida(dataSaida);
					hos.setQuarto(quarto);

					hospedagens.add(hos);
				}

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
		} 
		
		// Atualizando dados na tabela Hospede_hopedagem
		
		
			SQL = "DELETE FROM hospede_hospedagem WHERE  id_hospedagem = ?";

			Connection conBDh = con.conectar();

			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);

				ps.setInt(1, hosp.getId());

				retorno = ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
		
		for (Hospede h : hosp.getHospedes()) {
			String SQLh = "INSERT INTO hospede_hospedagem (id_hospedagem, id_hospede, id_quarto) VALUES (?, ?, ?)";


			try {
				PreparedStatement ps = conBD.prepareStatement(SQLh);

				ps.setInt(1, hosp.getId());
				ps.setInt(2, h.getId());
				ps.setInt(3, hosp.getQuarto().getNumero());

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		con.fecharConexao();
		
		return (retorno == 0 ? false : true);

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

		return (retorno == 0 ? false : true);
	}

	@Override
	
	public int inserirHospedeHospedagem(Hospede hos, Hospedagem hosp) {
		String SQL = "INSERT INTO hospede_hospedagem (id_hospedagem, id_hospede, id_quarto) VALUES (?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chaveGerada = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL , Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, (hosp.getId()));
			ps.setInt(2, (hos.getId()));
			ps.setInt(3, (hosp.getQuarto().getNumero()));
			System.out.println(ps); 

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				chaveGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chaveGerada;
	}

}
