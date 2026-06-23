package org.example;

import java.util.ArrayList;
import java.util.List;

public class GRUPO extends UNIVERSIDAD
{
    private String grado;
    private String seccion;
    private String turno;
    private int id_g;
    private List<ALUMNO> listaAlumnosGrupos;


    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }

    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public int getId_g() { return id_g; }
    public void setId_g(int id_g) { this.id_g = id_g; }

    public List<ALUMNO> getListaAlumnosGrupos() { return listaAlumnosGrupos; }
    public void setListaAlumnosGrupos(List<ALUMNO> listaAlumnosGrupos) { this.listaAlumnosGrupos = listaAlumnosGrupos; }


    public GRUPO(String nombre_U, String direccion, int id_g, String grado, String seccion, String turno)
    {
        super(nombre_U, direccion);
        this.id_g = id_g;
        this.grado = grado;
        this.seccion = seccion;
        this.turno = turno;
        this.listaAlumnosGrupos = new ArrayList<>();

    }

    @Override
    public String toString()
    {
        String texto =  "UNIVERSIDAD: {" + nombre_U +". Dirección: " + direccion +"} | GRUPO: { " + grado + "° " + seccion + ", turno = " + turno + "}";

        for (ALUMNO a : listaAlumnosGrupos)
        {
            texto += "\n        * " + a.toString();
        }

        return texto;
    }

}
