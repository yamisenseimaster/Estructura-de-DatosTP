package Tp3.Ejercicio5;

import java.util.Scanner;

public class EditorTexto {
    PilaGenerica<String> deshacerPila = new PilaGenerica<>(); 
    PilaGenerica<String> rehacerPila = new PilaGenerica<>();
    Scanner scanner = new Scanner(System.in); 


    public void menu(){
        int op;
        do {
            System.out.println("Menu:");
            System.out.println("1. Realizar acción sobre el documento");
            System.out.println("2. Deshacer acción");
            System.out.println("3. Rehacer acción");
            System.out.println("4. Mostrar contenido");
            System.out.println("5. Salir");
            System.out.print("Ingrese opción: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    realizarAccion(scanner);
                    break;
                case 2:
                    deshacerAccion();
                    break;
                case 3:
                    rehacerAccion();
                    break;
                case 4:
                    mostrarContenido();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (op != 5);
    }

    public void realizarAccion(Scanner scanner){
        System.out.println("Seleccione una acción:");
        System.out.println("1. Negrita");
        System.out.println("2. Cursiva");
        System.out.println("3. Insertar tabla");
        System.out.println("4. Subrayado");
        System.out.println("5. Insertar imagen");
        System.out.println("6. Insertar texto");
        System.out.println("7. Borrar texto");

        int op = scanner.nextInt();
        String accion = accionOption(op);
        deshacerPila.push(accion);
        System.out.println("Accion realizada " + accion);
    }
    public String accionOption(int op){
        switch (op) {
            case 1:
            return "Negrita";
        case 2:
            return "Cursiva";
        case 3:
            return "Insertar tabla";
        case 4:
            return "Subrayado";
        case 5:
            return "Insertae imagen";
        case 6:
            return "Insertar texto";
        case 7:
            return "Borrar texto";
        default:
            return "Acción desconocida";
        }
    }

    public void deshacerAccion(){
        if(deshacerPila.empty()){
            System.out.println("No hay acciones para deshacer");
            return;
        }

        System.out.println("Deshacer todas las acciones? (s/n)");
        String resp = scanner.next();
        if(resp.equalsIgnoreCase("s")){
            while(!deshacerPila.empty()){
                String accion = deshacerPila.pop();
                rehacerPila.push(accion);
            }
            System.out.println("Toda las acciones fueron dehechas");

        }
        else{
            int numeroAleatio = (int) (Math.random() * deshacerPila.size());
            for(int i = 0; i < numeroAleatio; i++){
                String accion = deshacerPila.pop();
                rehacerPila.push(accion);
            }
            System.out.println("Acciones deshechas" + numeroAleatio );
        }
    }
    public void rehacerAccion() {
        if (rehacerPila.empty()) {
            System.out.println("No hay acciones para rehacer");
            return;
        }

        System.out.print("Ingrese número de acciones a rehacer: ");
        int numAccionesRehacer = scanner.nextInt();
        int accionesRehechas = 0;

        for (int i = 0; i < numAccionesRehacer; i++) {
            if (rehacerPila.empty()) {
                break;
            }
            String accion = rehacerPila.pop();
            deshacerPila.push(accion);
            accionesRehechas++;
        }
        System.out.println("Acciones rehechas: " + accionesRehechas);
    }

    public void mostrarContenido(){
        System.out.println("Pila deshacer:");
        mostrarPila(deshacerPila);

        System.out.println("Pila rehacer:");
        mostrarPila(rehacerPila);
    }
    public void mostrarPila(PilaGenerica<String> pila) {
        System.out.print("[");
        PilaGenerica<String> aux = new PilaGenerica<>();
        while (!pila.empty()) {
            String elemento = pila.pop();
            System.out.print(elemento);
            if (!pila.empty()) {
                System.out.print(", ");
            }
            aux.push(elemento);
        }
        while (!aux.empty()) {
            pila.push(aux.pop());
        }
        System.out.println("]");
    }
}
