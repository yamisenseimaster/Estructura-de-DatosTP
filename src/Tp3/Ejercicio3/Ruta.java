package Tp3.Ejercicio3;
// Crear un programa para el sistema de manejo de rutas en un GPS utilizando una estructura de datos pila.
// Este sistema debe permitir a los usuarios agregar nuevas rutas, deshacer la última ruta agregada, rehacer
// una ruta deshecha y visualizar la ruta actual. También debe existir la opción para ver el historial completo
// de las rutas.
// Se deben implementar las siguientes clases:
// Clase Ruta
// Atributos: origen, destino y distancia de la ruta (kilómetros).
// Métodos: constructor para inicializar los atributos y método toString() para representar la información de la
// ruta como una cadena.
// Clase GPS
// Atributos:
// pilaRutas: pila que almacena las rutas actuales.
// pilaDeshacer: pila que almacena las rutas deshechas.
// Métodos:
// agregarRuta(Ruta ruta): añade una nueva ruta a la pila de rutas.
// deshacerRuta(): quita la última ruta agregada a pilaRutas y la agrega a pilaDeshacer.
// rehacerRuta(): quita la última ruta agregada a pilaDeshacer y la agrega a pilaRutas.
// verRutaActual(): muestra la última ruta agregada a pilaRutas.
// verHistorialCompleto(): imprime todas las rutas agregadas a pilaRutas en el orden de adición.
// Indicaciones:
// Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
// código controle los problemas que normalmente ocurren al operar con la consola o teclado.
// Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
// respecto del código que hace lo que se solicita en el ejercicio.
public class Ruta {
    private String origen;
    private String destino;
    private double distancia;

    
    public Ruta() {

    }

    public Ruta(String origen, String destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
       return "Ruta desde " + origen + " hasta " + destino + " con una distancia de " + distancia + " km";
    }

    
    

    
}
