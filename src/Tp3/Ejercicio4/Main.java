package Tp3.Ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NavegacionWeb web = new NavegacionWeb();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Agregar sitio web al historial");
                System.out.println("2. Recorrer el historial de navegación");
                System.out.println("3. Mostrar total de sitios web visitados");
                System.out.println("4. Salir");
                System.out.print("Ingrese su opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        web.agregarSitioWeb();
                        break;
                    case 2:
                        web.recorrerHistorial();
                        break;
                    case 3:
                        web.mostrarTotalSitiosWeb();
                        break;
                    case 4:
                        System.out.println("Adiós!");
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
                }
            }
        }




    }
}
