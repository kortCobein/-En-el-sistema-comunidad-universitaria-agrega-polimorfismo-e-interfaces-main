package org.example.modelo;

public class Profesor extends PersonaUt implements Ensenador, Evaluador {

    private int numEmpleado;
    private String nombreEmpleado;
    private String puesto;
    private double sueldo;

    public Profesor(){}

    public Profesor(String nombre, String curp, int numEmpleado, String nombreEmpleado, String puesto, double sueldo) {
        super(nombre, curp);
        setNumEmpleado(numEmpleado);
        setNombreEmpleado(nombreEmpleado);
        setPuesto(puesto);
        setSueldo(sueldo);
    }

    @Override
    public String mostrarTipoPersona() {
        return "Profesor";
    }

    @Override
    public void ensenar() {
        System.out.println("El profesor está enseñando");
    }

    @Override
    public void evaluar() {
        System.out.println("El profesor está evaluando");
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Numero de Empleado: " + getNumEmpleado() + "\n" +
                super.toString() + "\n" +
                "Nombre Empleado: " + getNombreEmpleado() + "\n" +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: " + getSueldo() + "\n" +
                "=====================================";
    }
}