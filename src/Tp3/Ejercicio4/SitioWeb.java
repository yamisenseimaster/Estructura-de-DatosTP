package Tp3.Ejercicio4;

// Implementar la clase “SitioWeb” que posea los siguientes atributos: nombre, tipo (educativo,
// entretenimiento, noticias o comercio electrónico) y url. Utilizar una pila para almacenar y recorrer el
// historial de navegación de los sitios web visitados.
// La operación de almacenar consiste en agregar sitios web a la pila, a petición del usuario. Recorrer el
// historial consiste en navegar hasta el sitio web de interés (por nombre o url), pero sin perder la información
// de los sitios previamente visitados (usar una pila auxiliar).
// Crear un programa que facilite el acceso a ambas operaciones. Además, mostrar el total de sitios web
// visitados e indicar cuantos corresponden a cada tipo.
// Indicaciones:
// Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
// código controle los problemas que normalmente ocurren al operar con la consola o teclado.
// Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
// respecto del código que hace lo que se solicita en el ejercicio.
public class SitioWeb {
    private String nombre;
    private String tipo;
    private String url;
    public SitioWeb(String nombre, String tipo, String url) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.url = url;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "SitioWeb [nombre=" + nombre + ", tipo=" + tipo + ", url=" + url + "]";
    }

    

}
