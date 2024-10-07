package Tp4.ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear la cola general de visitantes
        Queue<Visitante> colaGeneral = new Queue<>();

        // Crear las colas específicas para cada juego
        Queue<Visitante> colaMontaniaRusa = new Queue<>();
        Queue<Visitante> colaCalesita = new Queue<>();
        Desarrollo funciones = new Desarrollo();

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Ingresar visitantes a la cola general");
            System.out.println("2. Transferir visitantes a las colas específicas");
            System.out.println("3. Mostrar la cantidad de visitantes menores de edad");
            System.out.println("4. Mostrar la cantidad de visitantes que ingresaron en cada juego");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    funciones.ingresarVisitantes(colaGeneral, scanner);
                    break;
                case 2:
                    funciones.transferirVisitantes(colaGeneral, colaMontaniaRusa, colaCalesita);
                    break;
                case 3:
                    funciones.mostrarMenoresDeEdad(colaCalesita);
                    break;
                case 4:
                    funciones.mostrarVisitantesPorJuego(colaMontaniaRusa, colaCalesita);
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 5);
    }
}
