package Tp2.EjercicioOne;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del array de empleado: ");
        int tamanyoArray = input.nextInt();

        Empleado[] empleados = new Empleado[tamanyoArray];

        for (int i = 0; i < tamanyoArray; i++){
            System.out.println("Ingrese datos del empleado " + (i + 1) + ":");
            System.out.print("Cuil: ");
            String cuil = input.next();
            System.out.print("Apellido y nombre: ");
            String ayN = input.next();
            System.out.print("Fecha de ingreso: ");
            String fecIngreso = input.next();
            System.out.print("Sueldo: ");
            double sueldo = input.nextDouble();
            System.out.print("Departamento: ");
            String departamento = input.next();

            empleados[i] = new Empleado(cuil, ayN, fecIngreso, sueldo, departamento);
        }

            String[] departamentos = getDepartamentos(empleados);
            double[] sueldosPorDepartamento = new double[departamentos.length];

            for(int i = 0; i < departamentos.length; i++){
                sueldosPorDepartamento[i] = calcularSueldoPorDepartamento(empleados, departamentos[i]);
            }

            System.out.println("Sueldo por departamento: ");
            for (int i = 0; i < departamentos.length; i++){
                System.out.println(departamentos[i] + ": " + sueldosPorDepartamento[i]);
            }

    }

    public static String[] getDepartamentos(Empleado[] empleados){
        String[] departamentos = new String[empleados.length];
        int indice = 0;
        for (Empleado empleado : empleados) {
            boolean existe = false;
            for(int i = 0; i < indice; i++){
                if(empleado.getDepartamento().equals(departamentos[i])){
                    existe = true;
                    break;
                }
            }
            if(!existe){
                departamentos[indice] = empleado.getDepartamento();
                indice ++;
            }
        }
        String[] departamentosUnicos = new String[indice];
        System.arraycopy(departamentos, 0, departamentosUnicos, 0, indice);
        return departamentosUnicos;
    }


        public static double calcularSueldoPorDepartamento(Empleado[] empleados, String departamento) {
            double sueldoTotal = 0;

            for (Empleado empleado : empleados) {
                if (empleado.getDepartamento().equals(departamento)) {
                    sueldoTotal += empleado.getSueldo();
                }
            }

            return sueldoTotal;
        }
}