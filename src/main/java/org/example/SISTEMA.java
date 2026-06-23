package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.IntStream;

public class SISTEMA
{
    Scanner sc = new Scanner(System.in);

    private List<GRUPO> listaGrupos;
    private List<ALUMNO> listaAlumnos;
    private List<MATERIA> listaMaterias;
    private List<PROFESOR> listaProfesores;


    String nombre_U = "UTT", direccion = "Carr. Torreón - Matamoros", grado ="", seccion="", turno="", nombre_A="", apellido="", sexo="", telefono="", correo="";
    String nombre_M="", nombre_P="", especialidad="";


    int matricula = 0, calificacion = 0, edad = 0, id_p = 11, id_m = 4, id_g = 4;


    public SISTEMA(List<GRUPO> listaGrupos, List<ALUMNO> listaAlumnos, List<MATERIA> listaMaterias, List<PROFESOR> listaProfesores) {
        this.listaGrupos = listaGrupos;
        this.listaAlumnos = listaAlumnos;
        this.listaMaterias = listaMaterias;
        this.listaProfesores = listaProfesores;
    }

    public void getListaProfesoresDefault()
    {
        listaProfesores.add(new PROFESOR(1, "Ramiro","Programación",35));
        listaProfesores.add(new PROFESOR(2, "Marcos","Redes",35));
        listaProfesores.add(new PROFESOR(3, "Ana Lilia","Base de datos",40));
        listaProfesores.add(new PROFESOR(4, "Laura","Educación",45));
        listaProfesores.add(new PROFESOR(5, "Carolina","Educación",40));
        listaProfesores.add(new PROFESOR(6, "Cueto","Química",35));
        listaProfesores.add(new PROFESOR(7, "Erick","Matemáticas",28));
        listaProfesores.add(new PROFESOR(8, "Rosales","Electronica",55));
        listaProfesores.add(new PROFESOR(9, "Gloria","Ingles",40));
        listaProfesores.add(new PROFESOR(10, "Delia","Psicología",35));
    }

    public void getListaAlumnosDefault()
    {
        listaAlumnos.add(new ALUMNO(25420012,"Luis Manuel", "Aguilera Montoya", "M","8711002020", "lagui@gmail.com"));
        listaAlumnos.add(new ALUMNO(25420000,"Esteban", "Gutierrez", "M","8755002023", "eGtezz@gmail.com"));
        listaAlumnos.add(new ALUMNO(25410000,"Sofia", "Perez", "F","87432420", "sofy1@gmail.com"));
        listaAlumnos.add(new ALUMNO(25400500,"Lucia", "Aguirre", "F","871242020", "lucinaA3@gmail.com"));
        listaAlumnos.add(new ALUMNO(25420013,"Jose", "Hernandez", "M","8711004343", "josHee@gmail.com"));
    }


    public void getListaGruposDefault()
    {
        listaGrupos.add(new GRUPO(nombre_U, direccion, 1,"3","C","Matutino"));
        listaGrupos.add(new GRUPO(nombre_U, direccion, 2,"3","A","Matutino"));
        listaGrupos.add(new GRUPO(nombre_U, direccion, 3,"2","A","Matutino"));
    }

    public void getListaMateriasDefault()
    {
        listaMaterias.add(new MATERIA(1,"Programación Orientada a Objetos",90));
        listaMaterias.add(new MATERIA(2,"Base de datos",80));
        listaMaterias.add(new MATERIA(3,"Calculo Integral",70));
    }



    public MATERIA CrearMateria()
    {
        System.out.println("\n----- DATOS DE LA MATERIA  -----");
        System.out.print("Ingresa su nombre: ");
        nombre_M = sc.nextLine();
        System.out.print("Ingresa su calificación: ");
        calificacion = sc.nextInt();
        sc.nextLine(); //buffer



        // Creación del objeto MATERIA
        MATERIA materia = new MATERIA(id_m, nombre_M, calificacion);
        id_m++;

        return materia;
    }


    public void Comparar()
    {

    }

