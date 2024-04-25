package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Hospede extends Pessoa{
	
	private int id;
	private Hospede responsavel;
	private String genero;
	private String nacionalidade;
	private String passaporte;
	private int cpf;
	private int telefone;
	private Endereco endereco;
	private LocalDate dataNascimento;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Hospede getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Hospede responsavel) {
		this.responsavel = responsavel;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getPassaporte() {
		return passaporte;
	}
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate localDateTime) {
		this.dataNascimento = localDateTime;
	}
}
