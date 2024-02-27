package controle.pedido;

import java.util.ArrayList;

import modelo.Pedido;
import modelo.Setor;

public class PedidoDAO implements IPedidoDAO{

	@Override
	public int inserirPedido(Pedido ped) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Pedido> listarPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizarPedido(Pedido ped) {
		// TODO Auto-generated method stub
		return false;
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
