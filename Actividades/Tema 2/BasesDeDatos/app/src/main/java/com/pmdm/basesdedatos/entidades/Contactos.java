package com.pmdm.basesdedatos.entidades;

public class Contactos {
    private int id;
    private String nombre;
    private String telefono;
    private String email;

    public Contactos() {
        this.id = -1;
        this.nombre = "";
        this.telefono = "";
        this.email = "";
    }

    public Contactos(int id, String nombre, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Contactos(Contactos other) {
        this.id = other.id;
        this.nombre = other.nombre;
        this.telefono = other.telefono;
        this.email = other.email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contactos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
