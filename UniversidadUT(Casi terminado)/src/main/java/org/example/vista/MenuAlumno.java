package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.modelo.Alumno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MenuAlumno {

    static AlumnoDAO alumnoDAO = new AlumnoDAO();

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    private static void inscribir() throws IOException {

        Alumno alumno = new Alumno();

        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());

        System.out.print("CURP: ");
        alumno.setCurp(leer.readLine());

        System.out.print("Numero de Expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));

        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());

        System.out.print("Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.inscribirAlumno(alumno);
    }

    private static void mostrarAlumnos() {

        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumno();

        System.out.println("========== LISTA DE ALUMNOS ==========");

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    private static void actualizarAlumno() throws IOException {

        Alumno alumno = new Alumno();

        System.out.print("Numero de Expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));

        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());

        System.out.print("CURP: ");
        alumno.setCurp(leer.readLine());

        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());

        System.out.print("Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.actualizar(alumno);
    }

    private static void bajaAlumno() throws IOException {

        System.out.print("Numero de expediente del alumno a eliminar: ");
        int numExpediente = Integer.parseInt(leer.readLine());

        alumnoDAO.eliminarAlumno(numExpediente);
    }

    private static void buscarAlumno() throws IOException {

        System.out.print("Ingrese el numero de expediente del alumno: ");
        int numExpediente = Integer.parseInt(leer.readLine());

        Alumno alumno = alumnoDAO.buscarAlumno(numExpediente);

        if (alumno != null) {
            System.out.println("===== ALUMNO ENCONTRADO =====");
            System.out.println("Expediente: " + alumno.getNumExpediente());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("CURP: " + alumno.getCurp());
            System.out.println("Grupo: " + alumno.getGrupo());
            System.out.println("Promedio: " + alumno.getPromedio());
        } else {
            System.out.println("Alumno no encontrado");
        }
    }

    public static void menu() throws IOException {

        int opcion;

        do {

            System.out.println("\n========== MENU ALUMNOS ==========");
            System.out.println("1.- Inscribir Alumno");
            System.out.println("2.- Mostrar Alumnos");
            System.out.println("3.- Actualizar Alumno");
            System.out.println("4.- Dar de baja Alumno");
            System.out.println("5.- Buscar Alumno");
            System.out.println("6.- Regresar");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {

                case 1:
                    inscribir();
                    break;

                case 2:
                    mostrarAlumnos();
                    break;

                case 3:
                    actualizarAlumno();
                    break;

                case 4:
                    bajaAlumno();
                    break;

                case 5:
                    buscarAlumno();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 6);
    }
}