    public ALUMNO CrearAlumno()
    {
        System.out.println("\n----- DATOS DEL ALUMNO  -----");
        System.out.print("Ingresa la matricula del alumno: ");
        matricula = sc.nextInt();
        sc.nextLine(); //buffer
        System.out.print("Ingresa el nombre el alumno: ");
        nombre_A = sc.nextLine();
        System.out.print("Ingresa el apellido del alumno: ");
        apellido = sc.nextLine();
        System.out.print("Ingresa el sexo del alumno (F/M): ");
        sexo = sc.nextLine();
        System.out.print("Ingresa el teléfono: ");
        telefono = sc.nextLine();
        System.out.print("Ingresa el correo: ");
        correo = sc.nextLine();

        // Creación del objeto ALUMNO
        ALUMNO alumno = new ALUMNO(matricula, nombre_A, apellido, sexo, telefono, correo);

        return alumno;
    }


    public GRUPO CrearGrupo()
    {
        System.out.println("\n----- DATOS DEL GRUPO -----");
        System.out.print("Ingresa grado del grupo: ");
        grado = sc.nextLine();
        System.out.print("Ingresa la sección del grupo: ");
        seccion = sc.nextLine();
        System.out.print("Ingresa el turno del grupo: ");
        turno= sc.nextLine();


        // Creación del objeto GRUPO
        GRUPO grupo = new GRUPO(nombre_U, direccion, id_g, grado, seccion, turno);
        id_g++;

        return grupo;
    }

    public void AddProfesorToMateria()
    {
        if (!listaProfesores.isEmpty())
        {
            System.out.println("\nLista de materias disponibles:");
            for (MATERIA m : listaMaterias) { System.out.println("ID: " + m.getId_m() + " | Materia: " + m.getNombre_M()); }

            System.out.println("\nLista de profesores disponibles:");
            for (PROFESOR p : listaProfesores) { System.out.println("ID: " + p.getId_p() + " | Profesor: " + p.getNombre_P());}

            System.out.print("\nElija la materia. (Ingrese su ID)... ");
            int id_mTemp = sc.nextInt();
            System.out.print("Elija el profesor a asignar. (Ingrese su ID)... ");
            int id_pTemp = sc.nextInt();
            sc.nextLine();

            // VALIDACIÓN DE SEGURIDAD: Validar que las posiciones existan en las listas
            if ((id_mTemp > 0 && id_mTemp <= id_m) && (id_pTemp > 0 && id_pTemp <= id_p))
            {
                // Extraemos los objetos específicos de cada lista usando .get()
                MATERIA materiaSeleccionada = listaMaterias.get(id_mTemp - 1); //Es -1 porque las listas empieza en 0
                PROFESOR profesorSeleccionado = listaProfesores.get(id_pTemp - 1);

                materiaSeleccionada.setObj_profesor(profesorSeleccionado); // REEMPLAZAMOS EL NULL: Usamos el setter de la materia para meter al profesor
                System.out.println("Registro exitoso!");
            }
            else
            {
                System.out.println("IDs inválidos...");
            }
        }
        else
        {
            System.out.println("No hay profesores registrados...");
        }
    }


    public void AddMateriasToAlumno()
    {
        if (!listaAlumnos.isEmpty()) {

            System.out.println("\nLista de materias disponibles:");
            for (MATERIA m : listaMaterias)
            {
            System.out.println("ID: " + m.getId_m() + " | Materia: " + m.getNombre_M());
            }


            System.out.println("\nLista de alumnos disponibles:");
            for (ALUMNO a : listaAlumnos) {
                System.out.println("ID: " + a.getMatricula() + " | Alumno: " + a.getNombre_A() + " " + a.getApellido());
            }

            System.out.print("\nElija el alumno. (Ingrese su matricula)... ");
            int id_aTemp = sc.nextInt();
            System.out.print("Elija la materia a asignar. (Ingrese su ID)... ");
            int id_mTemp = sc.nextInt();
            sc.nextLine();

            MATERIA materiaSeleccionada = listaMaterias.get(id_mTemp - 1); //Es -1 porque las listas empieza en 0

            for (ALUMNO a : listaAlumnos)
            {
                if (a.getMatricula() == id_aTemp)
                {
                    a.getListaMateriasAlumnos().add(materiaSeleccionada);
                }
                else
                {
                    System.out.println("No hay alumno con esa matricula");
                }
            }
            System.out.println("Registro exitoso!");
        }
        else
        {
            System.out.println("No hay materias registradas...");
        }
    }


