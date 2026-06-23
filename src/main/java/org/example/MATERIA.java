package org.example;

import java.util.List;

public class MATERIA
{
    private String nombre_M;
    private int  calificacion;
    private int id_m;
    private PROFESOR obj_profesor;

    public String getNombre_M() { return nombre_M; }
    public void setNombre_M(String nombre_M) { this.nombre_M = nombre_M; }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    public int getId_m() { return id_m; }
    public void setId_m(int id_m) { this.id_m = id_m; }

    public PROFESOR getObj_profesor() { return obj_profesor; }
    public void setObj_profesor(PROFESOR obj_profesor) { this.obj_profesor = obj_profesor; }


    public MATERIA(int id_m, String nombre_M, int calificacion)
    {
        this.id_m = id_m;
        this.nombre_M = nombre_M;
        this.calificacion = calificacion;
        this.obj_profesor = null;
    }

    @Override
    public String toString()
    {
        if (obj_profesor != null)
        {
            return "MATERIA: {Materia = " + nombre_M + ", calificación = " + calificacion + "} - " +  obj_profesor;
        }
        return "MATERIA: {Materia = " + nombre_M + ", calificación = " + calificacion + "}";

    }
}
