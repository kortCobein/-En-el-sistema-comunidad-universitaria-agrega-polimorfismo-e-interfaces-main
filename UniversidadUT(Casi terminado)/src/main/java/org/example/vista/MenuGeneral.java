package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.PersonaUt;
import org.example.modelo.PersonaUt;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MenuGeneral {

    static BufferedReader leer =
            new BufferedReader(new InputStreamReader(System.in));

    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static ProfesorDAO profesorDAO = new ProfesorDAO();

    private static void mostrarComunidadUniversitaria() {

        ArrayList<PersonaUt> comunidadUniversitaria = new ArrayList<>();

        comunidadUniversitaria.addAll(alumnoDAO.extraerAlumno());
        comunidadUniversitaria.addAll(profesorDAO.extraerProfesores());

        System.out.println("\n===== COMUNIDAD UNIVERSITARIA =====");

        for (PersonaUt personaUT : comunidadUniversitaria) {
            System.out.println(personaUT);
        }
    }

    public static void menu() throws IOException {

        int opcion;

        do {

            System.out.println("\n========== MENU GENERAL ==========");
            System.out.println("1.- Mostrar Universidad UT");
            System.out.println("2.- Menu Profesores");
            System.out.println("3.- Menu Alumnos");
            System.out.println("4.- Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {

                case 1:
                    mostrarComunidadUniversitaria();
                    break;

                case 2:
                    MenuProfesor.menu();
                    break;

                case 3:
                    MenuAlumno.menu();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);
    }
}