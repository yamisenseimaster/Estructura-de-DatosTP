package Tp2.Ejercicio3;

//* Desarrollar un programa que encuentre el valor máximo y el valor mínimo mínimo en un array de enteros y,
//* a continuación, los muestre por pantalla. El array se debe completar con números generados de forma
//* aleatoria.
//* Indicaciones:
//* Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//* código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//* Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//* respecto del código que hace lo que se solicita en el ejercicio.
public class ValorMaxMin{
    public static void main(String[] args) {
        int [] numero ={9,10,21,2,5,7,13,5,6};//inicializar


        int valorMaximo = numero[0];
        int valorMinimo = numero[0];

        for (int i = 0; i < numero.length; i++) {
            if (numero[i] > valorMaximo){
                valorMaximo = numero[i];
            }
            if(numero[i]< valorMinimo){
                valorMinimo = numero[i];
            }
        }
        System.out.println("El valor maximo es: "+ valorMaximo);
        System.out.println("El valor minimo es: "+ valorMinimo);
    }

}
