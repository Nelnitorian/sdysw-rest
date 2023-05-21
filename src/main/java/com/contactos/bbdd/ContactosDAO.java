package com.contactos.bbdd;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.contactos.common.Contacto;

import java.util.List;
import java.util.ArrayList;

public class ContactosDAO implements IContactosDAO{
    private static final String TABLE = "contactos";

    public ContactosDAO(){
    }

    public Contacto crea(Contacto persona) throws SQLException{
        final String QUERY_CREA = "INSERT INTO "+TABLE+" (nombre, apellidos, email, telefono) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_CREA);

        st.setString(1, persona.getNombre());
        st.setString(2, persona.getApellidos());
        st.setString(3, persona.getEmail());
        st.setString(4, persona.getTlf());
        
        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return lee(leeId(persona.getNombre(), persona.getApellidos(), persona.getEmail(), persona.getTlf()));
    }

    public void borra(int id) throws SQLException{
        final String QUERY_BORRA = "DELETE FROM "+TABLE+" WHERE id=?";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_BORRA);
        st.setInt(1, id);

        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;

    }

    public Contacto actualiza(Contacto persona) throws SQLException{
        final String QUERY_ACTUALIZA = "UPDATE "+TABLE+" SET nombre = ?, apellidos = ?, email = ?, telefono = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_ACTUALIZA);
        st.setString(1, persona.getNombre());
        st.setString(2, persona.getApellidos());
        st.setString(3, persona.getEmail());
        st.setString(4, persona.getTlf());

        st.setInt(5, persona.getId());

        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return lee(persona.getId());

        
    }

    public Contacto lee(int id) throws SQLException{
        final String QUERY_LEE = "SELECT * FROM "+TABLE+" WHERE id = ? ";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Contacto contac = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE);
        st.setInt(1, id);

        rs = st.executeQuery();

        while (rs.next()) {
            contac = new Contacto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            break;
        }

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }

        return contac;
    }

    public List<Contacto> leeTodos() throws SQLException{
        final String QUERY_LEE_TODOS = "SELECT * FROM "+TABLE+" ORDER BY nombre, apellidos";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Contacto contac = null;
        ArrayList<Contacto> lst = new ArrayList<Contacto>();

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE_TODOS);

        rs = st.executeQuery();

        while (rs.next()) {
            contac = new Contacto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            lst.add(contac);
        }

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }

        return lst;
    }

    private int leeId(String nombre, String apellidos, String email, String telefono) throws SQLException{
        final String QUERY_LEE = "SELECT * FROM "+TABLE+" WHERE nombre = ? AND apellidos = ? AND email = ? AND telefono = ?";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        int id = -1;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE);
        st.setString(1, nombre);
        st.setString(2, apellidos);
        st.setString(3, email);
        st.setString(4, telefono);

        rs = st.executeQuery();

        while (rs.next()) {
            id = rs.getInt(1);
            break;
        }

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }

        return id;
    }
}
