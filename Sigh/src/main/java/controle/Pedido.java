package controle;

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
}
