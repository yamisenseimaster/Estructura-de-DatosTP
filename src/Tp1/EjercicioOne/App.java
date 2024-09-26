package Tp1.EjercicioOne;

import java.util.Scanner;


public class App { 
    public static void main(String[] args) {
        //Creamos un objecto Vehiculo
        Vehiculo[] vehiculo = new Vehiculo[3];

        for (int i = 0; i < vehiculo.length; i++) {
            vehiculo[i] = new Vehiculo();
            vehiculo[i].solicitarDatos();
        }

        System.out.println("------ VEHICULOS ------");
        Vehiculo.mostrarVehiculos(vehiculo);
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        System.out.println("------ VEHICULOS POR MARCA ------");
        String marcaBuscada = input.nextLine();
        System.out.println("VEHICULOS QUE PERTENECEN A LA MARCA" + marcaBuscada);
        Vehiculo.mostrarVehiculosPorMarca(vehiculo, marcaBuscada);

        System.out.println("CATIDAD DE VEHICULOS POR TIPOS DE MOTOR");
        Vehiculo.contarTipoDeMotor(vehiculo);

    }
}


