package Logica;

import java.util.HashMap;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;


public class Administrador extends Usuario {
	
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


	private String contrasena;
	private String login;
    private HashMap<String, Comprador> compradoresVerificados;
	public HashMap<String, Pieza> inventarioHistorico;
	public HashMap<String, Comprador> compradores;
    
	
    // Constructor
    public Administrador(String nombre, String contrasena, String login) {
        super(nombre);
        this.contrasena = contrasena;
        this.login = login;
        this.compradoresVerificados = new HashMap<>();
        this.compradores = new HashMap<>();
        this.inventarioHistorico = new HashMap<>();    
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
	public void crearEscultura(String id, String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaEntradaGaleria, String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, double largo, double ancho, double alto, boolean electricidad, String material) {
		
		Escultura nuevaEscultura = new Escultura(id, titulo, año, lugarDeCreacion, enExhibicion,
				FechaEntradaGaleria, FechaSalidaGaleria, EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual,peso,observacion,
				autor, largo, ancho, alto,electricidad, material);
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
