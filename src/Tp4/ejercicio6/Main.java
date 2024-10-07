package Tp4.ejercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        
        Gestion gestion = new Gestion();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar cliente a la cola inicial");
            System.out.println("2. Asignar trámite");
            System.out.println("3. Mostrar clientes atendidos");
            System.out.println("4. Mostrar clientes menores de 40 años atendidos en cajas");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el DNI del cliente:");
                    String dni = scanner.next();
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese la edad del cliente:");
                    int edad = scanner.nextInt();

                    Cliente cliente = new Cliente(dni, nombre, edad);
                    gestion.agregarClienteAColaInicial(cliente);
                    break;
                case 2:
                    gestion.asignarTramite();
                    break;
                case 3:
                    gestion.mostrarClientesAtendidos();
                    break;
                case 4:
                    gestion.mostrarClientesMenoresDe40EnCajas();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
