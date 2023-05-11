package com.contactos.servidor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.bbdd.Contacto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
public class ContactoController {

    //Devuelve una lista con todos los contactos de la agenda
    @GetMapping("/contactos")
    public ResponseEntity<List<Contacto>> getTodos() {

        //Consulta a la bbdd
        List<Contacto> contactos = getTodos();

        //Gestionamos la respuesta HTTP
        if (contactos.isEmpty()) {
            System.out.println("No hay ningún contacto en la agenda.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Obtenidos satisfactoriamente todos los contactos de la agenda.");
            return new ResponseEntity<>(contactos, HttpStatus.OK);
        }
    }

    //Devuelve un contacto según su id
    @GetMapping("/contactos/{id}")
    public ResponseEntity<Contacto> getContacto(@RequestParam(value = "id", defaultValue = "0") long id) {

        //Consulta a la bbdd
        Contacto contacto = getContacto(id);

        //Gestionamos la respuesta HTTP
        if (contacto == null) {
            System.out.println("No existe ningún contacto con ese id.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Obtenido satisfactoriamente el contacto con id: " + id);
            return new ResponseEntity<>(contacto, HttpStatus.OK);
        }
    }

    //Añade un contacto a la agenda
    @PostMapping("/contactos")
    public ResponseEntity<Contacto> addContacto(@RequestParam(value = "nombre", defaultValue = "Nombre") String nombre,
            @RequestParam(value = "apellidos", defaultValue = "Apellidos") String apellidos,
            @RequestParam(value = "email", defaultValue = "Email") String email,
            @RequestParam(value = "tlf", defaultValue = "Tlf") String tlf) {

        //Consulta a la bbdd
        Contacto contacto = addContacto(nombre, apellidos, email, tlf);

        //Gestionamos la respuesta HTTP
        if (contacto == null) {
            System.out.println("No se ha podido añadir el contacto.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Añadido satisfactoriamente el contacto con id: " + contacto.getId());
            return new ResponseEntity<>(contacto, HttpStatus.OK);
        }
    }

    //Edita un contacto de la agenda
    @PutMapping("/contactos/{id}")
    public ResponseEntity<Contacto> updateContacto(@RequestParam(value = "nombre", defaultValue = "Nombre") String nombre,
            @RequestParam(value = "apellidos", defaultValue = "Apellidos") String apellidos,
            @RequestParam(value = "email", defaultValue = "Email") String email,
            @RequestParam(value = "tlf", defaultValue = "Tlf") String tlf) {

        //Consulta a la bbdd
        Contacto contacto = updateContacto(nombre, apellidos, email, tlf);

        //Gestionamos la respuesta HTTP
        if (contacto == null) {
            System.out.println("No se ha podido editar el contacto.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Editado satisfactoriamente el contacto con id: " + contacto.getId());
            return new ResponseEntity<>(contacto, HttpStatus.OK);
        }
    }

    //Elimina un contacto de la agenda
    @DeleteMapping("/contactos/{id}")
    public ResponseEntity<Contacto> deleteContacto(@RequestParam(value = "id", defaultValue = "0") long id) {

        //Consulta a la bbdd
        Contacto contacto = deleteContacto(id);

        //Gestionamos la respuesta HTTP
        if (contacto == null) {
            System.out.println("No se ha podido eliminar el contacto.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Eliminado satisfactoriamente el contacto con id: " + contacto.getId());
            return new ResponseEntity<>(contacto, HttpStatus.OK);
        }
    }



}