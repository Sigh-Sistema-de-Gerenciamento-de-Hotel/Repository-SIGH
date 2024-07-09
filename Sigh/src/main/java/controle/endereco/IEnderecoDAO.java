package controle.endereco;

import java.util.ArrayList;

import modelo.Endereco;
import modelo.EnderecoViaCep;

public interface IEnderecoDAO {

	public int inserirEndereco(Endereco end);

	public ArrayList<Endereco> listarEnderecos();

	public boolean atualizarEndereco(Endereco end);

	public boolean removerEndereco(Endereco end);

	public ArrayList<Endereco> buscarEnderecoPorCep(int cep);
	
	public Endereco converterEnderecoViaCep(EnderecoViaCep evc);

}
