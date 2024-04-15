package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hospedagem {

	private int id;
	private Quarto quarto;
	private int numHospedes;
	private ArrayList<Hospede> hospedes;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	
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
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
}
