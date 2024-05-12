package Logica;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;


public abstract class Pieza {
	protected String id;
    protected String titulo;
    protected int año;
    protected String lugarDeCreacion;
    protected boolean enExhibicion;
    protected String fechaEntradaGaleria;
    protected String fechaSalidaGaleria;
    protected String estadoActual;
    protected boolean valorFijo;
    protected int valorInicial;
    protected int valorMinimo;
    protected int valor;
    protected Comprador DueñoActual;
    protected Autor autor;
    private int peso;
    private String observacion;
    
    public Pieza(String titulo,int año,String lugarDeCreacion,boolean enExhibicion, 
    		String EstadoActual,
    		boolean ValorFijo,int ValorInicial,int ValorMinimo,int Valor,
    		Comprador DueñoActual, int peso,String observacion,Autor autor, String FechaSalidaGaleria) {

    	
    	this.id = "";
    	this.titulo= titulo;
    	this.año= año;
    	this.lugarDeCreacion= lugarDeCreacion;
    	
    	this.enExhibicion= enExhibicion;
    	
    	Date currentDate = new Date();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String dateString = formatter.format(currentDate);
    	
    	this.fechaEntradaGaleria= dateString;
    	
    	
    	this.fechaSalidaGaleria= FechaSalidaGaleria;
    	this.estadoActual= EstadoActual;
    	this.valorFijo= ValorFijo;
    	this.valorInicial= ValorInicial;
    	this.valorMinimo= ValorMinimo;
    	this.valor= Valor;
    	this.DueñoActual= DueñoActual;
    	this.peso=peso;
    	this.observacion=observacion;
    	this.autor=autor;
    }
    
    
//Getters
    public String getId() {
    	return id;
    }

    public String getTitulo() {
    	return titulo;
    }

    public int getAnio() {
    	return año;
    }

    public String getLugarDeCreacion() {
    	return lugarDeCreacion;
    }

    public boolean getEnExhibicion() {
    	return enExhibicion;
    }


    public String getFechaEntradaGaleria() {
    	return fechaEntradaGaleria;
    }

    public String getFechaSalidaGaleria() {
    	return fechaSalidaGaleria;
    }

    public String getEstadoActual() {
    	return estadoActual;
    }

    public boolean getValorFijo() {
    	return valorFijo;
    }

    public int getValorInicial() {
    	return valorInicial;
    }

    public int getValorMinimo() {
    	return valorMinimo;
    }

    public int getValor() {
    	return valor;
    }

    public Comprador getDueñoActual() {
    	return DueñoActual;
    }

    public int getPeso() {
		return peso;
	}
    public String getObservacion() {
		return observacion;
	}
    public Autor getAutor() {
    	return autor;
    }
    
    
    //Setters    
    
    public void setId(String id) {
    	this.id= id;
    }
    
    public void setTitulo(String titulo) {
    	this.titulo= titulo;
    }
    
    public void setAnio(int año) {
    	this.año= año;
    }
    
    public void setLugarDeCreacion(String lugarDeCreacion) {
    	this.lugarDeCreacion= lugarDeCreacion;
    }
    
    public void setEnExhibicion(boolean enExhibicion) {
    	this.enExhibicion= enExhibicion;
    }
    
    public void setFechaEntradaGaleria(String FechaEntradaGaleria) {
    	this.fechaEntradaGaleria= fechaEntradaGaleria;
    }
    
    public void getFechaSalidaGaleria(String FechaSalidaGaleria) {
    	this.fechaSalidaGaleria= fechaSalidaGaleria;
    }
    
    public void setEstadoActual(String EstadoActual) {
    	this.estadoActual= estadoActual;
    }
    
    public void setValorFijo(boolean getValorFijo) {
    	this.valorFijo= valorFijo;
    }
    
    public void setValorInicial(int ValorInicial) {
    	this.valorInicial= valorInicial;
    }
    
    public void setValorMinimo(int ValorMinimo) {
    	this.valorMinimo= valorMinimo;
    }
    
    public void setValor(int Valor) {
    	this.valor= valor;
    }
    
    public void setDueñoActual(Comprador DueñoActual) {
    	this.DueñoActual= DueñoActual;
    }
    public void setPeso(int peso) {
		this.peso=peso;
	}
    
    public void setObservacion(String observacion) {
		this.observacion=observacion;
	}
    
    public void Autor(Autor autor) {
    	this.autor=autor;
    }
    
    
    
}
