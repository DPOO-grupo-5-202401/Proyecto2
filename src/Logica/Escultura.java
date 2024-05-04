package Logica;

public class Escultura extends Pieza {
	
	public Escultura(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor) {
		super(id, titulo, año, lugarDeCreacion, enExhibicion, FechaEntradaGaleria, FechaSalidaGaleria, EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual, peso, observacion, autor);
	}


	private double largo;
	private double ancho;
	private double alto;
	private Boolean electricidad;
	private String material;

	//Getters
	public double getLargo() {
		return largo;
	}
	
	public double getAncho() {
		return ancho;
	}
	
	public double getAlto() {
		return alto;
	}
	
	public Boolean getElectricidad() {
		return electricidad;
	}
	
	
	public String getMaterial() {
		return material;
	}
	
	//Setters
	public void setLargo(double largo) {
		this.largo=largo;
	}
	
	public void setAncho(double ancho) {
		this.ancho=ancho;
	}
	
	public void setAlto(double alto) {
		this.alto=alto;
	}
	
	
	public void setElectricidad(boolean electricidad) {
		this.electricidad=electricidad;
	}
	
	
	public void setMaterial(String material) {
		this.material=material;
	}

	public void setElectricidad(Boolean electricidad) {
		this.electricidad = electricidad;
	}
	

		
	}
	

