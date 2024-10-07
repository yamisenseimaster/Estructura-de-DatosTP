package Tp3.Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desarrollo {
    Helper vali = new Helper();
    
    Scanner sc = new Scanner(System.in);
    PilaGenerica<Integer> colaNumero = new PilaGenerica<>();

    /*IngresarDatos en tu ejemplo es un metodo que se encarga de ingresar y validar un número de cuatro cifras */
    public  int IngresarDatos(Scanner input){
        int numero = 0;
        while(true){//? while que se repite indefinidamente while true hasta que se ingrese un numero valido


            //*Try catch: se utiliza para manejar la excepcion InputMismatchException que se produce cuando el usuario ingresa algo que no es un numero entero*/
            try {
                System.out.println("Ingresar un numero de cuatro cifras");
                numero = input.nextInt();
                if (numero >= 1000 && numero <= 9999){
                    break;
                }else{
                    System.out.println("Invalido..  ingresar un numero de cuatro cifras");
                }
            } catch (InputMismatchException e) {//? Si se produce una excepcion InputMismatchException es decir si el usuario ingresa algo que no es un numero entero
                System.out.println("Invaido... debe ingresar un numero entero");
            }
        }
        return numero;//? Retorno del numero: Una vez que se ingresa un numero valido se devuelve el numero utilizando return numero
    }
    //*descompone un numero entero en sus digitos individuales y los almacena en una pila. */
    public  PilaGenerica<Integer> desconponerNumero(int numero){
        PilaGenerica<Integer> pila = new PilaGenerica<>();//?crea una instancia de una pila Pila<Integer> pila = new Pila<> que se utilizara para almacenar los numero individuales dados.
        for (int i = 0; i < 4; i++) {//? bucle FOR para iterar los 4 digitos
            int resultado = (numero%10);//? Esto devuelve el resto de la división entre el numero y 10
            pila.push(resultado);// ? se apila cada nuermos
            numero /= 10;   //? se divide el numero 10 para eliminar el menos significativo para la proxima iteracion
        }
        return pila;
    }

    //*El metodo tiene como objetivo invertir el orden de los digitos de un numero que se encuentra almacenado en una pila dinamica */
                                //? toma como parametro una pila de enteros y nos devuelve un entero
    public  int InvertirNumero(PilaGenerica<Integer> pila){
            int invertirNumero = 0; //? un entero que se utilizará para construir el número invertido
            int factor = 1;
            while (!pila.empty()){//?Mientras la pila no este vacía se ejecuta el bucle while
                invertirNumero += pila.pop() * factor;//? cada iteración del bucle se retira el elemento superior de la pila
                factor *= 10;//? se multiplica por 10 para la siguiente interacion.
            }
            return invertirNumero;//? caundo la pila ya este vacia nos retorna elvalor invertiNUmero numero ya invertido
    }


    public  void mostrarParesEImpares(int numero) {
        //. Estas variables se utilizarán para almacenar los digitos pares e impares
        String pares = "";
        String impares = "";
    
        for (int digito; numero > 0; numero /= 10) {//ejecutara mientras el numero sea mayor que 0
            digito = numero % 10;//el número se dividirá entre 10 y se truncara a un entero y elimina el resto
            
            //Verificamos si es par o impar 
            if (digito % 2 == 0) {
                pares += digito + " ";
            } else {
                impares += digito + " ";
            }
        }
    
        System.out.println(pares.isEmpty() ? "No hay digitos pares." : "Digitos pares: " + pares.trim());
        System.out.println(impares.isEmpty() ? "No hay digitos impares." : "Digitos impares: " + impares.trim());
    
    }

}
    
    