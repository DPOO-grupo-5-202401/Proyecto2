package Logica;

public class Oferta {
	public static int contadorOfertas = 0;
    private int valorOferta;
    private boolean validada;
    private Comprador comprador;
    private Pieza Pieza;
    private String id;
    
	public Oferta(Comprador comprador, Pieza pieza) {
		String numero = String.format("%03d", contadorOfertas);
		this.id = numero;
		contadorOfertas++;
		
		this.valorOferta = pieza.getValor();
		this.validada = false;
		this.comprador = comprador;
		this.Pieza = pieza;
		
	
	}

	public int getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(int valorOferta) {
		this.valorOferta = valorOferta;
	}

	public boolean isValidada() {
		return validada;
	}

	public void setValidada(boolean validada) {
		this.validada = validada;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Pieza getPieza() {
		return Pieza;
	}

	public void setPieza(Pieza pieza) {
		Pieza = pieza;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
