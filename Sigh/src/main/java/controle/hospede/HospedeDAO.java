package controle.hospede;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

import controle.Conexao;
import modelo.Endereco;
import modelo.Hospede;

public class HospedeDAO implements IHospedeDAO { // HospedeDAO implementa a interface IHospedeDAO.//

	private static HospedeDAO instancia;

	public HospedeDAO() { // evitar a criação de instâncias fora da classe.//
	}

	public static HospedeDAO getInstancia() { // retorna a instância única da classe HospedeDAO. Implementa o padrão
		// Singleton.//
		if (instancia == null) {
			instancia = new HospedeDAO();
		}
		return instancia;
	}

	@Override
	public int inserirHospede(Hospede hos) {

		// Montando query SQL

		String SQL = "INSERT INTO hospedes (primeiro_nome, sobrenome";
		int n = 2;

		if(!hos.getNomeSocial().isEmpty() && hos.getNomeSocial() != null) {
			SQL = SQL + ", nome_social";
			n ++;
		}

		SQL = SQL + ", genero, data_nascimento, nacionalidade";
		n += 3;

		if(hos.getCpf() != null) {
			SQL = SQL + ", cpf";
			n ++;
		}

		if(hos.getPassaporte() != null) {
			SQL = SQL + ", passaporte";
			n ++;
		}

		SQL = SQL + ", email, telefone, id_endereco";
		n += 3;

		boolean maior = false;
		if(ChronoUnit.YEARS.between(hos.getDataNascimento(), LocalDate.now()) > 18) {
			maior = true;
		} else if(ChronoUnit.YEARS.between(hos.getDataNascimento(), LocalDate.now()) == 18 && hos.getDataNascimento().getMonthValue() < LocalDate.now().getMonthValue()) {
			maior = true;
		} else if(ChronoUnit.YEARS.between(hos.getDataNascimento(), LocalDate.now()) == 18 && hos.getDataNascimento().getMonthValue() == LocalDate.now().getMonthValue() && hos.getDataNascimento().getDayOfMonth() <= LocalDate.now().getDayOfMonth()) {
			maior = true;
		}

		if(maior != true) {
			SQL = SQL + ", id_responsavel";
			n ++;
		}

		SQL = SQL + ") VALUES (?";

		for(int i=1; i<n; i++) {
			SQL = SQL + ", ?";
		}

		SQL = SQL + ")";
		n = 3;

		Conexao con = Conexao.getInstancia(); // conexão com o banco de dados.//

		Connection ConBD = con.conectar();

		int chavePrimariaGerada = 0;

		try {

			PreparedStatement ps = ConBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, hos.getNome());
			ps.setString(2, hos.getSobrenome());

			if(!hos.getNomeSocial().isEmpty() && hos.getNomeSocial() != null) {
				ps.setString(n++, hos.getNomeSocial());
			}

			ps.setString(n++, hos.getGenero());
			ps.setString(n++, String.valueOf(hos.getDataNascimento()));
			ps.setString(n++, hos.getNacionalidade());

			if(hos.getCpf() != null) {
				ps.setString(n++, hos.getCpf());
			}

			if(hos.getPassaporte() != null) {
				ps.setString(n++, hos.getPassaporte());
			}

			ps.setString(n++, hos.getEmail());
			ps.setString(n++, hos.getTelefone());
			Endereco end = hos.getEndereco();
			ps.setInt(n++, end.getId());
			Hospede resp = hos.getResponsavel();

			if(maior == false) {
				ps.setInt(n++, resp.getId());
			}

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				chavePrimariaGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}

