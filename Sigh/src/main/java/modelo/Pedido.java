package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
	
	private int id;
	private Quarto quarto;
	private Hospede hospede;
	private Hospedagem hospedagem;
	private LocalDateTime dataHorario;
	private Setor setorResponsavel;
	private String descricao;
	private boolean feito;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	public LocalDateTime getDataHorario() {
		return dataHorario;
	}
	public void setDataHorario(LocalDateTime dataHorario) {
		this.dataHorario = dataHorario;
	}
	public Setor getSetorResponsavel() {
		return setorResponsavel;
	}
	public void setSetorResponsavel(Setor setorResponsavel) {
		this.setorResponsavel = setorResponsavel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFeito() {
		return feito;
	}
	public void setFeito(boolean feito) {
		this.feito = feito;
	}
}
