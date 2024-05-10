package Logica;

public class Pintura extends Pieza{
	private String tecnica;
	private String estilo;
	private int altura;
	private int ancho;
	
	public String getTecnica() {
		return tecnica;
	}
	public String getEstilo() {
		return estilo;
	}
	public int getAltura() {
		return altura;
	}
	public int getAncho() {
		return ancho;
	}
	
	public void setResolucion(String tecnica) {
    	this.tecnica= tecnica;
    }
	
	public void setEstilo(String estilo) {
    	this.estilo= estilo;
    }
	
	public void setAncho(int ancho) {
    	this.ancho= ancho;
    }
	
	public void setAltura(int altura) {
    	this.altura= altura;
    }
	public Pintura(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, String tecnica, String estilo, int altura, int ancho) {
		
		super(titulo, año, lugarDeCreacion, enExhibicion, FechaEntradaGaleria, FechaSalidaGaleria, EstadoActual,
				ValorFijo, ValorInicial, ValorMinimo, Valor, DueñoActual, peso, observacion, autor);
		this.tecnica = tecnica;
		this.estilo = estilo;
		this.altura = altura;
		this.ancho = ancho;
	}
	
	
		
	}
	
