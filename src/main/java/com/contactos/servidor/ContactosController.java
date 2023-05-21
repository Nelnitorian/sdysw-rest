package com.contactos.servidor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.bbdd.ContactosDAO;
import com.contactos.common.Contacto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.SQLException;
import java.util.List;


@RestController
public class ContactosController {

    //Instanciamos la clase 
    ContactosDAO conDAO = new ContactosDAO();

    //Devuelve una lista con todos los contactos de la agenda
    @CrossOrigin(origins = "*")
    @GetMapping("/contactos")
    public ResponseEntity<List<Contacto>> getTodos() throws SQLException {

        //Consulta a la bbdd
        List<Contacto> contactos = conDAO.leeTodos();

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
    @CrossOrigin(origins = "*")
    @GetMapping("/contactos/{id}")
    public ResponseEntity<Contacto> getContacto(@PathVariable(value = "id") int id) throws SQLException {

        //Consulta a la bbdd
        Contacto contacto = conDAO.lee(id);

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
    @CrossOrigin(origins = "*")
    @PostMapping("/contactos")
    public ResponseEntity<Contacto> addContacto(@RequestParam(value = "nombre", defaultValue = "Nombre") String nombre,
            @RequestParam(value = "apellidos") String apellidos,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "tlf") String tlf) throws SQLException {

        Contacto contacto = new Contacto(-1, nombre, apellidos, email, tlf);

        //Consulta a la bbdd
        Contacto contacto_creado = conDAO.crea(contacto);

        
        //Gestionamos la respuesta HTTP
        if (contacto_creado == null) {
            System.out.println("No se ha podido añadir el contacto.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Añadido satisfactoriamente el contacto con id: " + contacto_creado.getId());
            return new ResponseEntity<>(contacto_creado, HttpStatus.OK);
        }
}

    //Edita un contacto de la agenda
    @CrossOrigin(origins = "*")
    @PutMapping("/contactos/{id}")
    public ResponseEntity<Contacto> updateContacto(
        @PathVariable(value = "id") int id,
        @RequestParam(value = "nombre") String nombre,
        @RequestParam(value = "apellidos") String apellidos,
        @RequestParam(value = "email") String email,
        @RequestParam(value = "tlf") String tlf) throws SQLException {

        Contacto contacto = new Contacto(id, nombre, apellidos, email, tlf);

        //Consulta a la bbdd
        Contacto contacto_actualizado = conDAO.actualiza(contacto);

        //Gestionamos la respuesta HTTP
        if (contacto_actualizado == null) {
            System.out.println("No se ha podido editar el contacto.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Editado satisfactoriamente el contacto con id: " + contacto_actualizado.getId());
            return new ResponseEntity<>(contacto_actualizado, HttpStatus.OK);
        }
    }

    //Elimina un contacto de la agenda
    @CrossOrigin(origins = "*")
    @DeleteMapping("/contactos/{id}")
    public ResponseEntity<Contacto> deleteContacto(@PathVariable(value = "id") int id) {

        //Gestionamos la respuesta HTTP
        try{
            //Consulta a la bbdd
            conDAO.borra(id);

            System.out.println("Eliminado satisfactoriamente el contacto con id: " + id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (SQLException e){
            System.out.println("No se ha podido eliminar el contacto.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}