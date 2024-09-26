package Tp1.EjercicioThree;
//? Desarrollar una clase llamada "Evento" que represente un evento planificado en un calendario. La clase
//? debe contener los siguientes atributos mínimos: "nombre", "descripcion", "fechaInicio" y "fechaFin". Se
//? debe implementar los siguientes métodos:
//? a) Constructor predeterminado: inicializa el nombre y descripción como "Sin nombre" y "Sin descripción",
//? respectivamente. La fecha de inicio se establece en la fecha actual y la fecha de fin se establece en 7
//? días después de la fecha actual.
//? b) Constructor parametrizado que permite establecer nombre, descripción, fecha de inicio y fecha de fin.
//? c) Método auxiliar para validar fechas: comprueba si las fechas de inicio y fin son válidas (la fecha de inicio
//? debe ser anterior a la fecha de fin y ambas deben estar dentro de los próximos 30 días). Si las fechas no
//? son válidas, se ajustan automáticamente del mismo modo que en el constructor predeterminado.
//? d) Método para mostrar la información del evento, incluyendo el nombre, la descripción, la fecha de inicio
//? y la fecha de fin.
//? e) Método para calcular la duración del evento en días.
//? f) Método para determinar si el evento está en curso en la fecha actual.
//? g) Método para calcular la cantidad de días restantes hasta el inicio del evento.
//? h) Método para calcular la cantidad de días transcurridos desde el inicio del evento.

