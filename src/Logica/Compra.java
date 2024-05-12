package Logica;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {
	public static int contadorCompras = 0;
    private String id;
    private String fecha;
    private int valor;
    private double impuestos;
    private Oferta ofertaValidada;
    
	public Compra(Oferta ofertaValidada) {
		String numero = String.format("%03d", contadorCompras);
		this.id = numero;
		contadorCompras++;
		
    	Date currentDate = new Date();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String dateString = formatter.format(currentDate);
    	
    	this.fecha = dateString;
    	
		this.valor = ofertaValidada.getPieza().getValor();
		this.impuestos = (valor * 0.19);
		
		this.ofertaValidada = ofertaValidada;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(int impuestos) {
		this.impuestos = impuestos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isValidado() {
		return validado;
	}
	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	public Oferta getOfertaValidada() {
		return ofertaValidada;
	}
	public void setOfertaValidada(Oferta ofertaValidada) {
		this.ofertaValidada = ofertaValidada;
	}
	public Empleado getEmpleado() {
		return empleado;
	}

}
