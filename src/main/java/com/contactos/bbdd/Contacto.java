package com.contactos.bbdd;

public class Contacto {

    private final long id;
    private final String nombre;
    private final String apellidos;
    private final String email;
    private final String tlf;


    public Contacto(long id, String nombre, String apellidos, String email, String tlf) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tlf = tlf;
    }

    public long getId() {
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