    public void AddAlumnosToGrupo()
    {

        if (!listaAlumnos.isEmpty())
        {
            System.out.println("\nLista de alumnos registrados:");
            for (ALUMNO a : listaAlumnos)
            {
            System.out.println("ID: " + a.getMatricula() + " | Materia: " + a.getNombre_A() + " " + a.getApellido());
            }

            System.out.println("\nLista de grupos disponibles:");
            for (GRUPO g : listaGrupos)
            {
                System.out.println("ID: " + g.getId_g() + " | Grado: " + g.getGrado() + "° , " + g.getSeccion());
            }

            System.out.print("\nElija el grupo (Ingrese el ID)... ");
            int id_gTemp = sc.nextInt();
            System.out.print("Elija al alumno a asignar. (Ingrese su matricula)... ");
            int matriculaTemp = sc.nextInt();
            sc.nextLine();
            int posicion = IntStream.range(0,listaAlumnos.size()).filter(i->listaAlumnos.get(i).getMatricula() == matriculaTemp).findFirst().orElse(-1);
            ALUMNO alumnoSeleccionada = listaAlumnos.get(posicion); //Es -1 porque las listas empieza en 0

            for (GRUPO g : listaGrupos)
            {
                if (g.getId_g() == id_gTemp)
                {
                    g.getListaAlumnosGrupos().add(alumnoSeleccionada);
                }
                else
                {
                    System.out.println("No hay grupo con esa ID");
                }
            }
            System.out.println("Registro exitoso!");
        }
        else
        {
            System.out.println("No hay alumnos registrados...");
        }
    }



    //FILTRAR LISTA DE CADA DATO --------------------------------------------------------------
    public <T>ArrayList <T> FiltrarLista(Class <T> nom_Clase)
    {
        ArrayList<T> listaFiltrada = new ArrayList<>();
        if (nom_Clase == PROFESOR.class)
        {
            listaProfesores.forEach(a ->
            {
                listaFiltrada.add(nom_Clase.cast(a));
            });
        }
        else if (nom_Clase == MATERIA.class)
        {
            listaMaterias.forEach(a ->
            {
                listaFiltrada.add(nom_Clase.cast(a));
            });
        }
        else if (nom_Clase == ALUMNO.class)
        {
            listaAlumnos.forEach(a ->
            {
                listaFiltrada.add(nom_Clase.cast(a));
            });
        }
        else if (nom_Clase == GRUPO.class)
        {
            listaGrupos.forEach(g ->{
                listaFiltrada.add(nom_Clase.cast(g));
            });
        }
        return listaFiltrada; //Devuelve una lista de la clase que le envíe como parámetro
    }


    public <T> void MostrarDato(ArrayList <T> listaFiltrada)
    {
        if (!listaFiltrada.isEmpty())
        {
            for (T aT : listaFiltrada) {
                    System.out.println(aT);
            }
        } else
        {
                System.out.println("No hay registros...");
        }
    }

}


/* notas
import java.util.List;
import java.util.stream.IntStream;

int posicion = IntStream.range(0, listaUsuarios.size())
    .filter(i -> listaUsuarios.get(i).getId() == 42)
    .findFirst()
    .orElse(-1); // Retorna -1 si no encuentra el objeto
    ¿Cómo funciona? IntStream.range(0, lista.size()) genera un flujo de números desde 0 hasta el tamaño de la lista.
    Luego, el filter revisa cuál de esos índices tiene el objeto con el atributo que buscas, y findFirst() se queda con el primero que cumpla la condición.


import javax.swing.*;  La librería javax.swing sirve para crear interfaces gráficas de usuario (GUI) en Java.




 */
