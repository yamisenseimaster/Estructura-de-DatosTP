package Tp2.EjercicioOne;



public class Empleado {
    private String cuil;
    private String ayN;
    private String fecIngreso;
    private double sueldo;
    private String departamento;

    public Empleado() {

    }

    public Empleado(String cuil, String ayN, String fecIngreso, double sueldo, String departamento) {
        this.cuil = cuil;
        this.ayN = ayN;
        this.fecIngreso = fecIngreso;
        this.sueldo = sueldo;
        this.departamento = departamento;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getAyN() {
        return ayN;
    }

    public void setAyN(String ayN) {
        this.ayN = ayN;
    }

    public String getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(String fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void mostrarInformacion() {
        System.out.println("Cuil: " + cuil);
        System.out.println("Apellido y Nombre: " + ayN);
        System.out.println("Fecha de Ingreso: " + fecIngreso);
        System.out.println("Sueldo: " + sueldo);
        System.out.println("Departamento: " + departamento);
    }

    
    
    

    
}
