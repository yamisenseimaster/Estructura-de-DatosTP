package Tp4.ejercicio6;

import java.util.Scanner;

public class Gestion {
        Queue<Cliente> colaInicial = new Queue<>();
        Queue<Cliente> colaCuentas = new Queue<>();
        Queue<Cliente> colaCajas = new Queue<>();

        public void agregarClienteAColaInicial(Cliente cliente) {
            colaInicial.add(cliente);
        }
    
        public void asignarTramite() {
            if (colaInicial.isEmpty()) {
                System.out.println("No hay clientes en la cola inicial");
                return;
            }
    
            Cliente cliente = colaInicial.pool();
            System.out.println("Cliente selecoionado: " + cliente.getnombreliente());
    
            System.out.println("Seleccione el trámite a realizar:");
            System.out.println("1. Cuentas");
            System.out.println("2. Cajas");
    
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
    
            switch (opcion) {
                case 1:
                    colaCuentas.add(cliente);
                    System.out.println("Cliente asignado a la cola de cuentas");
                    break;
                case 2:
                    colaCajas.add(cliente);
                    System.out.println("Cliente asignado a la cola de cajas");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    
        public void mostrarClientesAtendidos() {
            System.out.println("Clientes atendidos en cuentas: " + colaCuentas.size());
            System.out.println("Clientes atendidos en cajas: " + colaCajas.size());
        }
    
        public void mostrarClientesMenoresDe40EnCajas() {
            System.out.println("Clientes menores de 40 años atendidos en cajas:");
            for (Cliente cliente : colaCajas.toArrayCliente()) {
                if (cliente.getEdadCliente() < 40) {
                    System.out.println(cliente.getnombreliente());
                }
            }
            System.out.println("-----------------------------------");
            System.out.println("Clientes menores de 40 años atendidos en Cuentas:");
            for (Cliente cliente : colaCuentas.toArrayCliente()) {
                if (cliente.getEdadCliente() < 40) {
                    System.out.println(cliente.getnombreliente());
                }
            }
        }

    
}

