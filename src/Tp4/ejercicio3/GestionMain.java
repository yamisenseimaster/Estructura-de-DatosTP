package Tp4.ejercicio3;

import java.util.Scanner;

public class GestionMain {


    public static void main(String[] args) {
        
        Queue<TrabajoImpresion> trabajosQueue = new Queue<>();
        Desarrallo gestDesarrallo = new Desarrallo();
        
        

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        int opcion;
        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Encolar trabajo de impresión");
            System.out.println("2. Desencolar trabajo de impresión");
            System.out.println("3. Mostrar trabajos impresos con cantidad de páginas mayor o igual a un valor");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestDesarrallo.encolarTrabajo(trabajosQueue, scanner);
                    break;
                case 2:
                    gestDesarrallo.desencolarTrabajo(trabajosQueue);
                    break;
                case 3:
                    gestDesarrallo.mostrarTrabajosImpresos(trabajosQueue, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }



        
    }
    

    
}
