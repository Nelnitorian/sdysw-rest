package com.contactos.common;

public class Contacto {

    private final int id;
    private final String nombre;
    private final String apellidos;
    private final String email;
    private final String tlf;


    public Contacto(int id, String nombre, String apellidos, String email, String tlf) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tlf = tlf;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTlf() {
        return tlf;
    }
    
}
