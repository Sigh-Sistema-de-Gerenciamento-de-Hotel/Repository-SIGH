package visao;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.hospedagem.HospedagemDAO;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;

public class HospedagemJTableModel extends AbstractTableModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HospedagemDAO dao = new HospedagemDAO();
	private ArrayList<Hospedagem> lista = dao.listarHospedagem();
	private String[] colunas ={"Código", "Código quarto", "Nº de Hóspedes",  "Entrada", "Saída"};
	
	public HospedagemJTableModel(ArrayList<Hospedagem> lista) {
		super();
		this.lista = lista;
	}

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
		
		Hospedagem hosp = lista.get(rowIndex);

		Quarto q = hosp.getQuarto();
		ArrayList<Hospede> h = hosp.getHospedes();
		
		if(columnIndex == 0) {
			return hosp.getId();
		} else if(columnIndex == 1) {
			return q.getNumero();
		} else if(columnIndex == 2) {
			return h.size();
		} else if(columnIndex == 3) {
			return hosp.getDataEntrada();
		} else if(columnIndex == 4) {
			return hosp.getDataSaida();
		}
		return null;
	}

}
