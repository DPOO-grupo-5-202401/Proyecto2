package Presentacion;

import Logica.Empleado;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Pieza;
import Logica.Pintura;
import Logica.Video;
import Logica.Autor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pempleado {
    // Empleados
    private static Empleado[] empleados = {
        new Empleado("Maria", "E001", "maria", "password1", "Cajera"),
        new Empleado("Jose", "E002", "jose", "password2", "Administrador")
    };
    
    // Autores
    private static Autor[] autores = {
        new Autor("Pablo Picasso"),
        new Autor("Frida Kahlo"),
        new Autor("Vincent van Gogh")
    };

    // Inventario
    private static Map<String, Pieza> inventarioGlobal = Map.of(
        "E1", new Escultura("E1", "David", 1504, "Miguel Ángel", 2000000, "Mármol", 5, 2, 3, 1000, false),
        "F1", new Fotografia("F1", "Migrant Mother", 1936, "Dorothea Lange", 100000, "Blanco y negro"),
        "P1", new Pintura("P1", "La Noche Estrellada", 1889, "Vincent van Gogh", 2500000, "Óleo", 92, 73),
        "V1", new Video("V1", "The Clock", 2010, "Christian Marclay", 300000, 1440)
    );
    
    // Buscar un autor por nombre
    private static Autor buscarAutor(String nombre) {
        for (Autor a : autores) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }
    
    // Buscar empleado por login
    private static Empleado buscarEmpleado(String login, String contrasena) {
        for (Empleado e : empleados) {
            if (e.getLogin().equals(login) && e.getContrasena().equals(contrasena)) {
                return e;
            }
        }
        return null;
    }

    // Menú
    private static void mostrarMenuEmpleado() {
        System.out.println("\n***** Bienvenido Empleado *****");
        System.out.println("1. Ver historia de una pieza");
        System.out.println("2. Ver historia de un artista");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Historia de una pieza
    private static void verHistoriaPieza(Scanner scanner) {
        System.out.print("Ingrese el ID de la pieza: ");
        String idPieza = scanner.nextLine();

        Pieza pieza = inventarioGlobal.get(idPieza);
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

    // Historia de un artista
    private static void verHistoriaArtista(Scanner scanner) {
        System.out.print("Ingrese el nombre del artista: ");
        String nombreArtista = scanner.nextLine();

        Autor autor = buscarAutor(nombreArtista);
        if (autor != null) {
            System.out.println("\nMostrando historia del artista " + autor.getNombre() + ":");
            autor.getPiezasQueHaHecho().forEach((id, pieza) -> {
                System.out.println("ID: " + pieza.getId() + ", Título: " + pieza.getTitulo() + ", Año: " + pieza.getAnio() + ", Precio: " + pieza.getValor());
            });
        } else {
            System.out.println("No se encontró ningún artista con el nombre " + nombreArtista);
        }
    }

    // Menú interactivo para el empleado
    private static void menuEmpleado(Empleado empleado) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenuEmpleado();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    verHistoriaPieza(scanner);
                    break;
                case 2:
                    verHistoriaArtista(scanner);
                    break;
                case 3:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 3);
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido Empleado");
        System.out.print("Ingrese su login: ");
        String login = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Empleado empleado = buscarEmpleado(login, contrasena);
        if (empleado != null) {
            menuEmpleado(empleado);
        } else {
            System.out.println("Credenciales incorrectas. Intente nuevamente.");
        }
    }
}



