package Tp1.EjercicioFive;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//* Escribir un programa que tome dos arrays de caracteres y encuentre la intersección de ambos, insertándose
//* en un “ArrayList”. Entendiendo por “intersección” a los caracteres de un array que también se encuentran
//* en el otro. Los array se deben inicializar en la creación del objeto.
//* Indicaciones:
//* Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//* código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//* Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//* respecto del código que hace lo que se solicita en el ejercicio.
public class Caracteres {
    private ArrayList<Character> intersección; 

    public Caracteres(){
        this.intersección = new ArrayList<>();
    }

  
    public char[][] crearArreglos(Scanner scanner, String mensaje){
    
            System.out.println(mensaje);
            int tamanoArrglo1 = validación(scanner);
            int tamanoArrglo2 = validación(scanner);
            char[] miArreglo1 = new char[tamanoArrglo1];
            char[] miArreglo2 = new char[tamanoArrglo2];
            for (int i = 0; i < tamanoArrglo1; i++) {
                System.out.println("Ingresa el caracter "+(i+1));
                miArreglo1[i] = scanner.next().charAt(0);
            }
            for (int i = 0; i < tamanoArrglo2; i++) {
                System.out.println("Ingresa el caracter "+(i+1));
                miArreglo2[i] = scanner.next().charAt(0);
            }
            return new char [][] {miArreglo1, miArreglo2};
    }
    public int validación(Scanner scanner){
        int numero;
        while(true){
            try {
                numero = scanner.nextInt();
                if( numero <= 0){
                    System.out.println("Ingresa un numero mayor a 0");
                }else{
                    return numero;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un numero");
                scanner.next();
            }
        }
    }

    public void encontrarInterseccion(Scanner scanner){
        char [][] arreglos = crearArreglos(scanner, "Ingrese el tamaño de los arreglos:");
        char [] miArreglo1 = arreglos[0]; 
        char [] miArreglo2 = arreglos[1];
        
        for (char caracter : miArreglo1){
            for (char caracter2 : miArreglo2){
                if (caracter == caracter2 && !intersección.contains(caracter) ){
                    intersección.add(caracter);
                }
            }
        }
        System.out.println("La interseccion entre los dos arreglos es: ");
        for (char caracter : intersección){
            System.out.println(caracter + "");
        }
    }
    

}
