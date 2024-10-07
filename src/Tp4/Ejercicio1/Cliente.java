package Tp4.Ejercicio1;
// Desarrollar un programa que simule un sistema de atención de clientes que hacen fila en una tienda.
// Implementar la clase cliente con los atributos (codCliente, aynCliente, mailCliente).
// Los clientes deben ingresar a la cola y esperar su turno para recibir la atención requerida. Mostrar los datos
// del cliente cuando sale de la cola. Al finalizar la “jornada” mostrar la cantidad de clientes cuyo apellido
// coincida con uno ingresado por teclado.
// Indicaciones:
// Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
// código controle los problemas que normalmente ocurren al operar con la consola o teclado.
// Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
// respecto del código que hace lo que se solicita en el ejercicio.
public class Cliente {
    private  int codCliente;
    private  String aynCliente;
    private  String mailCliente;


    
    public Cliente() {
    }


    public Cliente(int codCliente, String aynCliente, String mailCliente) {
        this.codCliente = codCliente;
        this.aynCliente = aynCliente;
        this.mailCliente = mailCliente;
    }


    public int getCodCliente() {
        return codCliente;
    }


    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }


    public String getAynCliente() {
        return aynCliente;
    }


    public void setAynCliente(String aynCliente) {
        this.aynCliente = aynCliente;
    }


    public String getMailCliente() {
        return mailCliente;
    }


    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }
    public String getApellido() {
        String[] nombreApellido = aynCliente.split(" ");
        return nombreApellido[nombreApellido.length - 1];
    }


    @Override
    public String toString() {
        return "AtencionCliente [codCliente=" + codCliente + ", aynCliente=" + aynCliente + ", mailCliente="
                + mailCliente + "]";
    }

    

    
}
