package controle;

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
	
}
