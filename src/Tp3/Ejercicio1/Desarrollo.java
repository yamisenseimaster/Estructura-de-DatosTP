package Tp3.Ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class Desarrollo {
    PilaGenerica<String> palabraInformaticas = new PilaGenerica<>();
    PilaGenerica<String> pilaAuxiliar = new PilaGenerica<>();
    Scanner scanner = new Scanner(System.in);

    public void iniciarPila() {
            String palabras[] = {"notebook", "ram", "terabyte", "rom", "software", "hardware", "datos", "Cache", "Programador", "java"};
            Random random = new Random();
            try {
                if (palabraInformaticas.size() >= 5) {
                    throw new RuntimeException("La pila ya tiene 5 elementos, no se pueden agregar más");
                }
                for (int i = 0; i < 5; i++) {
                    int indice = random.nextInt(palabras.length);
                    palabraInformaticas.push(palabras[indice]);
                }
                System.out.println("Pila iniciada con palabras aleatorias");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Pila iniciada con éxito");
            }
    }

    public void eliminarPalabras() {
        
        System.out.print("Ingrese el número de palabras a eliminar: ");
        int n = scanner.nextInt();
        int palabrasEliminadas = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la palabra a eliminar: ");
            String palabra = scanner.next();

            while (!palabraInformaticas.empty()) {
                String palabraPila = palabraInformaticas.pop();
                if (palabraPila.equals(palabra)) {
                    palabrasEliminadas++;
                } else {
                    pilaAuxiliar.push(palabraPila);
                }
            }

            while (!pilaAuxiliar.empty()) {
                palabraInformaticas.push(pilaAuxiliar.pop());
            }
        }

        System.out.println("Palabras eliminadas: " + palabrasEliminadas);
        
    }

    public void mostrarPilaOriginal(){
        PilaGenerica<String> pilaAuxiliar = new PilaGenerica<>(palabraInformaticas.size());
        System.out.println("Pila original:");
        try {
            while (!palabraInformaticas.empty()) {
                String palabra = palabraInformaticas.pop();
                System.out.println(palabra);
                pilaAuxiliar.push(palabra);
            }
        } catch (NullPointerException e) {
            System.out.println("Error: la pila contiene un elemento null");
        } catch (RuntimeException e) {
            System.out.println("Error al manejar la pila: " + e.getMessage());
        }

        while (!pilaAuxiliar.empty()) {
            palabraInformaticas.push(pilaAuxiliar.pop());
        }
    }
    public void mostrarPilaFinal(){
        System.out.println("Pila final: ");
        while (!palabraInformaticas.empty()) {
            System.out.println(palabraInformaticas.pop());
        }
    }


}
