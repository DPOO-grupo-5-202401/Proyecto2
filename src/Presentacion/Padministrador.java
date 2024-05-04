package Presentacion;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import Logica.Administrador;
import Logica.Comprador;


public class Padministrador {
	private Administrador administrador;


	public Padministrador() {
		this.administrador = new Administrador("Juan", "A1", "A1");
		menu();
	}

	private void menu() {
			int op = 0;
			Scanner sc = new Scanner(System.in);
			do {
				
				System.out.println("\n");
		        System.out.println("*****Bienvenido Administrador*****");
				System.out.println("\n");
				System.out.println("Digite una opcion");
				System.out.println("0. Salir");
				System.out.println("1. Registrar Nuevo Comprador");
				System.out.println("2. Consultar Compradores");
				System.out.println("3. Registrar Nueva Pieza");
				System.out.println("4. Vender Obra");
				System.out.println("5. Confirmar Venta Obra");
				System.out.println("5. Verificar Comprador para Subasta");
				System.out.println("6. Iniciar Subasta");
				op = sc.nextInt();
				try {
					if(op == 1) {
						System.out.println("Digite nombre, numero de contacto, login y contraseña");
						String nombre = sc.next();
						int contacto = sc.nextInt();
						String login = sc.next();
						String contrasena = sc.next();
						administrador.crearComprador(nombre, contacto, contrasena, login);
						System.out.println("Comprador " + login + " creado con exito");
						
					}else if(op == 2) {
						
						HashMap<String, Comprador> map = administrador.getCompradores();
						
				        for (Entry<String, Comprador> entry : map.entrySet()) {
				            System.out.println(entry.getKey() + " : " + entry.getValue().getNombre());
				        }
				        
					}else if(op == 3) {
						int pieza = 0;
						do {
							System.out.println("Que tipo de Pieza desea registrar");
							System.out.println("1. Escultura");
							System.out.println("2. Pintura");
							System.out.println("3. Video");
							System.out.println("4. Fotografia");
							pieza = sc.nextInt();
							
							if
							
						}while(op != 0);
				

						
						
						
	
					}else if(op == 4) {
	
					}else if(op == 5) {
	
					}else if(op == 6) {
						
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
				
			}while(op != 0);
			sc.close();
		}
	
	
	
	
	
		public static void main(String[] args) {
			new Padministrador();
		}
}




