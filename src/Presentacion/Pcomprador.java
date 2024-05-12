package Presentacion;

import Logica.Comprador;
import Logica.Pieza;
import Logica.Autor;
import Logica.Compra;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Pintura;
import Logica.Video;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Map;
import java.util.UUID;



public class Pcomprador {
    //compradores
    private static Comprador[] compradores = {
        new Comprador("Camilo", 1234567890, "password1", "camilo"),
        new Comprador("Javier", 1176543210, "password2", "javier")
    };
    
    //Autores
    private static Autor[] autores = {
            new Autor("Pablo Picasso"),
            new Autor("Frida Kahlo"),
            new Autor("Vincent van Gogh")
        };
    //Piezas
    private static Map<String, Pieza> inventarioGlobal = Map.of(
    		"E2", new Escultura()
    		
    		"E1", new Escultura("E1", 1504, "UK", false, "Disponible", 2000000, 1000000, 3000000, 50000, "Camilo", 200, "obs", "Pablo Picasso", "21-02-2022"),
            "E1", new Escultura("E1", "David", 1504, "Miguel Ángel", 2000000, "Mármol", 5, 2, 3, 1000, false),
            "F1", new Fotografia("F1", "Migrant Mother", 1936, "Dorothea Lange", 100000, "Blanco y negro"),
            "P1", new Pintura("P1", "La Noche Estrellada", 1889, "Vincent van Gogh", 2500000, "Óleo", 92, 73),
            "V1", new Video("V1", "The Clock", 2010, "Christian Marclay", 300000, 1440)
        );
    

    //Buscar un comprador por su login
    private static Comprador buscarComprador(String login, String contrasena) {
        for (Comprador c : compradores) {
            if (c.getLogin().equals(login) && c.getContrasena().equals(contrasena)) {
                return c;
            }
        }
        return null;
    }
    
    // Buscar un autor por nombre
    private static Autor buscarAutor(String nombre) {
        for (Autor a : autores) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

    //Menú principal
    private static void mostrarMenuComprador() {
    	System.out.println("\n");
        System.out.println("*****Bienvenido Comprador*****");
		System.out.println("\n");
		System.out.println("Digite una opcion");
        System.out.println("1. Ver historia de una pieza");
        System.out.println("2. Ver historia de un artista");
        System.out.println("3. Gestionar compra");
        System.out.println("4. Realizar compra");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Ver historia de una pieza
    private static void verHistoriaPieza(Comprador comprador) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la pieza: ");
        String idPieza = scanner.nextLine();
        
     // Buscar la pieza en el inventario
        Pieza pieza = comprador.getPiezasCompradas().get(idPieza);

        if (pieza != null) {
            System.out.println("Mostrando historia de la pieza:");
            System.out.println("ID: " + pieza.getId());
            System.out.println("Título: " + pieza.getTitulo());
            System.out.println("Año: " + pieza.getAnio());
            System.out.println("Autor: " + pieza.getAutor());
            System.out.println("Precio: " + pieza.getValor());
        } else {
            System.out.println("No se encontró ninguna pieza con el ID " + idPieza);
        }
    }

    // Ver historia de un artista
    private static void verHistoriaArtista(Comprador comprador) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del artista: ");
        String nombreArtista = scanner.nextLine();
        Autor autor = buscarAutor(nombreArtista);
        
        if (autor != null) {
            System.out.println("\nMostrando historia del artista " + autor.getNombre() + ":");
            for (Map.Entry<String, Pieza> entry : autor.getPiezasQueHaHecho().entrySet()) {
                Pieza pieza = entry.getValue();
                System.out.println("ID: " + pieza.getId() + ", Título: " + pieza.getTitulo() + ", Año: " + pieza.getAnio() + ", Precio: " + pieza.getValor());
            }
        } else {
            System.out.println("No se encontró ningún artista con el nombre " + nombreArtista);
        }
    }


    // Gestionar compras
    private static void gestionarCompras(Comprador comprador) {
    	Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n*** Gestión de Compras ***");
            System.out.println("1. Ver todas las compras");
            System.out.println("2. Ver detalles de una compra");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    verTodasLasCompras(comprador);
                    break;
                case 2:
                    verDetallesCompra(comprador, scanner);
                    break;
                case 3:
                    System.out.println("Saliendo de Gestión de Compras...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }
    
 // Ver todas las compras
    private static void verTodasLasCompras(Comprador comprador) {
        System.out.println("\nCompras realizadas:");
        for (Map.Entry<String, Compra> entry : comprador.getCompras().entrySet()) {
            Compra compra = entry.getValue();
            System.out.println("ID: " + compra.getId() + ", Fecha: " + compra.getFecha() + ", Estado: " + compra.getEstado());
        }
    }

    // Ver detalles de una compra
    private static void verDetallesCompra(Comprador comprador, Scanner scanner) {
        System.out.print("Ingrese el ID de la compra: ");
        String idCompra = scanner.nextLine();
        Compra compra = comprador.getCompras().get(idCompra);

        if (compra != null) {
            System.out.println("\nDetalles de la compra:");
            System.out.println("ID: " + compra.getId());
            System.out.println("Fecha: " + compra.getFecha());
            System.out.println("Valor: " + compra.getValor());
            System.out.println("Impuestos: " + compra.getImpuestos());
            System.out.println("Estado: " + compra.getEstado());
            System.out.println("Validado: " + (compra.isValidado() ? "Sí" : "No"));
            
        } else {
            System.out.println("No se encontró ninguna compra con el ID " + idCompra);
        }
    }
    
 // Realizar compra
    private static void realizarCompra(Comprador comprador) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la pieza que desea comprar: ");
        String idPieza = scanner.nextLine();
        Pieza pieza = inventarioGlobal.get(idPieza);

        if (pieza != null) {
            System.out.println("Pieza encontrada:");
            System.out.println("ID: " + pieza.getId());
            System.out.println("Título: " + pieza.getTitulo());
            System.out.println("Año: " + pieza.getAnio());
            System.out.println("Autor: " + pieza.getAutor());
            System.out.println("Precio: " + pieza.getValor());

            System.out.print("¿Desea comprar esta pieza? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                // Crear una nueva compra
                String idCompra = UUID.randomUUID().toString();
                String fecha = "2024-05-10"; 
                int valor = (int) pieza.getValor();
                int impuestos = (int) (valor * 0.15); 
                Compra compra = new Compra(null);

                // Registrar la compra
                comprador.registrarCompra(compra);
                comprador.agregarPiezaComprada(pieza);
                System.out.println("Compra realizada con éxito. ID de la compra: " + idCompra);
            } else {
                System.out.println("Compra cancelada.");
            }
        } else {
            System.out.println("No se encontró ninguna pieza con el ID " + idPieza);
        }
    }

    // Menú para comprador 
    private static void menuComprador(Comprador comprador) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nBienvenido " + comprador.getLogin());
            mostrarMenuComprador();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    verHistoriaPieza(comprador);
                    break;
                case 2:
                    verHistoriaArtista(comprador);
                    break;
                case 3:
                    gestionarCompras(comprador);
                    break;
                case 4:
                	realizarCompra(comprador);
                	break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        } while (opcion != 5);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido Comprador");
        System.out.print("Ingrese su login: ");
        String login = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Comprador comprador = buscarComprador(login, contrasena);

        if (comprador != null) {
            menuComprador(comprador);
        } else {
            System.out.println("Credenciales incorrectas. Intente nuevamente.");
        }
    }
}
