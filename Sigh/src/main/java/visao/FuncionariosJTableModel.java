package visao;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.funcionario.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionariosJTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FuncionarioDAO dao = new FuncionarioDAO();
	private ArrayList<Funcionario> lista = dao.listarFuncionario();
	private String[] colunas ={"Nome Completo", "CPF", "Cargo", "Nome Social", "Usuario"};
	
	@Override
	public int getRowCount() {
		return this.lista.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Funcionario f = lista.get(rowIndex);
		
		String primeiroNome = "PrimeiroNome";
		String sobrenome = "Sobrenome";
		String nomeCompleto = primeiroNome+sobrenome;
		
		System.out.println(nomeCompleto);
		
		if(columnIndex == 0) {
			return f.getPrimeiroNome();
		} else if(columnIndex == 1) {
			return f.getSobrenome();
		} else if(columnIndex == 2) {
			return f.getId();
		} else if(columnIndex == 3) {
			return f.getCargo();
		} else if(columnIndex == 4) {
			return f.getUsuario();
		} else if(columnIndex == 5) {
			return f.getNomeSocial();
		}	
		return null;

    }
}
