package Tp1.EjercicioSIx;

import java.util.Scanner;

public class Helper {


    public static int validaciónEntero(Scanner entrada, String mensaje){
        int numero;
        String ValorIngresado;
        while (true) {
            try {
                System.out.println("Por favor ingrese un numero entero: ");
                ValorIngresado = entrada.nextLine();
                numero = Integer.parseInt(ValorIngresado);
                break;
            } catch (Exception e) {
                System.out.println("ERROR ingrese otra ves");
            }
        }
        return numero;
        
    }
    public static   String validarstring(Scanner entrada, String mensaje){
        String valorIngresado;
        while (true) {
            try {
                System.out.println("Por favor ingrese un numero entero: ");
                valorIngresado = entrada.nextLine().trim();
                if(!valorIngresado.isEmpty()){
                    return valorIngresado;
                }else{
                    System.out.println("ERROR ingrese otra ves");
                }
            } catch (Exception e) {
                System.out.println("ERROR ingrese otra ves");
            }
        }
    }

}
