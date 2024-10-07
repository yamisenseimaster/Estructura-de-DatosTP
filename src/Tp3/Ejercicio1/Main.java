package Tp3.Ejercicio1;


import java.util.Scanner;

public class Main {

//     Escribir un programa en el que se inicie un arreglo con diez palabras relacionadas a la informática. De
// manera aleatoria, seleccionar cinco palabras del arreglo y guardarlas en una pila en el orden en que fueron
// seleccionadas. Luego, solicitar al usuario que ingrese N palabras, las cuales deberán ser eliminadas de la
// pila cuando existan en ella y conservar las demás sin perder el orden inicial.
// Por lo tanto, para cada una de las palabras ingresadas se debe verificar si está presente en la pila, en caso
// afirmativo, se la elimina. Para esto, deberá usar una pila auxiliar a fin de no perder elementos. El programa
// finaliza cuando se analizan las N palabras o cuando la pila haya quedado vacía. Además, debe informar
// cuantas palabras fueron eliminadas y mostrar las palabras que hayan quedado en la pila original (en caso
// que no haya quedado vacía).

    public static void main(String[] args) {
        Desarrollo run = new Desarrollo();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu de opciones:");
            System.out.println("1. Iniciar pila con palabras aleatorias");
            System.out.println("2. Eliminar palabras de la pila");
            System.out.println("3. Mostrar pila original");
            System.out.println("4. Mostrar pila final");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    run.iniciarPila();
                    break;
                case 2:
                    run.eliminarPalabras();
                    break;
                case 3:
                    run.mostrarPilaOriginal();
                    break;
                case 4:
                    run.mostrarPilaFinal();
                    break;
                case 5:
                    System.out.println("fin");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    

    

    
}