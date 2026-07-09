package org.example;

import java.util.ArrayList;
import java.util.List;

public class ALUMNO
{
    private int matricula;
    private String nombre_A;
    private String apellido;
    private String sexo;
    private String telefono;
    private String correo;
    private List<MATERIA> listaMateriasAlumnos;



    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    public String getNombre_A() { return nombre_A; }
    public void setNombre_A(String nombre_A) { this.nombre_A = nombre_A; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public List<MATERIA> getListaMateriasAlumnos() { return listaMateriasAlumnos; }
    public void setListaMateriasAlumnos(List<MATERIA> listaMateriasAlumnos) { this.listaMateriasAlumnos = listaMateriasAlumnos; }

    public ALUMNO(int matricula, String nombre_A, String apellido, String sexo, String telefono, String correo)
    {
        this.matricula = matricula;
        this.nombre_A = nombre_A;
        this.apellido = apellido;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
        this.listaMateriasAlumnos = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        String texto = "ALUMNO: {Matricula = " + matricula + ", nombre_A = " + nombre_A + ", apellido = " + apellido + ", sexo =  " + sexo + ", teléfono =  " + telefono + ", correo = " + correo + "}";
        for (MATERIA m : listaMateriasAlumnos)
        {
            texto += "\n                * " + m.toString();
        }

        return texto;
    }
}
