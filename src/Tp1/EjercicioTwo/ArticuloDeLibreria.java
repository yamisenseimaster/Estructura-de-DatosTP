package Tp1.EjercicioTwo;

import java.util.InputMismatchException;
import java.util.Scanner;

//* Desarrollar una clase llamada " ArticuloDeLibreria". La clase debe contener los siguientes atributos:
//* "código", "nombre", "precio" y "cantidad". Se debe implementar los siguientes métodos:
//* a) Constructor predeterminado: inicializa el precio en 0 y la cantidad en 0.
//? b) depositarEnStock(cantidad): permite incrementar la cantidad de un artículo de la librería.
//? c) retirarDeStock(cantidad): permite reducir la cantidad de un artículo de la librería. Se debe verificar que
//? la cantidad a reducir sea menor o igual a la cantidad actual.
//? d) toString(): Devuelve un String con el código, nombre, precio y cantidad del artículo.
//? Se espera que el programa permita:
//? 1. Crear un artículo con código, nombre, precio y cantidad. Los datos deben ser ingresados por el usuario.
//? 2. Depositar una cantidad específica en el stock del artículo creado.
//? 3. Retirar una cantidad específica del stock del artículo creado.
//? 4. Mostrar la información del artículo.
//* Indicaciones:
//* Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//* código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//* Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//* respecto del código que hace lo que se solicita en el ejercicio.
public class ArticuloDeLibreria {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public ArticuloDeLibreria() {
        this.precio = 0;
        this.cantidad = 0;
    }

    public ArticuloDeLibreria(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void depositarEnStock(int cantidad) {
        this.cantidad += cantidad;

    }

    public void retirarDeStock(int cantidad) {
        if(this.cantidad >= cantidad){
            this.cantidad -= cantidad;

        }else{
            System.out.println("No hay suficiente stock");
        }
    }

    @Override
    public String toString() {
        return "ArticuloDeLibreria [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad="
                + cantidad + "]";
    }

    public void solicitarDatos(){
        Scanner input = new Scanner(System.in);

        this.setNombre(validacionCosole(input, "Ingrese el nombre: " ));
        this.setCodigo(validacionCosole(input, "Ingrese el codigo:  "));
        this.setCantidad(validarEntero(input, "Ingrese la cantidad que desea: "));
        this.setPrecio(validarEntero(input, "Ingrese el precio del Producto: "));

    }
    public static String validacionCosole(Scanner input, String mensaje){

        String valorIngresador;
        while(true){
            System.out.println(mensaje);

            //* */ El try declaración le permite definir un bloque de código a ser probado para errores mientras se está ejecutando.
            //* */ El catch declaración le permite definir un bloque de código para ejecutarse, si se produce un error en el bloque de prueba.
            //* */ El try y catch palabras clave ven en parejas:

            try{
                valorIngresador = input.nextLine();     //* trim() el método elimina el espacio en blanco de ambos extremos de una cadena.
                if(!valorIngresador.trim().isEmpty()){//*Empty() el método comprueba si la cadena de entrada está vacía o no. Tenga en cuenta que aquí vacío significa que el número de caracteres contenidos en una cadena es cero.
                    break;
                }
                else{
                    System.out.println("El valor no puede estar vacío. Intente de nuevo");
                }
            } catch(InputMismatchException e){
                System.out.println("Entrada invalida. Intente otra vez..");
            }catch(Exception e){
                System.out.println("Error");
            }
        }
        return valorIngresador;

    }

    public static int validarEntero(Scanner input, String mensaje){
        String valorIngresado;
        int numero;
        while(true){
            System.out.println(mensaje);
            try{
                valorIngresado = input.nextLine();
                numero = Integer.parseInt(valorIngresado);
                break;
            }catch(Exception e){
                System.out.println("Entrada invalida. Intente de nuevo");
            }
        }
        return numero;
    }
    //* 2. Depositar una cantidad específica en el stock del artículo creado.
    public void depositarStockEspecificada(int cantidad){
        Scanner deposito = new Scanner(System.in);
  
        int cantidadDepositar = validarEntero(deposito, "Ingrese la cantidad  que desea depositar en el producto creado" + this.nombre + ":");

        this.depositarEnStock(cantidadDepositar);


    }
    //* 3. Retirar una cantidad específica del stock del artículo creado.
    public void retirarStockEspecificada(int cantidad){
        Scanner retiro = new Scanner(System.in);


        int retirar = validarEntero(retiro, "Ingrese la cantidad que desea retirar: ");

        this.retirarDeStock(retirar);

    }

    //* 4. Mostrar la información del artículo.
     // Método para mostrar la información
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println();
    }

    
    
}
