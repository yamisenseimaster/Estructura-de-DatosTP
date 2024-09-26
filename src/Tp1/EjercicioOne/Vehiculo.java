package Tp1.EjercicioOne;

import java.util.Scanner;

public class Vehiculo {
    //* siguientes atributos */
    private String marca;
    private String modelo;
    private String tipoDeMotor;
  

    //* Constructor predeterminado */
    public Vehiculo(){
        this.marca = "Desconocido";
        this.modelo = "Sin Modelo";
        this.tipoDeMotor =  "Ninguno";
    }

    //* Constructor con argumentos */
    public Vehiculo(String marca, String modelo, String tipoDeMotor){
        this.marca = marca;
        this.modelo = modelo;
        this.tipoDeMotor = tipoDeMotor;
 
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getTipoDeMotor() {
        return tipoDeMotor;
    }
    public void setTipoDeMotor(String tipoDeMotor) {
        this.tipoDeMotor = tipoDeMotor;
    }

    public Vehiculo(String modelo, String marca){
        this.modelo = modelo;
        this.marca = marca;

     }
    public void mostrarInformacion(){
        System.out.println("Nombre de la Marca del Vehiculo:" + marca);
        System.out.println("Nombre del Modelo:" + modelo);
        System.out.println("El tipo de motor es (DIESEL / NAFTERO):" + tipoDeMotor);
    }
    //* toString(): Devuelve un String con la marca, el modelo del vehículo y el tipo de motor */
    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", tipoDeMotor=" + tipoDeMotor + "]";
    }


     //* Métodos para la entrada de datos y creación de objetos *//
    public static String validacionString(Scanner input, String mensaje) {
        String valorIngresador;
        while (true) {
            System.out.println(mensaje);
            valorIngresador = input.nextLine();
            
            //* Verificamos si el valor ingresado no está vacío
            if (!valorIngresador.trim().isEmpty()) {
                break; //*  Salimos del bucle si la entrada es válida
            } else {
                System.out.println("ERROR: El valor no puede estar vacío. Intente de nuevo.");
            }
        }
        return valorIngresador; //* Devolvemos el valor ingresado
    }

    public void solicitarDatos(){

        Scanner input = new Scanner(System.in);

        this.setMarca(validacionString(input, "Ingresa la marca"));

        this.setModelo(validacionString(input, "Ingresa el modelo"));

        this.setTipoDeMotor(validacionString(input, "Ingresa el tipo de motor (DIESEL / NAFTERO)"));
    }
    
    public boolean perteneceMarca(String marcaBuscada){
        return this.marca.equals(marcaBuscada);
    }

    public static void mostrarVehiculos(Vehiculo[] vehiculos){
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
            System.out.println();
        }
    }
    
    public static void mostrarVehiculosPorMarca(Vehiculo[] vehiculos, String marcaBuscada){
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.perteneceMarca(marcaBuscada)){
                vehiculo.mostrarInformacion();
                System.out.println();
            }
        }
    }
    public static void contarTipoDeMotor(Vehiculo[] vehiculos){
        int nafteros = 0;
        int diesel = 0;
        for (Vehiculo vehiculo : vehiculos){
            if(vehiculo.getTipoDeMotor().equals("naftero")){
                nafteros++;
            }
            else if (vehiculo.getTipoDeMotor().equals("diesel")){
                diesel++;
            }
        }
        System.out.println("En la base de datos hay " + nafteros + " nafteros y " + diesel + " diesel");
    }




    
    
    
}
