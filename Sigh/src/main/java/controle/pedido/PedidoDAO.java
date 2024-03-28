package controle.pedido;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;

import controle.Conexao;
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
		
		String SQL = "INSERT INTO inserirPedido (id, hospedagem, data, horario, setorResponsavel, quarto, descricao, feito) VALUES (?,?,?,?,?,?,?,?,?)";
		
				Conexao con = Conexao.getInstancia();
				Connection conBD = con.conectar(); 
				
				try {
					PreparedStatement ps = conBD.prepareStatement(SQL);
					
					ps.setInt(1, ped.getId());
					Hospedagem hosp = ped.getHospedagem();
					ps.setInt(2, hosp.getId());
					ps.setDate(3,  ped.getData());
					ps.setTime(4, ped.getHorario());
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
		
		ArrayList<Pedido> pedido = new ArrayList<Pedido>();  // ArrayList para armazenar resultado de select
		
		String SQL = "SELECT * FROM pedido"
				+ "INNER JOIN hospedagens ON pedidos.id_hospedagem = hospedagens.id_hospedagem"
				+ "INNER JOIN quartos ON quartos.id_quarto = pedidos.id_quarto"
				+ "INNER JOIN departamentos ON departamentos.id_departamento = pedidos.id_departamento";  // Comando de SQL a ser executado
		
		Conexao con = Conexao.getInstancia(); 	// Cria a ponte de conexao com MYSQL
		Connection conBD = con.conectar(); 
		
		
		try { 
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();  	// try catch server para tratar problemas que podem surgir, umas forma de preocaucao
			
			while(rs.next()) {
				
				Pedido ped = new Pedido(); // Criar Objeto
				
				int id = rs.getInt("id");   // Pega os valores de cada coluna do registro
				String hospedagem = rs.getString("Hospedagem");
				LocalDate data = LocalDate.parse(rs.getString("Data"));
			    String horario = rs.getString(id);
				String setor = rs.getString("SetorResponsavel");
				String quarto = rs.getString("Quarto");
				String descricao = rs.getString("descricao");
				boolean feito = rs.getBoolean("Feito");
				
				ped.setId(id);   // Set os valores no obj java
				ped.setHospedagem(null);
				ped.setData(null);
				ped.setHorario(null);
				ped.setSetorResponsavel(null);
				ped.setQuarto(null);
				ped.setDescricao(descricao);
				ped.setFeito(feito);
				
				rs.getDate("data nascimento");
				
				pedido.add(ped);   	// Adicona obj no ArrayList
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	public boolean atualizarPedido(Pedido ped) {
		
		String SQL = "UPDATE atualizarPedido SET id = ? WHERE hospedagem = ? WHERE dataHorario = ? WHERE setorResponsavel = ? WHERE quarto = ? WHERE descricao = ? WHERE feito = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, ped.getId());
			Hospedagem hosp = ped.getHospedagem();
			ps.setInt(2, hosp.getId());
			ps.setDate(3,  ped.getData());
			ps.setTime(4, ped.getHorario());
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
		
		String SQL = "DELETE FROM removerPedido WHERE id = ? WHERE hospedagem = ? WHERE dataHorario = ? WHERE setorResponsavel = ? WHERE quarto = ? WHERE descricao = ? WHERE feito = ?\";";

		Conexao con = Conexao.getInstancia(); // instanciando
		Connection conBD = con.conectar(); // cria "ponte"

		int retorno = 0;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, ped.getId());
			Hospedagem hosp = ped.getHospedagem();
			ps.setInt(2, hosp.getId());
			ps.setDate(3,  ped.getData());
			ps.setTime(4, ped.getHorario());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pedido> listarPedidoPorFeitos(boolean feito) {
		// TODO Auto-generated method stub
		return null;
	}
}