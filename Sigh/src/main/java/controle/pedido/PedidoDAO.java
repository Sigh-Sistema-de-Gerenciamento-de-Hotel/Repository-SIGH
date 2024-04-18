package controle.pedido;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.*;
import java.util.ArrayList;

import controle.Conexao;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Pedido;
import modelo.Quarto;
import modelo.Setor;

public class PedidoDAO implements IPedidoDAO{
	
	private static PedidoDAO instancia;
	
	private PedidoDAO() {
		
	}
	public static PedidoDAO getInstancia() {
		if(instancia == null) {
			instancia = new PedidoDAO();
		}
		return instancia;
	}

	@Override
	public int inserirPedido(Pedido ped) {
		
		String SQL = "INSERT INTO pedidos (id, hospedagem, data, horario, setorResponsavel, quarto, descricao, feito) VALUES (?,?,?,?,?,?,?,?,?)";
		
				Conexao con = Conexao.getInstancia();
				Connection conBD = con.conectar(); 
					
				try {
					PreparedStatement ps = conBD.prepareStatement(SQL);
					
					ps.setInt(1, ped.getId());
					Hospedagem hosp = ped.getHospedagem();
					ps.setInt(2, hosp.getId());
					//ps.setDate(3, ped.getData());
					//ps.setTime(4, ped.getHorario());
					Setor setor = ped.getSetorResponsavel();
					ps.setInt(5, setor.getId());
					Quarto q = ped.getQuarto();
					ps.setInt(6, q.getNumero());
					ps.setString(7, ped.getDescricao());
					ps.setBoolean(8, ped.isFeito());
				
					ps.executeUpdate(); //executa sem esperar retorno do BD
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					con.fecharConexao();
				}
				
		return 0;
	}

