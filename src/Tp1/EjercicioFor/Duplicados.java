package Tp1.EjercicioFor;

import java.util.Scanner;

//* */ Escribir un programa que verifique si hay elementos duplicados en un array de enteros y los muestre por
//* */ pantalla. El array se debe completar con 10 números ingresados por teclado.
//* */ Indicaciones:
//* */ Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//* */ código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//* */ Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//* */ respecto del código que hace lo que se solicita en el ejercicio.
public class Duplicados {
    public static void main(String[] args) {
        
        int [] numeros = new int[10];//arreglo de 10

        System.out.println("Por favor ingrese los 10 numeros");

        for (int i = 0; i < numeros.length; i++){
             numeros[i] = solicitaNumero("Ingrese los numeros" + (i+1) );
        }
        mostrarNumerosDuplicados(numeros);
        

    }


    

    public static int solicitaNumero(String mensaje){
        return validacion(new Scanner(System.in), mensaje);
    }


    public static int validacion(Scanner input, String mensaje){
        int numero;
        String valorIngresado;
        while(true){
            try{
                System.out.println(mensaje + ": ");
                valorIngresado = input.nextLine();
                numero = Integer.parseInt(valorIngresado);
                break;
            }catch( Exception e){
                System.out.println("Entrada invalida. Intente de nuevo");
            }
        }
        return numero;
    }
    public static void mostrarNumerosDuplicados(int[] numeros){
        System.out.println("Numeros ingresado son: ");
        for (int i = 0; i<numeros.length; i++){
            System.out.println(numeros[i]);
        }
        System.out.println("");

        System.out.println("Numeros duplicados son: ");
        boolean[] visto = new boolean[numeros.length];
        for (int i = 0; i<numeros.length; i++){
            if(!visto[i]){
                int contador = 0;
                for (int j = 0; j < numeros.length; j++){
                    if(numeros[i] == numeros[j]){
                        contador++;
                        visto[j] = true;
                    }
                }
                if ( contador > 1){
                    System.out.println(numeros[i] + " La veces que se repite son: " + contador) ;
                }
            }
            
        }
    }
    
    
}


