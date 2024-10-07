package Tp4.ejercicio4;
// Escribir un programa para gestionar el acceso de visitantes a los juegos en un parque de diversiones.
// Implementar la clase Visitante (idVisitante, aynVisitante, edad). Los N (al azar) objetos visitantes deben ser
// insertados en una cola general para poder acceder a los juegos del parque. A los fines de simplificar el
// ejercicio, se establece que solo existen dos juegos: montaña rusa y calesita. Desde la cola general, los
// visitantes serán transferidos a dos colas específicas: una para la montaña rusa (apta para mayores de 12
// años) y otra para la calesita (apta para menores desde los 4 hasta los 12 años). Los visitantes deben ser
// transferidos en grupos de 5 desde la cola general a las colas específicas de los juegos. Mostrar los visitantes
// que van ingresando a los juegos, indicando a cuál juego acceden de acuerdo a su edad. Al finalizar, informar
// la cantidad de visitantes menores de edad que tuvo el parque y la cantidad que ingresó en cada juego.
// Indicaciones:
// Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
// código controle los problemas que normalmente ocurren al operar con la consola o teclado.
// Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
// respecto del código que hace lo que se solicita en el ejercicio..
public class Visitante {
    private int idVisitante;
    private String anyVisitante;
    private int edad;
    public Visitante(int idVisitante, String anyVisitante, int edad) {
        this.idVisitante = idVisitante;
        this.anyVisitante = anyVisitante;
        this.edad = edad;
    }
    public int getIdVisitante() {
        return idVisitante;
    }
    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }
    public String getAnyVisitante() {
        return anyVisitante;
    }
    public void setAnyVisitante(String anyVisitante) {
        this.anyVisitante = anyVisitante;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Visitante [idVisitante=" + idVisitante + ", anyVisitante=" + anyVisitante + ", edad=" + edad + "]";
    }

    

}
