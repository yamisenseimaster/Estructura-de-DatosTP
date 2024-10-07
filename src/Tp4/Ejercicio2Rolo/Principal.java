package Tp4.Ejercicio2Rolo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Creo una instancia de ColaCircular con el tamaño predeterminado
        ColaCircular<Integer> cola = new ColaCircular<>();
        Scanner entrada = new Scanner(System.in);
        
        int opcion;
        do {
            // Mostrar el menú de opciones
            System.out.println("Menu");
            System.out.println("1. Agregar numero");
            System.out.println("2. Eliminar numero");
            System.out.println("3. Recorrer la cola");
            System.out.println("4. Salir");
            
            opcion = Helper2.validarEntero(entrada, "Ingrese una opcion: ");
            
            switch (opcion) {
                case 1:
                    if (!cola.isFull()) {
                        int numero = Helper2.validarEntero(entrada, "Ingrese un numero: ");
                        cola.add(numero);
                        System.out.println("Numero agregado.");
                    } 
                    else {
                        System.out.println("La cola está llena.");
                    }
                    break;
                
                case 2:
                    if (!cola.isEmpty()) {
                        int eliminado = cola.remove();
                        System.out.println("Numero eliminado: " + eliminado);
                    } 
                    else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
                
                case 3:
                    if (cola.isEmpty()) {
                        System.out.println("La cola está vacía.");
                    } 
                    else {
                        System.out.println("Elementos en la cola:");
                        recorrerCola(cola);
                    }
                    break;
                
                case 4:
                    System.out.println("FIN");
                    break;
                
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        } while (opcion != 4);
        
    }
    
    private static void recorrerCola(ColaCircular<Integer> cola) {
        ColaCircular<Integer> colaAuxiliar = new ColaCircular<>(cola.size() + 1);
        
        while (!cola.isEmpty()) {
            int numero = cola.remove();
            System.out.println(numero);
            colaAuxiliar.add(numero); 
        }
        
        while (!colaAuxiliar.isEmpty()) {
            cola.add(colaAuxiliar.remove());
        }
    }
}
