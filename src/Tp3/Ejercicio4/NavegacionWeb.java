package Tp3.Ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NavegacionWeb {
    PilaGenerica<SitioWeb> pilaHistorial = new PilaGenerica<>();
    PilaGenerica<SitioWeb> pilaAuxiliar = new PilaGenerica<>();

    Scanner scanner = new Scanner(System.in);


    public void agregarSitioWeb(){
        System.out.println("Ingrese el nombre del sitio web: ");
        String nombre = scanner.nextLine();
        String tipo = elegirTipo();
        System.out.println("Ingrese la URL del sitio web: ");
        String url = scanner.nextLine();
        SitioWeb sitio = new SitioWeb(nombre, tipo, url);
        pilaHistorial.push(sitio);
        System.out.println("Sitio web agregado al historial.");
        
    }
    public String elegirTipo() {
        int opcion;// almacena la opcion elegida por el usuario
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in); //lee la entrada del usuario
        while (true) {//comenzamos un bucle while que se ejecutara hasta que nos devuelva un valor
            System.out.println("Seleccione el tipo de sitio web:");
            System.out.println("1. Educativo");
            System.out.println("2. Entretenimiento");
            System.out.println("3. Noticias");
            System.out.println("4. Comercio electrónico");
            //?Esta parte del codigo se encarga de leer la entrada del usuario y manejar posibles errores de entrada
            try {
                opcion = scanner.nextInt();//
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");

                continue;
            }
            
            switch (opcion) {
                case 1:
                    return "educativo";
                case 2:
                    return "entretenimiento";
                case 3:
                    return "noticias";
                case 4:
                    return "comercio electrónico";
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public void recorrerHistorial(){
        if(pilaHistorial.empty()){
            System.out.println("No hay sitios web en el historial.");
        }
        System.out.print("Ingrese el nombre o URL del sitio web que desea visitar: ");
        String Busqueda = scanner.nextLine();
        while(!pilaHistorial.empty()){
            SitioWeb sitioWeb = pilaHistorial.pop();
            pilaAuxiliar.push(sitioWeb);

            if (sitioWeb.getNombre().equals(Busqueda) || sitioWeb.getUrl().equals(Busqueda)) {
                System.out.println();
                System.out.println("Sitio web encontrado!");
                System.out.println("Nombre: " + sitioWeb.getNombre());
                System.out.println("Tipo: " + sitioWeb.getTipo());
                System.out.println("URL: " + sitioWeb.getUrl());
                System.out.println("--------------------------");
                System.out.println();
                // Volver a agregar los sitios web a la pila principal
                while (!pilaAuxiliar.empty()) {
                    pilaHistorial.push(pilaAuxiliar.pop());
                }
                return;
            }

        }
        System.out.println("Sitio web no encontrado.");
    }
    public void mostrarTotalSitiosWeb() {
        int totalSitiosWeb = pilaHistorial.size();
        int educativos = 0;
        int entretenimiento = 0;
        int noticias = 0;
        int comercioElectronico = 0;
    
        while (!pilaHistorial.empty()) {
            SitioWeb sitioWeb = pilaHistorial.pop();
            pilaAuxiliar.push(sitioWeb);
    
            switch (sitioWeb.getTipo()) {
                case "educativo":
                    educativos++;
                    break;
                case "entretenimiento":
                    entretenimiento++;
                    break;
                case "noticias":
                    noticias++;
                    break;
                case "comercio electrónico":
                    comercioElectronico++;
                    break;
            }
        }
    
        // Volver a agregar los sitios web a la pila principal
        while (!pilaAuxiliar.empty()) {
            pilaHistorial.push(pilaAuxiliar.pop());
        }
        System.out.println();
        System.out.println("Total de sitios web visitados: " + totalSitiosWeb);
        System.out.println("Educativos: " + educativos);
        System.out.println("Entretenimiento: " + entretenimiento);
        System.out.println("Noticias: " + noticias);
        System.out.println("Comercio electrónico: " + comercioElectronico);
        System.out.println();
    }

}