	@Override
	public ArrayList<Hospede> listarHospede() {
		// TODO Auto-generated method stub

		ArrayList<Hospede> hospede = new ArrayList<Hospede>();

		String SQL = "SELECT * FROM hospedes INNER JOIN enderecos ON hospedes.id_endereco = enderecos.id_endereco";

		Conexao con = Conexao.getInstancia();

		Connection ConBD = con.conectar();

		try {
			PreparedStatement ps = ConBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Hospede hos = new Hospede();

				Integer id_hospede = rs.getInt("id_hospede");
				String nome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String genero = rs.getString("genero");
				Date dataNascimento = rs.getDate("data_nascimento");
				String nacionalidade = rs.getString("nacionalidade");
				String cpf = rs.getString("cpf");
				String passaporte = rs.getString("passaporte");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");

				// Endereco

				Endereco end = new Endereco();

				int id = rs.getInt("id_endereco");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String endereco = rs.getString("endereco");
				String complemento = rs.getString("complemento");
				int numero = rs.getInt("numero");
				int cep = rs.getInt("cep");

				end.setId(id);
				end.setEstado(estado);
				end.setCidade(cidade);
				end.setEndereco(endereco);
				end.setComplemento(complemento);
				end.setNumero(numero);
				end.setCep(cep);


				int idResp = rs.getInt("id_responsavel");
				if(idResp > 0) {
					String SQLResp = "SELECT * FROM hospedes WHERE id_hospede = ?";
					PreparedStatement psResp = ConBD.prepareStatement(SQLResp);
					psResp.setInt(1, idResp);
					ResultSet rsResp = psResp.executeQuery();

					while (rsResp.next()) {

						Hospede respon = new Hospede();

						Integer id_hospedeR = rsResp.getInt("id_hospede");
						String nomeR = rsResp.getString("primeiro_nome");
						String sobrenomeR = rsResp.getString("sobrenome");
						String nomeSocialR = rsResp.getString("nome_social");
						String generoR = rsResp.getString("genero");
						Date dataNascimentoR = rsResp.getDate("data_nascimento");
						String nacionalidadeR = rsResp.getString("nacionalidade");
						String cpfR = rsResp.getString("cpf");
						String passaporteR = rsResp.getString("passaporte");
						String telefoneR = rsResp.getString("telefone");

						respon.setId(id_hospedeR);
						respon.setNome(nomeR);
						respon.setSobrenome(sobrenomeR);
						respon.setNomeSocial(nomeSocialR);
						respon.setGenero(generoR);
						respon.setDataNascimento(LocalDate.parse(String.valueOf(dataNascimentoR)));
						respon.setNacionalidade(nacionalidadeR);
						respon.setCpf(cpfR);
						respon.setPassaporte(passaporteR);
						respon.setTelefone(telefoneR);

						hos.setResponsavel(respon);
					}
				}

				hos.setId(id_hospede);
				hos.setNome(nome);
				hos.setSobrenome(sobrenome);
				hos.setNomeSocial(nomeSocial);
				hos.setGenero(genero);
				hos.setDataNascimento(LocalDate.parse(String.valueOf(dataNascimento)));
				hos.setNacionalidade(nacionalidade);
				hos.setCpf(cpf);
				hos.setPassaporte(passaporte);
				hos.setEmail(email);
				hos.setTelefone(telefone);
				hos.setEndereco(end);
				hospede.add(hos);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}

		return hospede;
	}

