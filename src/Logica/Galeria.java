package Logica;

import java.util.HashMap;


public class Galeria {
	public HashMap<String, Pieza> inventarioHistorico;
	public HashMap<String, Comprador> compradores;
	
	
	
	public Galeria() {
		this.inventarioHistorico = new HashMap<String, Pieza>();
		this.compradores = new HashMap<String, Comprador>();
	}


	
	public void crearVideo(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Logica.Autor autor, int resolucion, int duracion) {
		
		Video nuevoVideo = new Video(id,titulo,año,lugarDeCreacion,enExhibicion,FechaEntradaGaleria,FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial,ValorMinimo,Valor,DueñoActual,peso,observacion,autor,resolucion,duracion);
		this.inventarioHistorico.put(nuevoVideo.getId(),nuevoVideo);
	}
	
	public void crearEscultura(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,Autor autor) {
		
		Escultura nuevaEscultura = new Escultura(id,titulo,año,lugarDeCreacion,enExhibicion,
				FechaEntradaGaleria, FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial,ValorMinimo,Valor,DueñoActual, peso, observacion,autor);
		
		this.inventarioHistorico.put(nuevaEscultura.getId(),nuevaEscultura);
	}
	
	

	
	
	

	}

