package Logica;

import java.util.HashMap;
import java.util.Random;

public class Autor extends Usuario {

	private String id;
    private HashMap<String, Pieza> piezasQueHaHecho;
    
    public Autor(String nombre) {
		super(nombre);
		this.piezasQueHaHecho = new HashMap<String,Pieza>();
		
    	Random random = new Random();
    	int randomNumber = random.nextInt(100) + 10;
    	this.id= "AU" + randomNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, Pieza> getPiezasQueHaHecho() {
		return piezasQueHaHecho;
	}

	public void setPiezasQueHaHecho(HashMap<String, Pieza> piezasQueHaHecho) {
		this.piezasQueHaHecho = piezasQueHaHecho;
	}


}
