package controle.quarto;

import java.util.ArrayList;

import modelo.Quarto;

public interface IQuartoDAO {

	public int inserirQuarto(Quarto qua);

	public ArrayList<Quarto> listarQuarto();

	public boolean atualizarQuarto(Quarto qua);

	public boolean removerQuarto(Quarto qua);
	
	
}
