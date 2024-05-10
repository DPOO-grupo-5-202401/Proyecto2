package Logica;

public class Compra {
    private String id;
    private String fecha;
    private int valor;
    private int impuestos;
    private String estado;
    private boolean validado;
    private Oferta ofertaValidada;
    private Empleado empleado;
    
	public Compra(String id, String fecha, int valor, int impuestos, String estado, boolean validado,
			Oferta ofertaValidada, Empleado empleado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.valor = valor;
		this.impuestos = impuestos;
		this.estado = estado;
		this.validado = validado;
		this.ofertaValidada = ofertaValidada;
		this.empleado = empleado;
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
