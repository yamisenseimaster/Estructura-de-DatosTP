package Tp4.ejercicio6;
// Escribir un programa que simule la atención de clientes en un banco. Los clientes (dniCliente, aynCliente,
// edadCliente) asisten a la entidad bancaria a fin de realizar diferentes trámites y/o consultas. En una cola
// inicial, se deben agregar todos los clientes que ingresan al banco. Luego, por indicación del personal de
// recepción del banco, una vez establecido el trámite a realizar, los clientes deben abandonar la cola inicial e
// incorporarse en la cola que corresponde al trámite a realizar (cuentas, cajas). Mostrar la cantidad de
// clientes atendidos en cada sector y mostrar los clientes menores de 40 años atendidos en la línea de cajas.
// Indicaciones:
// Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
// código controle los problemas que normalmente ocurren al operar con la consola o teclado.
// Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
// respecto del código que hace lo que se solicita en el ejercicio.
public class Cliente {
    private String dniCliente;
    private String nombreliente;
    private int edadCliente;


    public Cliente(String dniCliente, String nombreliente, int edadCliente) {
        this.dniCliente = dniCliente;
        this.nombreliente = nombreliente;
        this.edadCliente = edadCliente;
    }


    public String getDniCliente() {
        return dniCliente;
    }


    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }


    public String getnombreliente() {
        return nombreliente;
    }


    public void setnombreliente(String nombreliente) {
        this.nombreliente = nombreliente;
    }


    public int getEdadCliente() {
        return edadCliente;
    }


    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }


    @Override
    public String toString() {
        return "Cliente [dniCliente=" + dniCliente + ", nombreliente=" + nombreliente + ", edadCliente=" + edadCliente
                + "]";
    }

    
    
}
