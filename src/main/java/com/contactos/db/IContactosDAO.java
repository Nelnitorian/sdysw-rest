package com.vutarem.db;

import java.sql.SQLException;

import com.vutarem.common.Votante;

import java.util.List;

public interface IContactosDAO {

    public void crea(Contacto persona) throws SQLException;

    public void borra(int id) throws SQLException;

    public void actualiza(int id, Contacto contacto) throws SQLException;

    public Contacto lee(int id) throws SQLException;

    public List<Contacto> leeTodos() throws SQLException;
}
