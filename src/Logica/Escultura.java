package Logica;

public class Escultura extends Pieza {
	private double largo;
	private double ancho;
	private double alto;
	private Boolean electricidad;
	private String material;
	
	public Escultura(String titulo,int año,String lugarDeCreacion,boolean enExhibicion, String FechaSalidaGaleria,
    		String EstadoActual,
    		boolean ValorFijo,int ValorInicial,int ValorMinimo,int Valor,
    		Comprador DueñoActual, int peso,String observacion,Autor autor,  double Alto,
    		double Ancho, double Largo, boolean Electricidad, String Material) {
		
		super(titulo, año, lugarDeCreacion, enExhibicion , EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual, peso, observacion, autor,FechaSalidaGaleria);
		
    	this.id = "ESCULTURA";
		this.alto = Alto;
		this.ancho = Ancho;
		this.largo = Largo;
		this.material = Material;
		this.electricidad = Electricidad;
		
	}




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
	

