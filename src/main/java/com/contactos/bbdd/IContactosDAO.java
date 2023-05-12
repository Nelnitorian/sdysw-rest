package com.contactos.bbdd;

import java.sql.SQLException;
import java.util.List;

import com.contactos.common.Contacto;

public interface IContactosDAO {

    public Contacto crea(Contacto persona) throws SQLException;

    public void borra(int id) throws SQLException;

    public Contacto actualiza(Contacto contacto) throws SQLException;

    public Contacto lee(int id) throws SQLException;

    public List<Contacto> leeTodos() throws SQLException;
}
