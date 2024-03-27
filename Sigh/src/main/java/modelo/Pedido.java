package modelo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pedido {
	
	private int id;
	private Quarto quarto;
	private Hospedagem hospedagem;
	private Date data;
	private Time horario;
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
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	
}
