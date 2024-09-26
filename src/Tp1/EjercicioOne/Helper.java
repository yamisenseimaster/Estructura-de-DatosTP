package Tp1.EjercicioOne;

import java.util.Scanner;

public class Helper {

    public static String validacionString(Scanner input, String mensaje) {
        String valorIngresador;
        while (true) {
            System.out.println(mensaje);
            valorIngresador = input.nextLine();
            
            // Verificamos si el valor ingresado no está vacío
            if (!valorIngresador.trim().isEmpty()) { //* Trim y isEmpty: Se utiliza trim() para eliminar espacios en blanco antes y después de la entrada, y isEmpty() para verificar si la cadena resultante tiene longitud cero.
                break; // Salimos del bucle si la entrada es válida
            } else {
                System.out.println("ERROR: El valor no puede estar vacío. Intente de nuevo.");
            }
        }
        return valorIngresador; // Devolvemos el valor ingresado
    }
    
}