//? Crear un programa que permita:
//? a) Crear un evento con nombre, descripción, fecha de inicio y fecha de fin ingresados por el usuario.
//? b) Presentar un menú de opciones para realizar las siguientes operaciones sobre el objeto creado:
//? 1. Mostrar la información de un evento.
//? 2. Calcular la duración del evento en días.
//? 3. Verificar si el evento está en curso en la fecha actual.
//? 4. Calcular la cantidad de días restantes hasta el inicio del evento.
//? 5. Calcular la cantidad de días transcurridos desde el inicio del evento.
//? 6. Salir
//* Indicaciones:
//* Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//* código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//* Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//* respecto del código que hace lo que se solicita en el ejercicio.

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Evento {

    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    
    public Evento() {
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descripción";
        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaInicio.plusDays(7);
    }
    public Evento(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        validaFecha();
    }
    

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    //* c) Método auxiliar para validar fechas: comprueba si las fechas de inicio y fin son válidas
    private void validaFecha(){
        //? El método before() se utiliza para comprobar si una fecha dada es anterior a otra fecha dada.
        //? El método isAfter() de la clase LocalDate en Java comprueba si esta fecha es posterior a la fecha especificada.
        //* Este método valida que fechaInicio no sea antes de fechaFin y que ambas fechas no sean más antiguas de 30 días desde la fecha actual. Si alguna de estas 
        //* condiciones no se cumple, el método ajusta las fechas, estableciendo la fecha de inicio en el día actual y la fecha de fin una semana después.
        if(fechaInicio.isAfter(fechaFin) || fechaFin.isBefore(LocalDate.now().minusDays(30))){
            fechaInicio = LocalDate.now();//? El now() me permite acceder a la fecha actual
            fechaFin = fechaInicio.plusDays(7);
        }
    }
    //* d) Método para mostrar la información del evento, incluyendo el nombre, la descripción, la fecha de inicio y la fecha de fin
    public void mostrarInformacion(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Fecha de inicio: " + this.fechaInicio);
        System.out.println("Fecha de fin: " + this.fechaFin);
    }
    
    
    //* e) Método para calcular la duración del evento en días.
    public long calcularDuracion(){
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }
    //* f) Método para determinar si el evento está en curso en la fecha actual
    public boolean estaEnCurso(){
        LocalDate fechaActual = LocalDate.now();
         return fechaActual.isAfter(fechaInicio) && fechaActual.isBefore(fechaFin);
    }
    //* g) Método para calcular la cantidad de días restantes hasta el inicio del evento.
    public long calcularDiasRestantes() {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaInicio);
    }

    //* h) Método para calcular la cantidad de días transcurridos desde el inicio del evento.
    public long calcularDiasTranscurridos() {
        return ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());
    }
    //* Crear un programa que permita:
    public static String validacionCosole(Scanner input, String mensaje){

        String valorIngresador;
        while(true){
            System.out.println(mensaje);

            //* */ El try declaración le permite definir un bloque de código a ser probado para errores mientras se está ejecutando.
            //* */ El catch declaración le permite definir un bloque de código para ejecutarse, si se produce un error en el bloque de prueba.
            //* */ El try y catch palabras clave ven en parejas:

            try{
                valorIngresador = input.nextLine();     //* trim() el método elimina el espacio en blanco de ambos extremos de una cadena.
                if(!valorIngresador.trim().isEmpty()){//*Empty() el método comprueba si la cadena de entrada está vacía o no. Tenga en cuenta que aquí vacío significa que el número de caracteres contenidos en una cadena es cero.
                    break;
                }
                else{
                    System.out.println("El valor no puede estar vacío. Intente de nuevo");
                }
            } catch(InputMismatchException e){
                System.out.println("Entrada invalida. Intente otra vez..");
            }catch(Exception e){
                System.out.println("Error");
            }
        }
        return valorIngresador;

    }
    public static int validarEntero(Scanner input, String mensaje){
        String valorIngresado;
        int numero;
        while(true){
            System.out.println(mensaje);
            try{
                valorIngresado = input.nextLine();
                numero = Integer.parseInt(valorIngresado);
                break;
            }catch(Exception e){
                System.out.println("Entrada invalida. Intente de nuevo");
            }
        }
        return numero;
    }

    //* a) Crear un evento con nombre, descripción, fecha de inicio y fecha de fin ingresados por el usuario.
    public void solicitaDatos(){
        Scanner sc = new Scanner(System.in);
        this.setNombre(validacionCosole(sc, "Ingrese el nombre del Evento: "));
        this.setDescripcion(validacionCosole(sc, "Ingrese la descripción del Evento: "));
        this.setFechaInicio(LocalDate.parse(validacionCosole(sc, "Ingrese la fecha de inicio del Evento (YYYY-MM-DD): ")));
        this.setFechaFin(LocalDate.parse(validacionCosole(sc, "Ingrese la fecha de fin del Evento (YYYY-MM-DD): ")));
        
    }
    
    //* b) Presentar un menú de opciones para realizar las siguientes operaciones sobre el objeto creado:
    //* 1. Mostrar la información de un evento.
    //* 2. Calcular la duración del evento en días.
    //* 3. Verificar si el evento está en curso en la fecha actual.
    //* 4. Calcular la cantidad de días restantes hasta el inicio del evento.
    //* 5. Calcular la cantidad de días transcurridos desde el inicio del evento.
    //* 6. Salir
    public void menu(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean inicio = true;
        while(inicio){
            System.out.println("1. Mostrar la información de un evento.");
            System.out.println("2. Calcular la duración del evento en día.");
            System.out.println("3. Verificar si el evento está en curso en la fecha actual.");
            System.out.println("4. Calcular la cantidad de día restantes hasta el inicio del evento.");
            System.out.println("5. Calcular la cantidad de día transcurridos desde el inicio del evento.");
            System.out.println("6. Salir");
            int op = sc.nextInt();
            switch(op){
                case 1:
                    mostrarInformacion();
                    break;
                case 2:
                    System.out.println("La duración del evento es: " + calcularDuracion() + " dias");
                    break;
                case 3:
                    System.out.println("El evento está en curso: " + estaEnCurso());
                    break;
                case 4:
                    System.out.println("La cantidad de día restantes es: " + calcularDiasRestantes() + " dias");
                    break;
                case 5:
                    System.out.println("La cantidad de día transcurridos es: " + calcularDiasTranscurridos() + " dias");
                    break;
                case 6:
                    inicio = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    
}

