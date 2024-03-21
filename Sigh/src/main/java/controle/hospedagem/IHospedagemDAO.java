package controle.hospedagem;

import java.util.ArrayList;

import modelo.Hospedagem;

public interface IHospedagemDAO {

	public boolean inserirHospedagem(Hospedagem hosp);

	public ArrayList<Hospedagem> listarHospedagem();

	public boolean atualizarHospedagem(Hospedagem hosp);

	public boolean removerHospedagem(Hospedagem hosp);
	
	
}
