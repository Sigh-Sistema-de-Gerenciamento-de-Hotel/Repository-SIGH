package controle.pedido;

import java.util.ArrayList;

import modelo.Pedido;
import modelo.Setor;

public interface IPedidoDAO {

	public int inserirPedido(Pedido ped);

	public ArrayList<Pedido> listarPedido();

	public boolean atualizarPedido(Pedido ped);

	public boolean removerPedido(Pedido ped);
	
	public ArrayList<Pedido> listarPedidoPorSetor(Setor s);
	
	public ArrayList<Pedido> listarPedidoPorFeitos(boolean feito);
	
}
