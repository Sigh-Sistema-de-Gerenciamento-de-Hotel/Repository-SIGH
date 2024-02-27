package modelo;

import java.time.LocalDateTime;

public class Hospede {

	private int id;
	private Hospede responsavel;
	private String genero;
	private String nacionalidade;
	private String passaporte;
	private int cpf;
	private int telefone;
	private Endereco endereco;
	private LocalDateTime dataNascimento;
}
