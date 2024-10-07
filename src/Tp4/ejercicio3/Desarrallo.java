package Tp4.ejercicio3;

import java.util.Scanner;

public class Desarrallo {
    Queue<TrabajoImpresion> auxiliar = new Queue<>();
    public  void encolarTrabajo(Queue<TrabajoImpresion> trabajoQueue, Scanner scanner ){
            Helper vali = new Helper();
            System.out.println("codigo del trabajo:");
            int codigo = vali.validarEntero(scanner, "Ingrese codigo:");
            System.out.println("nombre del trabajo:");
            @SuppressWarnings("static-access")
            String nombre = vali.validarStringNoVacio(scanner, "ingrese el nombre del trabajo:");
            System.out.println("cantidad de páginas:");
            int cantidadPaginas = vali.validarEntero(scanner, "Ingrese la cantida de paginas:");
    
            TrabajoImpresion trabajo = new TrabajoImpresion(codigo, nombre, cantidadPaginas);
            trabajoQueue.add(trabajo);
            System.out.println("Trabajo agregados");
        }
        public  void desencolarTrabajo(Queue<TrabajoImpresion> trabajoQueue){
            try {
                TrabajoImpresion trabajo = trabajoQueue.remove();
                System.out.println("Trabajo desencolado: " + trabajo.getNomTrabajo());
            } catch (IllegalStateException e) {
                System.out.println("No hay trabajos en la cola");
            }
        }
        public  void mostrarTrabajosImpresos(Queue<TrabajoImpresion> trabajosQueue, Scanner scanner) {
            
            System.out.print("Ingrese cantidad de páginas mínima: ");
            int cantPagMin = scanner.nextInt();
        
            int count = 0;
            int i = 0;
            while (i < trabajosQueue.size()) {
                try{
                    TrabajoImpresion trabajo = (TrabajoImpresion) trabajosQueue.toArray()[i];
                    auxiliar.add(trabajo);
                    if (trabajo.getCantPagTrabajo() >= cantPagMin) {
                        count++;
                    }
                    i++;
                    
                }catch(ClassCastException e){
                    System.out.println("Error el objeto no es de tipo trabajoImpresion");
                }
            }
        
            System.out.println("Cantidad de trabajos impresos con cantidad de páginas mayor o igual a " + cantPagMin + ": " + count);
        }

}
