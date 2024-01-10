package com.example.prcticatema2.Entidades;

/**
 * Esta clase representa una nota y sus atributos, esta nos servira
 * posteriormente para usarla en las bases de datos.
 */
public class Notas {

    private int id;
    private String nombre, descripcion, fecha, telefono;

    /**
     * Constructor por defecto de los atributos de una nota.
     */
    public Notas(){
        id = -1;
        nombre = "";
        descripcion = "";
        fecha = "";
        telefono = "";
    }

    /**
     * Constructor por parametros de los atributos de una nota.
     *
     * @param no String nombre,
     * @param des String descripcion,
     * @param fyh String fecha y Hora,
     * @param con String telefono.
     */
    public Notas(int id, String no, String des, String fyh, String con){
        this.id = id;
        nombre = no;
        descripcion = des;
        fecha = fyh;
        telefono = con;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
