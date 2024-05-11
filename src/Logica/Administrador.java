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
	public void crearVideo(String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, int resolucion, int duracion) {
		
		Video nuevoVideo = new Video(titulo,año,lugarDeCreacion,enExhibicion,FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial,ValorMinimo,Valor,DueñoActual,peso,observacion,autor,resolucion,duracion);
		this.inventarioHistorico.put(nuevoVideo.getTitulo(),nuevoVideo);
	}
	
	
	//Crear Pintura
	public void crearPintura(String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, String tecnica, String estilo, int altura, int ancho) {
		
		Pintura nuevaPintura = new Pintura(titulo,año,lugarDeCreacion,enExhibicion,
				FechaSalidaGaleria,EstadoActual,ValorFijo,
				ValorInicial, ValorMinimo,Valor,DueñoActual,peso, observacion,
				autor, tecnica,estilo,altura,ancho);
		
		this.inventarioHistorico.put(nuevaPintura.getTitulo(),nuevaPintura);
	}
	
	//Crear Escultura
	public void crearEscultura(String titulo,int año,String lugarDeCreacion,boolean enExhibicion, 
    		String EstadoActual,String fechaSalidaGaleria,
    		boolean ValorFijo,int ValorInicial,int ValorMinimo,int Valor,
    		Comprador DueñoActual, int peso,String observacion,Autor autor,  double alto,
    		double ancho, double largo, boolean electricidad, String material) {
		
		Escultura nuevaEscultura = new Escultura(titulo,año,lugarDeCreacion,enExhibicion, 
	    		EstadoActual,fechaSalidaGaleria,
	    		ValorFijo,ValorInicial,ValorMinimo,Valor,
	    		DueñoActual,peso,observacion,autor,alto,
	    		ancho, largo, electricidad, material);
		
		this.inventarioHistorico.put(nuevaEscultura.getTitulo(),nuevaEscultura);
	}
	
	
	//Crear Fotografia
	public void crearFotografia(String titulo, int año, String lugarDeCreacion, boolean enExhibicion,
			String FechaSalidaGaleria, String EstadoActual, boolean ValorFijo,
			int ValorInicial, int ValorMinimo, int Valor, Comprador DueñoActual, int peso, String observacion,
			Autor autor, int resolucion, String tipo) {
		
		Fotografia nuevaFotografia = new Fotografia(titulo, año, lugarDeCreacion, enExhibicion,
				FechaSalidaGaleria, EstadoActual, ValorFijo,
				ValorInicial, ValorMinimo, Valor, DueñoActual,peso,observacion,
				autor, resolucion,tipo);
		this.inventarioHistorico.put(nuevaFotografia.getTitulo(),nuevaFotografia);
	}
	
	
	//Persistencia - Cargar Texto Plano
	public void cargarCompradores() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("compradores.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			System.out.println(datos[2]);
			this.crearComprador(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3]);
		}
	}
	
	
	public void cargarVideos() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("videos.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = this.crearRetornarAutor(datos[13]);
			
			this.crearVideo(datos[0], Integer.parseInt(datos[1]), datos[2], Boolean.parseBoolean(datos[3]),
					datos[4], datos[5], Boolean.parseBoolean(datos[6]),
					Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]), this.compradores.get(datos[10]), Integer.parseInt(datos[11]), datos[12],
					this.autores.get(nuevoAutor.getId()), Integer.parseInt(datos[14]), Integer.parseInt(datos[15]));
		}
	}
	
	public void cargarEsculturas() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("esculturas.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = this.crearRetornarAutor(datos[13]);
			
			this.crearEscultura(datos[0],Integer.parseInt(datos[1]),datos[2],Boolean.parseBoolean(datos[3]), 
		    		datos[4],datos[5],
		    		Boolean.parseBoolean(datos[6]),Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]),
		    		this.compradores.get(datos[10]), Integer.parseInt(datos[11]) , datos[12],this.autores.get(nuevoAutor.getId()),  Integer.parseInt(datos[14]), Integer.parseInt(datos[15]),
		    		Integer.parseInt(datos[16]), Boolean.parseBoolean(datos[17]), datos[18]);
		}
	}

	

	public void cargarPinturas() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("pinturas.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = this.crearRetornarAutor(datos[13]);
			
			this.crearPintura(datos[0],Integer.parseInt(datos[1]),datos[2],Boolean.parseBoolean(datos[3]), 
		    		datos[4],datos[5],
		    		Boolean.parseBoolean(datos[6]),Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]),
		    		this.compradores.get(datos[10]), Integer.parseInt(datos[11]) , datos[12],this.autores.get(nuevoAutor.getId()), datos[14],datos[15],
		    		Integer.parseInt(datos[16]), Integer.parseInt(datos[17]));
		}
	}
	

	public void cargarFotografia() {
		ArrayList<String> textos = ArchivoTextoPlano.cargar("fotografia.csv");
		for(String texto : textos) {
			String []datos = texto.split(";");
			Autor nuevoAutor = this.crearRetornarAutor(datos[13]);
			
			this.crearFotografia(datos[0],Integer.parseInt(datos[1]),datos[2],Boolean.parseBoolean(datos[3]), 
		    		datos[4],datos[5],
		    		Boolean.parseBoolean(datos[6]),Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]),
		    		this.compradores.get(datos[10]), Integer.parseInt(datos[11]) , datos[12],this.autores.get(nuevoAutor.getId()),
		    		Integer.parseInt(datos[14]), datos[15]);
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
