package Tp4.Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Cliente> colaClientes = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        Queue<Cliente> clientesAtendidos = new Queue<>();

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar cliente a la cola");
            System.out.println("2. Atender cliente");
            System.out.println("3. Buscar clientes por apellido");
            System.out.println("4. Salir");

            int op = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (op) {
                case 1:
                    System.out.println("Ingrese el código del cliente:");
                    int codCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese el nombre y apellido del cliente:");
                    String nombreApellido = scanner.nextLine();
                    System.out.println("Ingrese el correo electrónico del cliente:");
                    String mailCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(codCliente, nombreApellido, mailCliente);
                    colaClientes.offer(cliente);
                    System.out.println("Cliente agregado a la cola.");
                    break;
                case 2:
                    if (!colaClientes.isEmpty()) {
                        Cliente clienteAtendido = (Cliente) colaClientes.remove();
                        clientesAtendidos.offer(clienteAtendido);
                        System.out.println("Cliente atendido:");
                        System.out.println("Código: " + clienteAtendido.getCodCliente());
                        System.out.println("Nombre y apellido: " + clienteAtendido.getAynCliente());
                        System.out.println("Correo electrónico: " + clienteAtendido.getMailCliente());
                    } else {
                        System.out.println("No hay clientes en la cola.");
                    }
                    break;
                    case 3:
                    System.out.println("Ingrese apellido a buscar:");
                    String apellidoBuscar = scanner.nextLine();
                    int contador = 0;
                    for (int i = 0; i < clientesAtendidos.size(); i++) {
                        Cliente clienteEnCola = (Cliente) clientesAtendidos.toArray()[i];
                        if (clienteEnCola.getApellido().equals(apellidoBuscar)) {
                            contador++;
                        }
                    }
                    System.out.println("Se encontraron " + contador + " clientes con el apellido " + apellidoBuscar + ".");
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        } while (!salir);
        scanner.close();
    }
}