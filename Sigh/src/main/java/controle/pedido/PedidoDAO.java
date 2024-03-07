package controle.pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import controle.Conexao;
import modelo.Pedido;
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
		
		String SQL = "INSERT INTO inserirPedido (id, hospede, hospedagem, dataHorario, setorResponsavel, quarto, descricao, feito) VALUES (?,?,?,?,?,?,?,?)";
		
				Conexao con = Conexao.getInstancia();
				Connection conBD = con.conectar(); 
				
				try {
					PreparedStatement ps = conBD.prepareStatement(SQL);
					
					ps.setInt(1, ped.getId());
					//ps.setString(2, ped.getHospede());
					//ps.setString(3, ped.getHospedagem());
					//ps.setString(4,  ped.getDataHorario());
					//ps.setString(5, ped.getSetorResponsavel());
					//ps.setString(7, ped.getQuarto());
					ps.setString(6, ped.getDescricao());
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
		
		// ArrayList para armazenar resultado de select
		ArrayList<Pedido> pedido = new ArrayList<Pedido>();
		
		// Comando de SQL a ser executado
		String SQL = "SELECT * FROM pedido";
		
		
		// Cria a ponte de conexao com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar(); 
		
		
		// try catch server para tratar problemas que podem surgir, umas forma de preocaucao
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				//String SQL =" SELECT Quarto, Hospede, Hospedagem, LocalDateTime, SetorResponsavel"
				//		+ "FROM Pedido\n"
				//		+ "INNER JOIN Categories ON Pedido.Quarto = Pedido.Hospede = Pedido.Hospedagem = Pedido.LocalDateTime = Pedido.SetorResponsavel";
				
						
				// Criar Objeto
				Pedido ped = new Pedido();
				
				// Pega os valores de cada coluna do registro
				int id = rs.getInt("id");
				String Hospede = rs.getString("Hospede");
				String Hospedagem = rs.getString("Hospedagem");
				String DataHorario = rs.getString("DataHorario");
				String SetorResponsavel = rs.getString("SetorResponsavel");
				String Quarto = rs.getString("Quarto");
				String descricao = rs.getString("descricao");
				boolean feito = rs.getBoolean("Feito");
				
				// Set os valores no obj java
				ped.setId(id);
				ped.setHospede(null);
				ped.setHospedagem(null);
				ped.setDataHorario(null);
				ped.setSetorResponsavel(null);
				ped.setQuarto(null);
				ped.setDescricao(descricao);
				ped.setFeito(feito);
				
				Date dt = rs.getDate("data nascimento");
				
				// Adicona obj no ArrayList
				pedido.add(ped);
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
		
		String SQL = "UPDATE pedidos SET id = ? WHERE hospede = ? WHERE hospedagem = ? WHERE dataHorario ? WHERE setorResponsavel = ? WHERE quarto = ? WHERE descricao = ? WHERE feito = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, ped.getId());
			//ps.setString(2, ped.getHospede());
			//ps.setString(3, ped.getHospedagem());
			//ps.setString(4,  ped.getDataHorario());
			//ps.setString(5, ped.getSetorResponsavel());
			//ps.setString(7, ped.getQuarto());
			//ps.setString(6, ped.getDescricao());
			ps.setBoolean(8, ped.isFeito());
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		//if Ternario (operador condicional ternario)
		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean removerPedido(Pedido ped) {
		// TODO Auto-generated method stub
		return false;
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
