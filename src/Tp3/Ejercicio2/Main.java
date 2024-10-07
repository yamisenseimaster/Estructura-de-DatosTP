package Tp3.Ejercicio2;

import java.util.Scanner;

public class Main {

//     Escribir un programa que permita al usuario ingresar un número entero de cuatro cifras. Se debe validar
// que el número ingresado tenga exactamente cuatro cifras. Descomponer el número en dígitos y cargarlos
// en una pila. Luego, quitar los dígitos de la pila y formar un nuevo número de cuatro cifras (el número
// original al revés).
// Por ejemplo, si el usuario ingresa el número 5432, se debe descomponerlo y cargar cada dígito en la pila.
// Para este caso, se apilarían en el siguiente orden: 5, 4, 3 y 2. Al quitar los números de la pila se debe
// componer el número entero 2345. Además, mostrar los dígitos pares e impares del número original.
    public static void main(String[] args) {
        
     Desarrollo desarrollo = new Desarrollo();
     Scanner scanner = new Scanner(System.in);//  leer entrada del usuario desde la consola
        int numero = desarrollo.IngresarDatos(scanner);

        PilaGenerica<Integer> pila = desarrollo.desconponerNumero(numero);//llama al método IngresarDatos y asigna el nmero entero ingresado por el usuario a la variable 

        int numeroInver = desarrollo.InvertirNumero(pila);// llama al método InvertirNumero y asigna el número invertido a la variable 

        System.out.println("Numero original: " + numero);
        System.out.println("Numero invertido: " + numeroInver);
        desarrollo.mostrarParesEImpares(numero);

    }
}

