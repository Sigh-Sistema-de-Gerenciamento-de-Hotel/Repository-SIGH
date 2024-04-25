package visao;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.hospedagem.HospedagemDAO;
import controle.hospede.HospedeDAO;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;
import visao.padrao.DateTextField;

public class HospedeJTableModel extends AbstractTableModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HospedeDAO dao = new HospedeDAO();
	private ArrayList<Hospede> lista = dao.listarHospede();
	private String[] colunas ={"Nome", "Nacionalidade",  "Telefone", "Email", "Data Nascimento", "Responsável"};
	private DateTextField dtf = new DateTextField();
	
	public HospedeJTableModel(ArrayList<Hospede> lista) {
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
		
		Hospede hosp = lista.get(rowIndex);

		Hospede resp = hosp.getResponsavel();
		
		String nomeCompleto;
		if(hosp.getNomeSocial() == null || hosp.getNomeSocial().trim().isEmpty()) {
			nomeCompleto = hosp.getNome() + " " + hosp.getSobrenome();
		} else {
			nomeCompleto = hosp.getNomeSocial() + " " + hosp.getSobrenome();
		}
		if(columnIndex == 0) {
			return nomeCompleto;
		} else if(columnIndex == 1) {
			return hosp.getNacionalidade();
		} else if(columnIndex == 2) {
			return hosp.getTelefone();
		} else if(columnIndex == 3) {
			return hosp.getEmail();
		} else if(columnIndex == 4) {
			return dtf.formatarData(hosp.getDataNascimento());
		} else if(columnIndex == 5) {
			String nomeCompletoResp;
			if(hosp.getResponsavel().getNomeSocial() == null || hosp.getResponsavel().getNomeSocial().trim().isEmpty()) {
				nomeCompletoResp = hosp.getResponsavel().getNome() + " " + hosp.getResponsavel().getSobrenome();
			} else {
				nomeCompletoResp = hosp.getResponsavel().getNomeSocial() + " " + hosp.getResponsavel().getSobrenome();
			}
			return nomeCompletoResp;
		}
		return null;
	}

}
