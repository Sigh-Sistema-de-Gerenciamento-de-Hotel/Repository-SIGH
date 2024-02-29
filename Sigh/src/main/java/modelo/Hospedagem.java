package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hospedagem {

	private int id;
	private Quarto quarto;
	private int numHospedes;
	private ArrayList<Hospede> hospedes;
	private LocalDateTime dataHorarioEntrada;
	private LocalDateTime dataHorarioSaida;
	private ArrayList<Pedido> pedidos;
	
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
	public int getNumHospedes() {
		return numHospedes;
	}
	public void setNumHospedes(int numHospedes) {
		this.numHospedes = numHospedes;
	}
	public ArrayList<Hospede> getHospedes() {
		return hospedes;
	}
	public void setHospedes(ArrayList<Hospede> hospedes) {
		this.hospedes = hospedes;
	}
	public LocalDateTime getDataHorarioEntrada() {
		return dataHorarioEntrada;
	}
	public void setDataHorarioEntrada(LocalDateTime dataHorarioEntrada) {
		this.dataHorarioEntrada = dataHorarioEntrada;
	}
	public LocalDateTime getDataHorarioSaida() {
		return dataHorarioSaida;
	}
	public void setDataHorarioSaida(LocalDateTime dataHorarioSaida) {
		this.dataHorarioSaida = dataHorarioSaida;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
}
