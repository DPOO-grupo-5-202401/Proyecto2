package Presentacion;

import java.util.Scanner;

public class Padministrador {
    public static void main(String[] args) {
		int op = 0;
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("\n");
	        System.out.println("*****Bienvenido Administrador*****");
			System.out.println("\n");
			System.out.println("Digite una opcion");
			System.out.println("0. Salir");
			System.out.println("1. Registrar Nuevo Comprador");
			System.out.println("2. Registrar Nueva Pieza");
			System.out.println("3. Vender Obra");
			System.out.println("4. Confirmar Venta Obra");
			System.out.println("5. Iniciar Subasta");
			op = sc.nextInt();
			try {
				if(op == 1) {
					System.out.println("Se han registrado 4 Compradores");
				}else if(op == 2) {

					System.out.println("Se han registrado 4 piezas");
				}else if(op == 3) {

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
    }