	@Override
	public ArrayList<Pedido> listarPedido() {
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();  // ArrayList para armazenar resultado de select
		
		String SQL = "SELECT * FROM pedidos"
				+ "INNER JOIN hospedagens ON pedidos.id_hospedagem = hospedagens.id_hospedagem"
				+ "INNER JOIN quartos ON quartos.id_quarto = pedidos.id_quarto"
				+ "INNER JOIN departamentos ON departamentos.id_departamento = pedidos.id_departamento";  // Comando de SQL a ser executado
		
		Conexao con = Conexao.getInstancia(); 	// Cria a ponte de conexao com MYSQL
		Connection conBD = con.conectar(); 
		
		
		try { 
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();  	// try catch server para tratar problemas que podem surgir, umas forma de preocaucao
			
			while(rs.next()) {
				
				rs.getDate("data");
				
				Pedido ped = new Pedido(); // Criar Objeto
				
				int id = rs.getInt("id");   
				String hospedagem = rs.getString("hospedagem");
				LocalDate data = LocalDate.parse(rs.getString("data"));
			    LocalTime horario = LocalTime.parse(rs.getString("horario"));
				String setorResponsavel = rs.getString("setor");
				String quarto = rs.getString("quarto");
				String descricao = rs.getString("descricao");
				boolean feito = rs.getBoolean("feito");
				
				ped.setId(id);  
				ped.setHospedagem(null);
				//ped.setData(null);
				//ped.setHorario(null);
				ped.setSetorResponsavel(null);
				ped.setQuarto(null);
				ped.setDescricao(descricao);
				ped.setFeito(feito);
				
				
				//HOSPEDAGEM
				Hospedagem hos = new Hospedagem();
				id = rs.getInt("id_hospedagem");
				LocalDate dataEntrada = LocalDate.parse(rs.getString("data_entrada"));
				String dataSaidatxt = rs.getString("data_saida");
				LocalDate dataSaida = null;
				if(dataSaidatxt!=null) {
					dataSaida = LocalDate.parse(dataSaidatxt);
				}
				
				hos.setId(id);
				hos.setDataEntrada(dataEntrada);
				hos.setDataSaida(dataSaida);
				
				
				// QUARTO
                Quarto qua = new Quarto();
				int numero = rs.getInt("numero");
				int numCamaCasal = rs.getInt("numCamaCasal");
				int numCamaSolteiro = rs.getInt("numCamaSolteiro");
				int numMaxHospedes = rs.getInt("numMaxHospedes");
				boolean arCondicionado = rs.getBoolean("arCondicionado");
				boolean frigobar = rs.getBoolean("frigobar");
				boolean banheira = rs.getBoolean("banheira");
				String acessibilidade = rs.getString("acessibilidade");
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
				//qua.setAcessibilidade(acessibilidade);
				qua.setPreco(preco);
				qua.setPrecisaLimpeza(precisaLimpeza);
				qua.setPrecisaConserto(precisaConserto);
				
				pedidos.add(ped);  
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean atualizarPedido(Pedido ped) {
		
		String SQL = "UPDATE pedidos SET hospedagem = ?, data = ?, horario = ?, setorResponsavel = ?, quarto = ?, descricao = ?, feito = ? WHERE id = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, ped.getId());
			Hospedagem hosp = ped.getHospedagem();
			ps.setInt(2, hosp.getId());
			//ps.setDate(3, ped.getData());
			//ps.setTime(4, ped.getHorario());
			Setor setor = ped.getSetorResponsavel();
			ps.setInt(5, setor.getId());
			Quarto q = ped.getQuarto();
			ps.setInt(6, q.getNumero());
			ps.setString(7, ped.getDescricao());
			ps.setBoolean(8, ped.isFeito());
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return (retorno == 0 ? false : true); 	//if Ternario (operador condicional ternario)
	}

	@Override
	public boolean removerPedido(Pedido ped) {
		
		String SQL = "DELETE FROM pedidos hospedagem = ?, data = ?, horario = ?, setorResponsavel = ?, quarto = ?, descricao = ?, feito = ? WHERE id = ?";
		
		Conexao con = Conexao.getInstancia(); // instanciando
		Connection conBD = con.conectar(); // cria "ponte"

		int retorno = 0;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, ped.getId());
			Hospedagem hosp = ped.getHospedagem();
			ps.setInt(2, hosp.getId());
			//ps.setDate(3, ped.getData());
			//ps.setTime(4, ped.getHorario());
			Setor setor = ped.getSetorResponsavel();
			ps.setInt(5, setor.getId());
			Quarto q = ped.getQuarto();
			ps.setInt(6, q.getNumero());
			ps.setString(7, ped.getDescricao());
			ps.setBoolean(8, ped.isFeito());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public ArrayList<Pedido> listarPedidoPorSetor(Setor s) {
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		String SQL = "SELECT * FROM pedidos WHERE id = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Pedido ped = new Pedido();
				
				int id = rs.getInt("id");   
				String hospedagem = rs.getString("hospedagem");
				LocalDate data = LocalDate.parse(rs.getString("data"));
			    LocalTime horario = LocalTime.parse(rs.getString("horario"));
				String setorResponsavel = rs.getString("setor");
				String quarto = rs.getString("quarto");
				String descricao = rs.getString("descricao");
				boolean feito = rs.getBoolean("feito");
				
				ped.setId(id);  
				ped.setHospedagem(null);
				//ped.setData(null);
				//ped.setHorario(null);
				ped.setSetorResponsavel(s);
				ped.setQuarto(null);
				ped.setDescricao(descricao);
				ped.setFeito(feito);
				
				pedidos.add(ped);
				
			}
		
		} catch (SQLException e) {
		
		} finally {
			con.fecharConexao();
		}
		
		return pedidos;
		
		}
	
	@Override
	public ArrayList<Pedido> listarPedidoPorFeitos(boolean feito) {
		
         ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		String SQL = "SELECT * FROM pedidos WHERE feito = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Pedido ped = new Pedido();
				
				int id = rs.getInt("id");   
				String hospedagem = rs.getString("hospedagem");
				LocalDate data = LocalDate.parse(rs.getString("data"));
			    LocalTime horario = LocalTime.parse(rs.getString("horario"));
				String setorResponsavel = rs.getString("Setor");
				String quarto = rs.getString("quarto");
				String descricao = rs.getString("descricao");
				feito = rs.getBoolean("feito");
				
				ped.setId(id);  
				ped.setHospedagem(null);
				//ped.setData(null);
				//ped.setHorario(null);
				ped.setSetorResponsavel(null);
				ped.setQuarto(null);
				ped.setDescricao(descricao);
				ped.setFeito(feito);
				
				pedidos.add(ped);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return pedidos;
	}
}