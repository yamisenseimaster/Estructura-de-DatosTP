package Tp4.ejercicio3;
// Crear un programa para gestionar la cola de documentos en una impresora, de manera que se puedan
// encolar y desencolar trabajos de impresión. En la cola se deben insertar objetos de tipo trabajoImpresion
// que poseen los atributos (codTrabajo, nomTrabajo, cantPagTrabajo). Al finalizar, el programa debe mostrar
// la cantidad de trabajos, cuya cantidad de páginas sea mayor o igual a un valor ingresado por teclado, que se
// imprimieron .
// Indicaciones:
// Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
// código controle los problemas que normalmente ocurren al operar con la consola o teclado.
// Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
// respecto del código que hace lo que se solicita en el ejercicio.
public class TrabajoImpresion {
    private int codTrabajo;
    private String nomTrabajo;
    private int cantPagTrabajo;
    public TrabajoImpresion(int codTrabajo, String nomTrabajo, int cantPagTrabajo) {
        this.codTrabajo = codTrabajo;
        this.nomTrabajo = nomTrabajo;
        this.cantPagTrabajo = cantPagTrabajo;
    }
    public int getCodTrabajo() {
        return codTrabajo;
    }
    public void setCodTrabajo(int codTrabajo) {
        this.codTrabajo = codTrabajo;
    }
    public String getNomTrabajo() {
        return nomTrabajo;
    }
    public void setNomTrabajo(String nomTrabajo) {
        this.nomTrabajo = nomTrabajo;
    }
    public int getCantPagTrabajo() {
        return cantPagTrabajo;
    }
    public void setCantPagTrabajo(int cantPagTrabajo) {
        this.cantPagTrabajo = cantPagTrabajo;
    }
    @Override
    public String toString() {
        return "TrabajoImpresion [codTrabajo=" + codTrabajo + ", nomTrabajo=" + nomTrabajo + ", cantPagTrabajo="
                + cantPagTrabajo + "]";
    }
    


}
