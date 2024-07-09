package modelo;

public class Quarto {
	
	private int numero;
	private int numCamaCasal;
	private int numCamaSolteiro;
	private int numMaxHospedes;
	private boolean arCondicionado;
	private boolean frigobar;
	private boolean banheira;
	private String acessibilidade;
	private float preco;
	private boolean precisaLimpeza;
	private boolean precisaConserto;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumCamaCasal() {
		return numCamaCasal;
	}
	public void setNumCamaCasal(int numCamaCasal) {
		this.numCamaCasal = numCamaCasal;
	}
	public int getNumCamaSolteiro() {
		return numCamaSolteiro;
	}
	public void setNumCamaSolteiro(int numCamaSolteiro) {
		this.numCamaSolteiro = numCamaSolteiro;
	}
	public int getNumMaxHospedes() {
		return numMaxHospedes;
	}
	public void setNumMaxHospedes(int numMaxHospedes) {
		this.numMaxHospedes = numMaxHospedes;
	}
	public boolean isArCondicionado() {
		return arCondicionado;
	}
	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	public boolean isFrigobar() {
		return frigobar;
	}
	public void setFrigobar(boolean frigobar) {
		this.frigobar = frigobar;
	}
	public boolean isBanheira() {
		return banheira;
	}
	public void setBanheira(boolean banheira) {
		this.banheira = banheira;
	}
	public String isAcessibilidade() {
		return acessibilidade;
	}
	public void setAcessibilidade(String acessibilidade) {
		this.acessibilidade = acessibilidade;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isPrecisaLimpeza() {
		return precisaLimpeza;
	}
	public void setPrecisaLimpeza(boolean precisaLimpeza) {
		this.precisaLimpeza = precisaLimpeza;
	}
	public boolean isPrecisaConserto() {
		return precisaConserto;
	}
	public void setPrecisaConserto(boolean precisaConserto) {
		this.precisaConserto = precisaConserto;
	}
	public static Quarto getInstacia() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
