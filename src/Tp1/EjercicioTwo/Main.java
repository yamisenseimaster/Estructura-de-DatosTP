package Tp1.EjercicioTwo;

public class Main {

    public static void main(String[] args) {

        ArticuloDeLibreria[] articulo = new ArticuloDeLibreria[2];

        for (int i = 0; i < articulo.length; i++) {
            articulo[i] = new ArticuloDeLibreria();
            articulo[i].solicitarDatos();
        }
        System.out.println("------ Creando Productos ------");

        // Llamamos al método mostrarInformacion() para cada artículo
        for (ArticuloDeLibreria articuloDeLibreria : articulo) {
            articuloDeLibreria.mostrarInformacion();
        }
        for (int i = 0; i < articulo.length; i++) {
            
            articulo[i].depositarStockEspecificada(i);
        }
        for (ArticuloDeLibreria articuloDeLibreria : articulo) {
            articuloDeLibreria.mostrarInformacion();
        }

        
  
        
    }
}
