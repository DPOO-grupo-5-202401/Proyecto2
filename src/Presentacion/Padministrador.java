package Presentacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import Logica.Administrador;
import Logica.Autor;
import Logica.Compra;
import Logica.Comprador;
import Logica.Oferta;
import Logica.Pieza;


public class Padministrador {
	private Administrador administrador;


	public Padministrador() {
		this.administrador = new Administrador("Juan", "A1", "A1");
		administrador.cargarCompradores();
		administrador.cargarVideos();
		administrador.cargarEsculturas();
		administrador.cargarPinturas();
		administrador.cargarFotografias();
		administrador.cargarOfertas();
		administrador.cargarCompras();
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
				System.out.println("6. Guardar Datos");
				System.out.println("7. Crear Oferta");
				System.out.println("8. Consultar Ofertas");
				System.out.println("9. Confirmar Venta Obra");
				System.out.println("10. Consultar Ventas");
				System.out.println("11.Consultar Historia Pieza");
				System.out.println("12.Consultar Historia Artista");
				System.out.println("13.Consultar Historia Comprador");
				System.out.println("14. Verificar Comprador para Subasta");
				System.out.println("15. Iniciar Subasta");
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
								administrador.crearEscultura("hola", 2023, "Colombia", false,"2025-05-05", "ParaVenta", true, 50, 0, 0, administrador.compradores.get("Galeria"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) , 5, 10, 10, false, "Piedra");
								System.out.println("Escultura Creada!");
								break;
							}

							
							else if (intpieza == 2) {
								Autor nuevoAutor = administrador.crearRetornarAutor("William");
								administrador.crearPintura("Hola", 2023, "Colombia", false,"2025-05-05", "ParaVenta", true, 50, 0, 0, administrador.compradores.get("Galeria"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) , "Al Oleo", "Vanguardismo", 50,60);
								System.out.println("Pintura Creada!");

								break;
								
							}
							
							else if (intpieza == 3) {
								Autor nuevoAutor = administrador.crearRetornarAutor("William");
								administrador.crearVideo("holaVideo", 2023, "Colombia", false,"2025-05-05", "EnVenta", true, 50, 0, 0, administrador.compradores.get("Galeria"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) ,1920,60);
								System.out.println("Video Creado!");
								break;
								
							}
							
							else if (intpieza == 4) {
								Autor nuevoAutor = administrador.crearRetornarAutor("William");
								administrador.crearFotografia("holaFoto", 2023, "Colombia", false,"2025-05-05", "EnVenta", true, 50, 0, 0, administrador.compradores.get("Galeria"), 90, "Sin Observacion",administrador.autores.get(nuevoAutor.getNombre()) , 1920, "Analoga");
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
				            System.out.println(entry.getValue().getId() + ":" + entry.getKey() + " por " + entry.getValue().getAutor().getNombre() + ". ESTADO: " + entry.getValue().getEstadoActual());
				        }
	
					}else if(op == 5) {
						administrador.cargarCompradores();
						administrador.cargarVideos();
						administrador.cargarEsculturas();
						administrador.cargarPinturas();
						administrador.cargarFotografias();
									
	
					}else if(op == 6) {
						
						administrador.almacenarCompradores();
						administrador.almacenarVideos();
						administrador.almacenarEsculturas();
						administrador.almacenarPinturas();
						administrador.almacenarFotografias();
						
					}else if(op == 7) {
						Oferta nuevaOferta = administrador.crearRetornarOferta(administrador.compradores.get("Olivi0"), administrador.inventarioHistorico.get("holaVideo"));
						if (nuevaOferta == null) {
							System.out.println("La oferta no pudo ser creada, verifica si la pieza si esta disponible para compra");
						}else {
							System.out.println("La oferta ha sido creada exitosamente, adquiriras la pieza cuando un administrador verifique tu compra");
						}
						
					}else if(op == 8) {
						HashMap<String, Oferta> map = administrador.getOfertas();
						
				        for (Entry<String, Oferta> entry : map.entrySet()) {
				            System.out.println(entry.getKey() + ": " + entry.getValue().getPieza().getTitulo() + ". Comprada Por: " + entry.getValue().getComprador().getNombre() + " - " + entry.getValue().isValidada());
				        }
						
					}else if(op == 9) {
						Compra nuevaCompra = administrador.crearRetornarCompra(administrador.ofertas.get("101"));
						
						
						
					}else if(op == 10) {
						HashMap<String, Compra> map = administrador.getCompras();
						
				        for (Entry<String, Compra> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getId() + ": " + entry.getValue().getOfertaValidada().getPieza().getTitulo() + ". Comprada Por: " + entry.getValue().getOfertaValidada().getComprador().getNombre());
				        }
				        
				        
					}else if(op == 11) {
						
				        List<Compra> lista = administrador.compras.get("101").getOfertaValidada().getPieza().getHistoriaPieza();
				        for (int i = 0; i < lista.size(); i++) {
				            System.out.println(lista.get(i).getId() + ": " + lista.get(i).getOfertaValidada().getPieza().getTitulo() + ". Comprada Por: " + lista.get(i).getOfertaValidada().getComprador().getNombre());
				        }
					}else if(op == 12) {
				
						
						Scanner scanner = new Scanner(System.in);
						System.out.println("Nombre del artista a Consultar");
						String artista = scanner.nextLine();
						
						HashMap<String, Pieza> map = administrador.autores.get(artista).getPiezasQueHaHecho();
				        for (Entry<String, Pieza> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getTitulo() + ". Año: " +entry.getValue().getAnio() + ". Fecha de Compra: " + entry.getValue().getHistoriaPieza().get(0).getFecha() + ". Valor Compra: " + entry.getValue().getHistoriaPieza().get(0).getValor());
				        }
					}else if(op == 13) {
				
						
						Scanner scanner = new Scanner(System.in);
						System.out.println("Login del Comprador a consultar");
						String comprador = scanner.nextLine();
						
						HashMap<String, Pieza> map = administrador.compradores.get(comprador).getPiezasqueHaTenido();
				        for (Entry<String, Pieza> entry : map.entrySet()) {
				            System.out.println(entry.getValue().getTitulo() + ". Año: " +entry.getValue().getAnio() + ". Fecha de Compra: " + entry.getValue().getHistoriaPieza().get(0).getFecha() + ". Valor Compra: " + entry.getValue().getHistoriaPieza().get(0).getValor());
				        }
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




