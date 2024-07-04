package controle.hospede;

import java.util.ArrayList;

import modelo.Hospede;

public interface IHospedeDAO {

	public int inserirHospede(Hospede hos);
	

	public ArrayList<Hospede> listarHospede();

	public boolean atualizarHospede(Hospede hos);

	public boolean removerHospede(Hospede hos);
	
	
	
	
}
