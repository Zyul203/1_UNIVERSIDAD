package org.example;

public class UNIVERSIDAD
{
    protected String nombre_U;
    protected String direccion;

    public String getNombre_U() { return nombre_U; }
    public void setNombre_U(String nombre_U) { this.nombre_U = nombre_U; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }



    public UNIVERSIDAD(String nombre_U, String direccion)
    {
        this.nombre_U = nombre_U;
        this.direccion = direccion;
    }

}
