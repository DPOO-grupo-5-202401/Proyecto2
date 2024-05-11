package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import Persistencia.ArchivoTextoPlano;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;


public class Administrador extends Usuario {
	
	//Atributos
	private String contrasena;
	private String login;
    private HashMap<String, Comprador> compradoresVerificados;
	public HashMap<String, Pieza> inventarioHistorico;
	public HashMap<String, Comprador> compradores;
	public HashMap<String, Autor> autores;
	
	


	//Metodos
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public HashMap<String, Comprador> getCompradoresVerificados() {
		return compradoresVerificados;
	}

	public void setCompradoresVerificados(HashMap<String, Comprador> compradoresVerificados) {
		this.compradoresVerificados = compradoresVerificados;
	}

	public HashMap<String, Pieza> getInventarioHistorico() {
		return inventarioHistorico;
	}

	public void setInventarioHistorico(HashMap<String, Pieza> inventarioHistorico) {
		this.inventarioHistorico = inventarioHistorico;
	}

	public HashMap<String, Comprador> getCompradores() {
		return compradores;
	}

	public void setCompradores(HashMap<String, Comprador> compradores) {
		this.compradores = compradores;
	}
	
	public HashMap<String, Autor> getAutores() {
		return autores;
	}

	public void setAutores(HashMap<String, Autor> autores) {
		this.autores = autores;
	}



    
	
    // Constructor
    public Administrador(String nombre, String contrasena, String login) {
        super(nombre);
        this.contrasena = contrasena;
        this.login = login;
        this.compradoresVerificados = new HashMap<>();
        this.compradores = new HashMap<>();
        this.inventarioHistorico = new HashMap<>();
        this.autores = new HashMap<>();
        }

    // Verificar un comprador
    public void verificarComprador(Comprador comprador) {
        compradoresVerificados.put(comprador.getNombre(), comprador);
    }
    
    //Crear Comprador
	public void crearComprador(String nombre, int numeroDeContacto, String contrasena, String login) {
		Comprador nuevoComprador = new Comprador(nombre,numeroDeContacto,contrasena,login); 
		this.compradores.put(nuevoComprador.getLogin(),nuevoComprador);
	}
	
	
    //Crear Autor
	public void crearAutor(String nombre) {
		Autor nuevoAutor = new Autor(nombre); 
		this.autores.put(nuevoAutor.getId(),nuevoAutor);
	}
	
	public Autor crearRetornarAutor(String nombre) {
		Autor nuevoAutor = new Autor(nombre); 
		this.autores.put(nuevoAutor.getId(),nuevoAutor);
		return nuevoAutor;
	}
	
	// Crear Video
	public void crearVideo(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Logica.Autor autor, int resolucion, int duracion) {
		
		Video nuevoVideo = new Video(id,titulo,año,lugarDeCreacion,enExhibicion,FechaEntradaGaleria,FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial,ValorMinimo,Valor,DueñoActual,peso,observacion,autor,resolucion,duracion);
		this.inventarioHistorico.put(nuevoVideo.getId(),nuevoVideo);
	}
	
	
	//Crear Pintura
	public void crearPintura(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, String tecnica, String estilo, int altura, int ancho) {
		
		Pintura nuevaPintura = new Pintura(id,titulo,año,lugarDeCreacion,enExhibicion,
				FechaEntradaGaleria,FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial, ValorMinimo,Valor,DueñoActual,peso, observacion,
				autor, tecnica,estilo,altura,ancho);
		
		this.inventarioHistorico.put(nuevaPintura.getId(),nuevaPintura);
	}
	
	//Crear Escultura
	public void crearEscultura(String titulo,int año,String lugarDeCreacion,boolean enExhibicion, 
    		String EstadoActual,
    		boolean ValorFijo,int ValorInicial,int ValorMinimo,int Valor,
    		Comprador DueñoActual, int peso,String observacion,Autor autor, String fechaSalidaGaleria, double alto,
    		double ancho, double largo, boolean electricidad, String material) {
		
		Escultura nuevaEscultura = new Escultura(titulo,año,lugarDeCreacion,enExhibicion, 
	    		EstadoActual,
	    		ValorFijo,ValorInicial,ValorMinimo,Valor,
	    		DueñoActual,peso,observacion,autor,fechaSalidaGaleria,alto,
	    		ancho, largo, electricidad, material);
		
		this.inventarioHistorico.put(nuevaEscultura.getId(),nuevaEscultura);
	}
	
	
	//Crear Fotografia
	public void crearFotografia(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, int resolucion, String tipo) {
		
		Fotografia nuevaFotografia = new Fotografia(id, titulo, año, lugarDeCreacion, enExhibicion,
				FechaEntradaGaleria, FechaSalidaGaleria, EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual,peso,observacion,
				autor, resolucion,tipo);
		this.inventarioHistorico.put(nuevaFotografia.getId(),nuevaFotografia);
	}
	
	
	//Persistencia - Cargar Texto Plano
	public void cargarCompradores() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("compradores.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			this.crearComprador(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3]);
		}
	}

	
	
	
	
	
	
	


    
    public void registrarPago(Compra compra) {
        
    }

    // Devolver una pieza al propietario
    public void devolverPieza(Pieza pieza) {
        
    }
    

    public void agregarPiezaAlInventario(Pieza pieza) {

    }

    // Iniciar una subasta
	
	public Subasta iniciarSubasta(Administrador administrador, Pieza pieza,
			HashMap<String, Comprador> compradoresValidados) {	
		LocalDate fecha = LocalDate.now();
		String fechaString = fecha.toString();
		Subasta nuevaSubasta = new Subasta(fechaString, administrador, pieza,compradoresValidados);
		
		return nuevaSubasta;
	}
	

	public void nuevoMovimiento(Integer valor, String tipoMovimiento,Comprador comprador) {
		Random random = new Random();
		Integer num = random.nextInt(90) + 10;
		String id = "MOV-" + num.toString();
		LocalTime horaActual = LocalTime.now();
		String hora = horaActual.toString();
		Movimiento nuevoMovimiento = new Movimiento(id,hora,valor,tipoMovimiento,comprador);
	}
	


}
