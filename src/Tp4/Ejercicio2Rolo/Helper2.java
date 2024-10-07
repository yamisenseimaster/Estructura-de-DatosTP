package Tp4.Ejercicio2Rolo;


import java.util.Scanner; 

public class Helper2 {
    // Validar entero
    public static int validarEntero(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(entrada.nextLine());
                break;  
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero.");
            }
        }
        return numero;
    }
}