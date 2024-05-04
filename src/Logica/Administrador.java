package Logica;

import java.util.HashMap;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;


public class Administrador extends Usuario {
	
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
