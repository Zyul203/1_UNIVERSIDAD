package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Cuantos alumnos por grupos, profe con más materias, que grupo tiene más alumnos

public class Main
{
    static void main()
    {
        Scanner sc = new Scanner(System.in);

        List<GRUPO> listaGrupos = new ArrayList<>();
        List<ALUMNO> listaAlumnos = new ArrayList<>();
        List<MATERIA> listaMaterias = new ArrayList<>();
        List<PROFESOR> listaProfesores = new ArrayList<>();


        SISTEMA miSistema = new SISTEMA(listaGrupos, listaAlumnos, listaMaterias, listaProfesores);
        int opcionPrincipal = 0 , opcionSecundaria = 0;
        String opciont = "";

        //Datos de default
        miSistema.getListaProfesoresDefault(); //Crear la lista de Profes
        miSistema.getListaMateriasDefault();
        miSistema.getListaAlumnosDefault();
        miSistema.getListaGruposDefault();


        do
        {

            System.out.println("\n=================================");
            System.out.println("         MENÚ PRINCIPAL           ");
            System.out.println("==================================");
            System.out.println("1. Sección de Grupos");
            System.out.println("2. Sección de Alumnos");
            System.out.println("3. Sección de Materias");
            System.out.println("4. Sección de Profesor");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            try
            {
                opcionPrincipal = sc.nextInt();

                switch (opcionPrincipal)
                {

                    case 1 ->
                    {
                        do
                        {
                            System.out.println("\n---------------------------------");
                            System.out.println("           SECCIÓN: GRUPO      ");
                            System.out.println("---------------------------------");
                            System.out.println("1. Mostrar lista de Grupos");
                            System.out.println("2. Registrar Grupo");
                            System.out.println("3. Asignar alumno a grupo");
                            System.out.println("4. Salir");
                            System.out.print("Selecciona una opción: ");

                            try
                            {
                                opcionSecundaria = sc.nextInt();

                                switch (opcionSecundaria)
                                {
                                    case 1:
                                        System.out.println("\n------  LISTA DE GRUPOS   -------");
                                        miSistema.MostrarDato(miSistema.FiltrarLista(GRUPO.class));
                                        break;

                                    case 2:
                                        System.out.println("\n------   REGISTRO DE GRUPO   -------");
                                        sc.nextLine(); //Buffer
                                        do
                                        {
                                            GRUPO grupo1 = miSistema.CrearGrupo();
                                            listaGrupos.add(grupo1);


                                            System.out.print("¿Desea registrar otro grupo? (Y/N): ");
                                            opciont = sc.nextLine();
                                            if (opciont.equalsIgnoreCase("N")) { break; };

                                        } while(true);
                                        break;

                                    case 3:
                                        System.out.println("\n------ ASIGNACIÓN DE ALUMNO A GRUPO ------");

                                        if (!listaGrupos.isEmpty()) { miSistema.AddAlumnosToGrupo(); }
                                        else { System.out.println("No hay grupos registrados..."); }
                                        break;

                                    case 4:
                                        System.out.println("Regresando al Menú Principal...");
                                        break;

                                    default:
                                        System.out.println("Opción no válida. Intenta de nuevo...");
                                }
                            } catch (Exception e)
                            {
                                System.out.println("Error!");
                                opcionSecundaria = 0; // Resetea la opción para continuar el ciclo
                            }
                        } while (opcionSecundaria != 4);
                    }


                    case 2 ->
                    {
                        do
                        {

                            System.out.println("\n---------------------------------");
                            System.out.println("           SECCIÓN: ALUMNOS      ");
                            System.out.println("---------------------------------");
                            System.out.println("1. Mostrar lista de Alumnos");
                            System.out.println("2. Registrar Alumno");
                            System.out.println("3. Asignar materia a un alumno");
                            System.out.println("4. Salir");
                            System.out.print("Selecciona una opción: ");

                            try
                            {
                                opcionSecundaria = sc.nextInt();

                                switch (opcionSecundaria)
                                {
                                    case 1:
                                        System.out.println("\n------  LISTA DE ALUMNOS   -------");
                                        miSistema.MostrarDato(miSistema.FiltrarLista(ALUMNO.class));
                                        break;

                                    case 2:
                                        System.out.println("\n------   REGISTRO DE ALUMNO   -------");
                                        sc.nextLine(); //Buffer

                                        if(!listaGrupos.isEmpty())
                                        {
                                            do {
                                                ALUMNO alumno1 = miSistema.CrearAlumno();
                                                listaAlumnos.add(alumno1);

                                                System.out.print("¿Desea registrar otro alumno? (Y/N): ");
                                                opciont = sc.nextLine();
                                                if (opciont.equalsIgnoreCase("N")) {
                                                    break;
                                                }
                                                ;
                                            } while (true);
                                        }
                                        else { System.out.println("Primero da de alta un grupo..."); }

                                        break;

                                    case 3:
                                        System.out.println("\n------ ASIGNACIÓN DE MATERIAS A PROFESOR ------");

                                        if (!listaAlumnos.isEmpty()) { miSistema.AddMateriasToAlumno(); }
                                        else { System.out.println("No hay alumnos registrados..."); }
                                        break;

                                    case 4:
                                        System.out.println("Regresando al Menú Principal...");
                                        break;

                                    default:
                                        System.out.println("Opción no válida. Intenta de nuevo...");
                                }
                            } catch (Exception e)
                            {
                                System.out.println("Error: ¡Debes ingresar un número entero!");
                                opcionSecundaria = 0; // Resetea la opción para continuar el ciclo
                            }
                        } while (opcionSecundaria != 4);
                    }

                    case 3 ->
                    {
                        do
                        {
                            System.out.println("\n---------------------------------");
                            System.out.println("           SECCIÓN: MATERIA      ");
                            System.out.println("---------------------------------");
                            System.out.println("1. Mostrar lista de Materias");
                            System.out.println("2. Registrar Materia");
                            System.out.println("3. Asignar profesor a una materia");
                            System.out.println("4. Salir");
                            System.out.print("Selecciona una opción: ");

                            try
                            {
                                opcionSecundaria = sc.nextInt();

                                switch (opcionSecundaria)
                                {
                                    case 1:
                                        System.out.println("\n------  LISTA DE MATERIAS   -------");
                                        miSistema.MostrarDato(miSistema.FiltrarLista(MATERIA.class));
                                        break;

                                    case 2:
                                        System.out.println("\n------   REGISTRO DE MATERIAS   -------");
                                        sc.nextLine(); //Limpiar buffer
                                        do
                                        {
                                            MATERIA materia1 = miSistema.CrearMateria();
                                            listaMaterias.add(materia1);

                                            System.out.print("¿Desea agregar otra materia? (Y/N): ");
                                            opciont = sc.nextLine();
                                            if (opciont.equalsIgnoreCase("N")) { break; };
                                        } while(true);
                                        break;

                                    case 3:
                                        System.out.println("\n------ ASIGNACIÓN DE PROFESOR A MATERIAS ------");

                                        if (!listaMaterias.isEmpty()) { miSistema.AddProfesorToMateria(); }
                                        else { System.out.println("No hay materias registradas..."); }
                                        break;

                                    case 4:
                                        System.out.println("Regresando al Menú Principal...");
                                        break;

                                    default:
                                        System.out.println("Opción no válida. Intenta de nuevo...");
                                }
                            } catch (Exception e)
                            {
                                System.out.println("Error!...");
                                opcionSecundaria = 0; // Resetea la opción para continuar el ciclo
                            }
                        } while (opcionSecundaria != 4);
                    }

                    case 4 -> {
                        do {

                            System.out.println("\n---------------------------------");
                            System.out.println("           SECCIÓN: PROFESOR      ");
                            System.out.println("---------------------------------");
                            System.out.println("1. Mostrar lista de Profesores");
                            System.out.println("2. Salir");
                            System.out.print("Selecciona una opción: ");

                            try {

                                opcionSecundaria = sc.nextInt();

                                switch (opcionSecundaria) {
                                    case 1:
                                        System.out.println("\n------  LISTA DE PROFESORES   -------");
                                        miSistema.MostrarDato(miSistema.FiltrarLista(PROFESOR.class));
                                        break;

                                    case 2:
                                        System.out.println("Regresando al Menú Principal...");
                                        break;

                                    default:
                                        System.out.println("Opción no válida. Intenta de nuevo...");
                                }
                            } catch (Exception e) {
                                System.out.println("Error!...");
                                opcionSecundaria = 0; // Resetea la opción para continuar el ciclo
                            }
                        } while (opcionSecundaria != 2);
                    }

                    case 5 ->
                    {
                        System.out.println("Saliendo del programa...");
                    }

                    default -> System.out.println("Opción no válida. Intenta de nuevo...");
                }
            } catch (Exception e)
            {
                System.out.println("Error: ¡Debes ingresar un número entero!");
                opcionPrincipal = 0; // Resetea la opción para continuar el ciclo
            }
        } while (opcionPrincipal != 5);
    }
}
