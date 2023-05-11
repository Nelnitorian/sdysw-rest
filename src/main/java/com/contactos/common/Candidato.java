package com.vutarem.common;

import java.io.Serializable;

public class Contacto implements Serializable{
    
    private int id = 0;
    private String nombre = null;
    private String apellidos = null;
    private String email = null;
	private String telefono = null;
    
    public Contacto(int id, String nombre, String apellidos, String email, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
		this.telefono = telefono;
    }
    
    public Contacto(String nombre, String apellidos, String email, String telefono){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
		this.telefono = telefono;
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
	
	public String getTelefono() {
		return telefono;
	}


}

