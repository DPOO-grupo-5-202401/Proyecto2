package Logica;

public class Video extends Pieza {
	private int resolucion;
	private int duracion;
	
	
	public Video(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, int resolucion, int duracion) {
		super(id, titulo, año, lugarDeCreacion, enExhibicion, FechaEntradaGaleria, FechaSalidaGaleria, EstadoActual,
				ValorFijo, ValorInicial, ValorMinimo, Valor, DueñoActual, peso, observacion, autor);
		this.resolucion = resolucion;
		this.duracion = duracion;
	}
	
	
	public int getResolucion() {
    	return resolucion;
    }
	
	public int getDuracion() {
    	return duracion;
    }
	
	public void setResolucion(int resolucion) {
    	this.resolucion= resolucion;
    }
	
	public void setDuracion(int duracion) {
    	this.duracion= duracion;
    }



	
	

}
