package Tp4.ejercicio4;

import java.util.Scanner;

public class Desarrollo {


    public void ingresarVisitantes(Queue<Visitante> colaGeneral, Scanner scanner) {
    System.out.println("Ingrese la cantidad de visitantes:");
        int cantidadVisitantes = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < cantidadVisitantes; i++) {
            System.out.println("Ingrese el ID del visitante:");
            int idVisitante = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Ingrese el nombre del visitante:");
            String nombreVisitante = scanner.nextLine();
            System.out.println("Ingrese la edad del visitante:");
            int edadVisitante = scanner.nextInt();
            scanner.nextLine(); 
            colaGeneral.offer(new Visitante(idVisitante, nombreVisitante, edadVisitante));
        }

    
    }

    public void transferirVisitantes(Queue<Visitante> colaGeneral, Queue<Visitante> colaMontañaRusa, Queue<Visitante> colaCalesita){

        int indice = 0;
        while (!colaGeneral.isEmpty()) {
            Visitante visitante = colaGeneral.pool();
            if(visitante.getEdad() >= 12){
                colaMontañaRusa.offer(visitante);
                System.out.println("El visitante " + visitante.getAnyVisitante() + " con ID " + visitante.getIdVisitante() + " accede a la montaña rusa."); 
            }else if(visitante.getEdad() >= 4 && visitante.getEdad() < 12){
                colaCalesita.offer(visitante);
                System.out.println("El visitante " + visitante.getAnyVisitante() + " con ID " + visitante.getIdVisitante() + " accede a la calesita.");
            }
            indice++;
            if(indice == 5){
                indice = 0;
                System.out.println("Grupos de 5 visitantes fueron transferidos..");
            }
            
        }
    }

    public void mostrarMenoresDeEdad(Queue<Visitante> colaCalesita) {
        int cantidadMenoresDeEdad = 0;
        Visitante visitante;
        while ((visitante = colaCalesita.pool()) != null) {
            if (visitante.getEdad() < 18) {
                cantidadMenoresDeEdad++;
            }
        }
        System.out.println("La cantidad de visitantes menores de edad es: " + cantidadMenoresDeEdad);
    }

    public void mostrarVisitantesPorJuego(Queue<Visitante> colaMontañaRusa, Queue<Visitante> colaCalesita) {
        System.out.println("La cantidad de visitantes que ingresaron en la montaña rusa es: " + colaMontañaRusa.size());
        System.out.println("La cantidad de visitantes que ingresaron en la calesita es: " + colaCalesita.size());
    }





}
