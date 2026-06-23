package org.example;

public class PROFESOR
{

    private String nombre_P;
    private String especialidad;
    private int edad;
    private int id_p;

    public String getNombre_P() { return nombre_P; }
    public void setNombre_P(String nombre_P) { this.nombre_P = nombre_P; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public int getId_p() { return id_p; }
    public void setId_p(int id_p) { this.id_p = id_p; }

    public PROFESOR(int id_p, String nombre_P, String especialidad, int edad)
    {
        this.id_p = id_p;
        this.nombre_P = nombre_P;
        this.especialidad = especialidad;
        this.edad = edad;
    }


    @Override
    public String toString()
    {
        return "PROFESOR: {ID_Profesor = " + id_p + ", nombre = " + nombre_P  + ", especialidad = " + especialidad + ", edad = " + edad + "}";
    }

}
