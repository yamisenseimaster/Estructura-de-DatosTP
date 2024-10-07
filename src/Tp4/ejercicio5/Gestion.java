package Tp4.ejercicio5;

import java.util.Scanner;

// Escribir un programa que realice la intercalación de los elementos de dos colas en una tercera cola. Las
// colas poseen números enteros. Mostrar los elementos de las tres colas y la suma de los elementos de la
// tercera cola.
// Indicaciones:
// Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
// código controle los problemas que normalmente ocurren al operar con la consola o teclado.
// Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
// respecto del código que hace lo que se solicita en el ejercicio.
public class Gestion {
    public static void main(String[] args) {
        Queue<Integer> cola1 = new Queue<>();
        Queue<Integer> cola2 = new Queue<>();
        Queue<Integer> cola3 = new Queue<>();

        Scanner  scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu de opciones:");
            System.out.println("1. Ingresar numeros en cola 1");
            System.out.println("2. Ingresar numeros en cola 2");
            System.out.println("3. Intercalar numeros en cola 3");
            System.out.println("4. Mostrar numeros de las colas");
            System.out.println("5. Calcular suma de numeros en cola 3");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarNumerocoCola1(cola1, scanner);
                    break;
                case 2:
                    ingresarNumerocoCola2(cola2, scanner);
                    break;
                case 3:
                    intercalarNumero(cola1,cola2, cola3);
                    break;
                case 4:
                    mostrarNumeros(cola1, cola2, cola3);
                    break;
                case 5:
                    mostrarSuma(cola3);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    
            }
            
        } while (opcion != 6);

    }

    private static void ingresarNumerocoCola1(Queue<Integer> cola1, Scanner scanner){
        System.out.println("Ingrese el numero de numeros que vamos agregar: ");
        int numero = scanner.nextInt();
        int i = 0;
        while (i < numero) {
            System.out.print("Ingrese elemento " + (i + 1) + ": ");
            int elemento = scanner.nextInt();
            cola1.add(elemento);
            i++;
        }
    }

    private static void ingresarNumerocoCola2(Queue<Integer> cola2, Scanner scanner){
        System.out.println("Ingrese el numero de numeros que vamos agregar: ");
        int numero = scanner.nextInt();
        int i = 0;
        while (i < numero) {
            System.out.print("Ingrese elemento " + (i + 1) + ": ");
            int elemento = scanner.nextInt();
            cola2.add(elemento);
            i++;
        }
    }
    private static void intercalarNumero(Queue<Integer> cola1, Queue<Integer> cola2, Queue<Integer> cola3) {
        while (!cola1.isEmpty() && !cola2.isEmpty()) {
            int num1 = cola1.pool();
            int num2 = cola2.pool();
            if (!cola3.contains(num1)) {
                cola3.add(num1);
            }
            if (!cola3.contains(num2)) {
                cola3.add(num2);
            }
        }
    }
    


    private static void mostrarNumeros(Queue<Integer> cola1, Queue<Integer> cola2, Queue<Integer> cola3) {
        System.out.println("Cola 1: " + cola1.toString());
        System.out.println("Cola 2: " + cola2.toString());
        System.out.println("Cola 3: " + cola3.toString());
    }

    private static void mostrarSuma(Queue<Integer> cola) {
        int suma = 0;
        for (int i = 0; i < cola.size(); i++) {
            suma += (int) cola.toArray()[i];
        }
        System.out.println("La suma de los elementos en cola 3 es: " + suma);
    }
}   
    

