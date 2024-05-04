package Logica;

public class Oferta {
    private int valorOferta;
    private boolean validada;
    private Comprador comprador;
    private Pieza Pieza;
    private String id;
    
	public Oferta(int valorOferta, boolean validada, Comprador comprador, Logica.Pieza pieza, String id) {
		super();
		this.valorOferta = valorOferta;
		this.validada = validada;
		this.comprador = comprador;
		Pieza = pieza;
		this.id = id;
		
	
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
