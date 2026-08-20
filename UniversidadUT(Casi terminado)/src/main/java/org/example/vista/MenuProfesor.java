package org.example.vista;

import org.example.dao.ProfesorDAO;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MenuProfesor {

    static ProfesorDAO profesorDAO = new ProfesorDAO();

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    static void agregarProfesor() throws IOException {

        Profesor profesor = new Profesor();

        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());

        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());

        System.out.print("Numero de Empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));

        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        // Se asignan automaticamente
        profesor.setNombreEmpleado(profesor.getNombre());
        profesor.setPuesto("Profesor");

        profesorDAO.agregarProfesor(profesor);
    }

    static void mostrarProfesores() {

        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();

        System.out.println("========== LISTA DE PROFESORES ==========");

        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    static void actualizarProfesor() throws IOException {

        Profesor profesor = new Profesor();

        System.out.print("Numero de Empleado del profesor a modificar: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));

        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());

        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());

        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        // Se asignan automaticamente
        profesor.setNombreEmpleado(profesor.getNombre());
        profesor.setPuesto("Profesor");

        profesorDAO.actualizarProfesor(profesor);
    }

    static void bajaProfesor() throws IOException {

        System.out.print("Numero de empleado del profesor a eliminar: ");
        int numEmpleado = Integer.parseInt(leer.readLine());

        profesorDAO.eliminarProfesor(numEmpleado);
    }

    static void buscarProfesor() throws IOException {

        System.out.print("Ingrese el numero de empleado del profesor: ");
        int numEmpleado = Integer.parseInt(leer.readLine());

        Profesor profesor = profesorDAO.buscarProfesor(numEmpleado);

        if (profesor != null) {
            System.out.println("===== PROFESOR ENCONTRADO =====");
            System.out.println("Numero de Empleado: " + profesor.getNumEmpleado());
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("CURP: " + profesor.getCurp());
            System.out.println("Sueldo: " + profesor.getSueldo());
        } else {
            System.out.println("Profesor no encontrado");
        }
    }

    public static void menu() throws IOException {

        int opcion;

        do {

            System.out.println("\n========== MENU PROFESORES ==========");
            System.out.println("1.- Agregar Profesor");
            System.out.println("2.- Mostrar Profesores");
            System.out.println("3.- Modificar Profesor");
            System.out.println("4.- Dar de baja Profesor");
            System.out.println("5.- Buscar Profesor");
            System.out.println("6.- Regresar");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {

                case 1:
                    agregarProfesor();
                    break;

                case 2:
                    mostrarProfesores();
                    break;

                case 3:
                    actualizarProfesor();
                    break;

                case 4:
                    bajaProfesor();
                    break;

                case 5:
                    buscarProfesor();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 6);
    }
}