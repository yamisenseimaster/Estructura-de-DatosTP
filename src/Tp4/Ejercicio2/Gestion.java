package Tp4.Ejercicio2;

import java.util.Scanner;

public class Gestion {
    // Implementar una clase “ColaCircular” que utilice un array para gestionar una cola de tamaño fijo de manera
    // circular que priorice velocidad.
    // Insertar números enteros en la cola. Verificar que la cola maneje correctamente las inserciones y
    // eliminaciones en caso de cola llena y cola vacía.
    // Indicaciones:
    // Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
    // código controle los problemas que normalmente ocurren al operar con la consola o teclado.
    // Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
    // respecto del código que hace lo que se solicita en el ejercicio.
    public static void main(String[] args) {
        ColaCircularGenerica<Integer> intEnteros = new ColaCircularGenerica<>();
        ColaCircularGenerica<Integer> auxiliar = new ColaCircularGenerica<>();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ingresar numero: ");
            System.out.println("2. Eliminar numero.");
            System.out.println("3. Imprimir cola.");
            System.out.println("4. Salir.");    
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un numero: ");
                    int numero = scanner.nextInt();
                    try {
                        intEnteros.add(numero);
                        System.out.println("Elemento insertado: " + numero);
                    } catch (IllegalStateException e) {
                        System.out.println("Cola llena...");
                        
                    }

                    break;
                case 2:
                    try {
                        Integer elemento = intEnteros.remove();
                        if (elemento != null){
                            System.out.println("Elemento eliminado: " + elemento);
                        }
                    } catch (IllegalStateException e) {
                        System.out.println("Cola vacia");
                    }
                    break;
                case 3:
                        System.out.print("Cola aquo: ");
                        while (!intEnteros.isEmpty()) {
                            Integer numeroGuar = (Integer) intEnteros.remove();
                            auxiliar.add(numeroGuar); 
                            System.out.print(numeroGuar + " ");
                        }
                        System.out.println();
                        break;
                case 4:
                        System.out.print("Cola auxiliar: ");
                        while (!auxiliar.isEmpty()) {
                            System.out.print(auxiliar.peek() + " ");
                            auxiliar.pool();
                        }
                        System.out.println();
                            System.exit(0);
                    break;
            }
        }
    }
}
