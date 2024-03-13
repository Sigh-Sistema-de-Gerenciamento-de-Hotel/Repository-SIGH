package visao;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.funcionario.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionariosJTableModel extends AbstractTableModel {

	FuncionarioDAO dao = new FuncionarioDAO();
	private ArrayList<Funcionario> lista = dao.listarFuncionario();
	private String[] colunas ={"Nome Completo", "Cargo", "Setor", "Usu\u00E1rio", "Data de nascimento"};
	
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
		/*if(columnIndex == 0) {
			
			return f.getnome;
		} else if(columnIndex == 1) {
			return q.getCodigo();
		} else if(columnIndex == 2) {
			return q.getMaxHospedes();
		} else if(columnIndex == 3) {
			return q.getCama();
		} else if(columnIndex == 4) {
			if (q.isBanheira() == true) {
				return "sim";
			} else {
				return "não";
			}
		} else if(columnIndex == 5) {
			if (q.isFrigobar() == true) {
				return "sim";
			} else {
				return "não";
			}
		} else if(columnIndex == 6) {
			return q.getVista();
		} else if(columnIndex == 7) {
			return "R$" + q.getPreco();
		} else if(columnIndex == 8) {
			return q.getStatus();
		} 
		return null;*/
		return null;
	}

}
