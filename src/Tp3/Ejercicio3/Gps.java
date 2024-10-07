package Tp3.Ejercicio3;

public class Gps {

//?Esta pila se utiliza para almacenar las rutas que el usuario ha agregado al sistema de GPS. Cuando el usuario agrega una nueva ruta, se push (agrega) a esta pila.

    //<Ruta> especifica que la pila almacenará elementos de tipo Ruta. En otras palabras, esta pila almacenará rutas.
    private PilaGenerica<Ruta> pilaRutas;
    private PilaGenerica<Ruta> pilaDeshacer;



    public Gps(PilaGenerica<Ruta> pilaRutas, PilaGenerica<Ruta> pilaDeshacer) {
        this.pilaRutas = new PilaGenerica<>();
        this.pilaDeshacer = new PilaGenerica<>();
    }

    // METODOS
    public void agregarRuta(Ruta ruta){
        pilaRutas.push(ruta);
    }

    public void deshacerRuta(){
        if(!pilaRutas.empty()){
            Ruta ruta = pilaRutas.pop();
            pilaDeshacer.push(ruta);
        }
    }
    public void rehacerRuta(){
        if(!pilaDeshacer.empty()){
            Ruta ruta = pilaDeshacer.pop();
            pilaRutas.push(ruta);
        }
    }

    public void verRutaActual(){
        if(!pilaRutas.empty()){
            Ruta ruta = pilaRutas.peek();
            System.out.println("La ruta actual es: " + ruta);

        }else{
            System.out.println("No hay ruta actual");
        }
    }

    public void verHistorialCompleto(){
        System.out.println("Historial de Rutas");
        PilaGenerica<Ruta> temp = new PilaGenerica<>();
        while (!pilaRutas.empty()) {
            Ruta ruta = pilaRutas.pop();
            System.out.println(ruta.toString());
            temp.push(ruta);
        }
        while (!temp.empty()) {
            pilaRutas.push(temp.pop());
        }
    }

    
}
