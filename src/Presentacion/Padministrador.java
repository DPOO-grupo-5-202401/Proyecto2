package Presentacion;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import Logica.Administrador;
import Logica.Autor;
import Logica.Comprador;
import Logica.Pieza;


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
				System.out.println("4. Consultar Piezas");
				System.out.println("5. Cargar Datos");
				System.out.println("6. Vender Obra");
				System.out.println("7. Confirmar Venta Obra");
				System.out.println("8. Verificar Comprador para Subasta");
				System.out.println("9. Iniciar Subasta");
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
						int intpieza = 0;
						do {
							System.out.println("Que tipo de Pieza desea registrar");
							System.out.println("1. Escultura");
							System.out.println("2. Pintura");
							System.out.println("3. Video");
							System.out.println("4. Fotografia");
							System.out.println("5. Regresar al Menu Principal");
							intpieza = sc.nextInt();
							
							if (intpieza == 1) {
								Autor nuevoAutor = administrador.crearRetornarAutor("William");
								administrador.crearEscultura("hola", 2023, "Colombia", false,"2025-05-05", "ParaVenta", true, 50, 0, 0, administrador.compradores.get("WILLIAM"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getId()) , 5, 10.4, 10.5, false, "Piedra");
								System.out.println("Escultura Creada!");
								break;
							}

							
							else if (intpieza == 2) {
								Autor nuevoAutor = administrador.crearRetornarAutor("William");
								administrador.crearPintura("Hola", 2023, "Colombia", false,"2025-05-05", "ParaVenta", true, 50, 0, 0, administrador.compradores.get("WILLIAM"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getId()) , "Al Oleo", "Vanguardismo", 50,60);
								System.out.println("Pintura Creada!");

								break;
								
							}
							
							else if (intpieza == 3) {
								Autor nuevoAutor = administrador.crearRetornarAutor("William");
								administrador.crearVideo("holaVideo", 2023, "Colombia", false,"2025-05-05", "EnVenta", true, 50, 0, 0, administrador.compradores.get("WILLIAM"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getId()) ,1920,60);
								System.out.println("Video Creado!");
								break;
								
							}
							
							else if (intpieza == 4) {
								Autor nuevoAutor = administrador.crearRetornarAutor("William");
								administrador.crearFotografia("holaFoto", 2023, "Colombia", false,"2025-05-05", "EnVenta", true, 50, 0, 0, administrador.compradores.get("WILLIAM"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getId()) , 1920, "Analoga");
								System.out.println("Pieza Creada!");
								break;
								
								
							}
							
							else if (intpieza == 5) {	
								break;
							}
							
							
							
						}while(intpieza != 0);
						
	
					}else if(op == 4) {
						
						HashMap<String, Pieza> map = administrador.getInventarioHistorico();
						
				        for (Entry<String, Pieza> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getId() + ":" + entry.getKey() + " por " + entry.getValue().getAutor().getNombre());
				        }
	
					}else if(op == 5) {
						administrador.cargarCompradores();
						administrador.cargarVideos();
	
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




