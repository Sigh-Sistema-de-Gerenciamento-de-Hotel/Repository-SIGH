package modelo;

public enum Setor {
	
	ADM(10, "ADM"), RH(11, "RH"), LIMPEZA(12, "Limpeza"), MANUTENCAO(13, "Manutenção"), RECEPCAO(14, "Recepção");

	private int id;
	private String nome;
	
	Setor(int id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
		
}
