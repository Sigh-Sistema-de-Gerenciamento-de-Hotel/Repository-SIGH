package controle.endereco;

import java.util.ArrayList;

import modelo.Endereco;

public class EnderecoDAO implements IEnderecoDAO {

	@Override
	public int inserirEndereco(Endereco end) {
		return 0;
	}

	@Override
	public ArrayList<Endereco> listarEnderecos() {
		return null;
	}

	@Override
	public boolean atualizarEndereco(Endereco end) {
		return false;
	}

	@Override
	public boolean removerEndereco(Endereco end) {
		return false;
	}

	@Override
	public Endereco buscarEnderecoPorCep(int cep) {
		return null;
	}
	
	

}
