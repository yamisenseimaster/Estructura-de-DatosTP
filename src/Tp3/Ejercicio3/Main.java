package Tp3.Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gps gps = new Gps(null, null);
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Agregar ruta");
            System.out.println("2. Deshacer ruta");
            System.out.println("3. Rehacer ruta");
            System.out.println("4. Ver ruta actual");
            System.out.println("5. Ver historial completo");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese origen:");
                    String origen = scanner.next();
                    System.out.println("Ingrese destino:");
                    String destino = scanner.next();
                    System.out.println("Ingrese distancia (km):");
                    double distancia = scanner.nextDouble();
                    Ruta ruta = new Ruta(origen, destino, distancia);
                    gps.agregarRuta(ruta);
                    break;
                case 2:
                    gps.deshacerRuta();
                    break;
                case 3:
                    gps.rehacerRuta();
                    break;
                case 4:
                    gps.verRutaActual();
                    break;
                case 5:
                    gps.verHistorialCompleto();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

}
