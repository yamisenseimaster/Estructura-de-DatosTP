package Tp1.EjercicioSIx;

import java.util.Arrays;
import java.util.Scanner;

//* Escribir un programa que permita ingresar de manera aleatoria números a una matriz M x N. Los valores M
//* y N son indicados por el usuario. Se debe mostrar la matriz en la consola. Además, crear un método que
//* reciba un número como parámetro y devuelva la posición en la que dicho número se encuentra. Si el
//* número no existe se devuelve el mensaje “Número no encontrado”. Escribir otro método que reciba como
//* parámetro una posición de la matriz y el String “izquierda” o “derecha”, el método debe devolver los
//* números que se encuentran a la izquierda o derecha de la posición indicada. En caso de que la posición
//* indicada sea uno de los bordes laterales y no haya números a mostrar se devuelve el mensaje “No hay
//* números a la derecha/izquierda de la posición indicada”.
//* Indicaciones:
//* Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//* código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//* Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//* respecto del código que hace lo que se solicita en el ejercicio.
public class Matriz {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int fila = Helper.validaciónEntero( entrada , "ingrese el numero de fila");
        int columna = Helper.validaciónEntero( entrada , "ingrese el numero de columna");
        int [][] matriz = generarMatriz(fila, columna);
        imprimirMatriz(matriz);

        int numeroBuscado = Helper.validaciónEntero(entrada, "Elija un numero: ");
        int[] ubicacion = obtenerUbicacion(numeroBuscado, matriz);
        if (ubicacion != null) {
            imprimirUbicacion(numeroBuscado, ubicacion);
            String direccion = Helper.validarstring(entrada, "De que direccion obtener los numeros? (izq / der)");
            String numerosEncontrados = obtenerNumeroPorDireccion(direccion, numeroBuscado, matriz, ubicacion);
            System.out.println(numerosEncontrados);
        } else {
            System.out.println("Numero no encontrado");
        }
    }
    //? STACTIC:El método pertenece a la clase y no a una instancia particular de la clase.
    public static int [][] generarMatriz(int nFilas, int nColunas){
        int [][] matriz = new int[nFilas][nColunas];
        for (int f = 0; f < nFilas; f++){
            int[] fila = new int[nColunas];
            for (int c = 0; c < nColunas; c++){
                fila[c] = generarNumeros(c);
            }
            matriz[f] = fila;
        }
        return matriz;  
    }
    public static int generarNumeros(int alterar) {
        return (int) (Math.random() * (40 + alterar));
    }
    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("Matriz generada de " + matriz.length + "x" + matriz[0].length);
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
    }
    public static void imprimirUbicacion(int numero, int[] ubicacion) {
        System.out.print("El numero " + numero + " se encuentra en: ");
        System.out.println("(" + ubicacion[0] + ", " + ubicacion[1] + ")");
    }
    public static boolean[] devolverSiEsLimite(int[] ubicacion, int[][] matriz) {
        boolean[] limites = {false, false};

        if (ubicacion[0] == 0) {
            limites[0] = true; // limite izquierdo (primer elemento)
        }

        if (ubicacion[0] == (matriz[0].length - 1)) {
            limites[1] = true; // limite derecho (ultimo elemento)
        }


        return limites;
    }
    public static String obtenerNumeroPorDireccion(String direccion, int numero, int[][] matriz, int[] ubicacion) {
        String numerosEncontrados = "Numeros encontrados: ";
        direccion = direccion.toLowerCase().substring(0, 3);
        boolean[] limites = devolverSiEsLimite(ubicacion, matriz);
        // int[] ubicacion = obtenerUbicacion(numero, matriz);

        if ((limites[0] && direccion.equals("izq")) || (limites[1] && direccion.equals("der"))) {
            return "No hay numeros a la derecha/izquierda de la posicion indicada";
        }

        if (direccion.equals("izq")) {
            for (int i = 0; i < ubicacion[0]; i++) {
                numerosEncontrados += matriz[ubicacion[1]][i] + " ";
            }
        } else if (direccion.equals("der")) {
            for (int i = ubicacion[0] + 1; i < matriz[ubicacion[1]].length; i++) {
                numerosEncontrados += matriz[ubicacion[1]][i] + " ";
            }
        } else {
            return "direccion invalida";
        }

        return numerosEncontrados;
    }
    public static int[] obtenerUbicacion(int numero, int[][] matriz) {
        int[] ubicacion = new int[2];

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                if (matriz[f][c] == numero) {
                    ubicacion[0] = c;
                    ubicacion[1] = f;
                    return ubicacion;
                }
            }
        }
        return null;
    }
}