	@Override
	public boolean atualizarHospede(Hospede hos) {

		//		String SQL = "UPDATE hospedes SET primeiro_nome = ?, sobrenome = ?, nome_social = ?, genero = ?, data_nascimento = ?,  nacionalidade = ?, cpf = ?, passaporte = ?, "
		//				+ "email = ?, telefone = ?,  id_endereco = ? WHERE id_hospede = ? ";
		//
		//		Conexao con = Conexao.getInstancia();
		//		Connection conBD = con.conectar();
		//
		//		int retorno = 0;
		//
		//		try {
		//			PreparedStatement ps = conBD.prepareStatement(SQL);
		//
		//			ps.setString(1, hos.getNome());
		//			ps.setString(2, hos.getSobrenome());
		//			ps.setString(3, hos.getNomeSocial());
		//			ps.setString(4, hos.getGenero());
		//			ps.setDate(5, Date.valueOf(hos.getDataNascimento()));
		//			ps.setString(6, hos.getNacionalidade());
		//			ps.setInt(7, hos.getCpf());
		//			ps.setString(8, hos.getPassaporte());
		//			ps.setString(9, hos.getEmail());
		//			ps.setString(10, hos.getTelefone());
		//			ps.setInt(11, 1);
		//			ps.setInt(12, hos.getId());
		//
		//			retorno = ps.executeUpdate();
		//
		//		} catch (SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} finally {
		//			con.fecharConexao();
		//
		//		}
		//
		//		return (retorno == 0 ? false : true);

		// Montando query SQL

		String SQL = "UPDATE hospedes SET primeiro_nome = ?, sobrenome = ?";

		if(!hos.getNomeSocial().isEmpty() && hos.getNomeSocial() != null) {
			SQL = SQL + ", nome_social = ?";
		}

		SQL = SQL + ", genero = ?, data_nascimento = ?,  nacionalidade = ?";

		if(hos.getCpf() != null) {
			SQL = SQL + ", cpf = ?";
		}

		if(hos.getPassaporte() != null) {
			SQL = SQL + ", passaporte = ?";
		}

		SQL = SQL + ", email = ?, telefone = ?,  id_endereco = ?";

		boolean maior = false;
		if(ChronoUnit.YEARS.between(hos.getDataNascimento(), LocalDate.now()) > 18) {
			maior = true;
		} else if(ChronoUnit.YEARS.between(hos.getDataNascimento(), LocalDate.now()) == 18 && hos.getDataNascimento().getMonthValue() < LocalDate.now().getMonthValue()) {
			maior = true;
		} else if(ChronoUnit.YEARS.between(hos.getDataNascimento(), LocalDate.now()) == 18 && hos.getDataNascimento().getMonthValue() == LocalDate.now().getMonthValue() && hos.getDataNascimento().getDayOfMonth() <= LocalDate.now().getDayOfMonth()) {
			maior = true;
		}

		if(maior != true) {
			SQL = SQL + ", id_responsavel = ?";
		}

		SQL = SQL + " WHERE id_hospede = ? ";

		int n = 3;

		Conexao con = Conexao.getInstancia(); // conexão com o banco de dados.//

		Connection ConBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = ConBD.prepareStatement(SQL);

			ps.setString(1, hos.getNome());
			ps.setString(2, hos.getSobrenome());

			if(!hos.getNomeSocial().isEmpty() && hos.getNomeSocial() != null) {
				ps.setString(n++, hos.getNomeSocial());
			}

			ps.setString(n++, hos.getGenero());
			ps.setDate(n++, Date.valueOf(hos.getDataNascimento()));
			ps.setString(n++, hos.getNacionalidade());

			if(hos.getCpf() != null) {
				ps.setString(n++, hos.getCpf());
			}

			if(hos.getPassaporte() != null) {
				ps.setString(n++, hos.getPassaporte());
			}

			ps.setString(n++, hos.getEmail());
			ps.setString(n++, hos.getTelefone());
			Endereco end = hos.getEndereco();
			ps.setInt(n++, end.getId());

			if(maior != true) {
				Hospede resp = hos.getResponsavel();
				ps.setInt(n++, resp.getId());
			}

			ps.setInt(n++, hos.getId());

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
	public boolean removerHospede(Hospede hos) {
		String SQL = "DELETE FROM hospedes WHERE id_hospede = ?";

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

		return (retorno == 0 ? false : true);
	}

	@Override
	public ArrayList<Hospede> listarHospedeResp() {
		ArrayList<Hospede> hospede = new ArrayList<Hospede>();

		String SQL = "SELECT * FROM hospedes WHERE data_nascimento <= ?";

		Conexao con = Conexao.getInstancia();
		Connection ConBD = con.conectar();

		int ano = LocalDate.now().getYear() - 18;
		int mes = LocalDate.now().getMonthValue();
		int dia = LocalDate.now().getDayOfMonth();

		LocalDate data = LocalDate.of(ano, mes, dia);

		try {
			PreparedStatement ps = ConBD.prepareStatement(SQL);

			ps.setDate(1, Date.valueOf(data));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Hospede hos = new Hospede();

				Integer id_hospede = rs.getInt("id_hospede");
				String nome = rs.getString("primeiro_nome");
				String sobrenome = rs.getString("sobrenome");
				String nomeSocial = rs.getString("nome_social");
				String genero = rs.getString("genero");
				Date dataNascimento = rs.getDate("data_nascimento");
				String nacionalidade = rs.getString("nacionalidade");
				String cpf = rs.getString("cpf");
				String passaporte = rs.getString("passaporte");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");


				hos.setId(id_hospede);
				hos.setNome(nome);
				hos.setSobrenome(sobrenome);
				hos.setNomeSocial(nomeSocial);
				hos.setGenero(genero);
				hos.setDataNascimento(LocalDate.parse(String.valueOf(dataNascimento)));
				hos.setNacionalidade(nacionalidade);
				hos.setCpf(cpf);
				hos.setPassaporte(passaporte);
				hos.setEmail(email);
				hos.setTelefone(telefone);

				hospede.add(hos);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();

		}

		return hospede;
	}
}
