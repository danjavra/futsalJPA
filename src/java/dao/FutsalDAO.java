/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import excepciones.MiExcepcion;
import entities.Equip;
import entities.Partit;
import entities.Player;
import entities.Resultat;
import entities.Usuari;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anjo
 */
public class FutsalDAO {

    private Connection conexion;

    // ********************* Inserts ****************************
    public void insertarUser(Usuari u) throws SQLException, MiExcepcion {
        conectar();
        if (existeUsuari(u)) {
            throw new MiExcepcion("ERROR: Ya existe un usuario con este nombre");
        } else {
            // Definimos la consulta
            String insert = "insert into usuari values (?, ?, ?)";
            // Necesitamos preparar la consulta parametrizada
            PreparedStatement ps = conexion.prepareStatement(insert);
            // Le damos valor a los interrogantes
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getContrasenya());
            ps.setInt(3, u.getTipo());
            // Ejecutamos la consulta
            ps.executeUpdate();
            // cerramos recursos
            ps.close();
            desconectar();
        }
    }

    public void insertarPlayer(Player p) throws SQLException, MiExcepcion {

        conectar();
        if (existePlayer(p)) {
            throw new MiExcepcion("ERROR: Ya existe un player con ese nombre");
        } else {
            // Definimos la consulta
            String insert = "insert into player values (?, ?, ?, ?, ?, ?, ?)";
            // Necesitamos preparar la consulta parametrizada
            PreparedStatement ps = conexion.prepareStatement(insert);
            // Le damos valor a los interrogantes
            ps.setInt(1, p.getIdplayer());
            ps.setString(2, p.getNom());
            ps.setString(3, p.getPosicio());
            ps.setInt(4, p.getEdat());
            ps.setString(5, p.getEquip().getNom());
            ps.setInt(6, p.getMvp());
            ps.setString(7, p.getUser().getUsername());
            // Ejecutamos la consulta
            ps.executeUpdate();
            // cerramos recursos
            ps.close();
            desconectar();
        }
    }

    public void insertarTeam(Equip e) throws SQLException, MiExcepcion {
        conectar();
        if (existeEquipo(e)) {
            throw new MiExcepcion("ERROR: Ya existe un equipo con ese nombre");
        } else {
            // Definimos la consulta
            String insert = "insert into equip values (?, ?, ?, ?, ?)";
            // Necesitamos preparar la consulta parametrizada
            PreparedStatement ps = conexion.prepareStatement(insert);
            // Le damos valor a los interrogantes

            ps.setString(1, e.getNom());
            ps.setString(2, e.getCiutat());
            ps.setInt(3, e.getTelefon());
            ps.setInt(4, e.getPunts());
            ps.setObject(5, e.getUser());
            // Ejecutamos la consulta
            ps.executeUpdate();
            // cerramos recursos
            ps.close();
            desconectar();
        }
    }
// hi ha alguna cosa malament en la consulta sql crec

    private void insertPartido(Partit equip1, Partit equip2) throws SQLException {
        conectar();

        String insert = "insert into partit (equip1,equip2) values (?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setObject(1, equip1.getEquip1());
        ps.setObject(2, equip2.getEquip2());
        ps.executeUpdate();
        ps.close();
        desconectar();
    }

    // ********************* Funciones auxiliares ****************************
    private boolean existePlayer(Player p) throws SQLException {
        conectar();
        String select = "select * from player where nom='" + p.getNom() + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        desconectar();
        return existe;
    }

    private boolean existeEquipo(Equip e) throws SQLException {
        conectar();
        String select = "select * from equip where nom='" + e.getNom() + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        desconectar();
        return existe;
    }

    private boolean existeUsuari(Usuari e) throws SQLException {
        conectar();
        String select = "select * from usuari where username='" + e.getUsername() + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        desconectar();
        return existe;

    }

    private boolean existePartit(Partit p) throws SQLException {
        conectar();
        String select = "select * from partit where Idpartit='" + p.getIdpartit() + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        desconectar();
        return existe;
    }

    public String validateUserByPassword(String username, String contrasenya) throws SQLException, MiExcepcion {
        conectar();
        String select = "select * from usuari where username = '" + username + "' and contrasenya = '" + contrasenya + "' ";
        Statement st = conexion.createStatement();
        String validate = "false";
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            validate = "true";
        }
        rs.close();
        st.close();
        desconectar();
        return validate;
    }

    public Usuari getUserByName(Usuari a) throws SQLException, MiExcepcion {
        conectar();
        Usuari aux = new Usuari();
        aux.setUsername(a.getUsername());
        if (!existeUsuari(aux)) {
            throw new MiExcepcion("No existe un usuario con ese nombre");
        } else {
            String select = "select * from usuari where username='" + a.getUsername() + "'";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(select);
            if (rs.next()) {
                a.setUsername(a.getUsername());
                a.setContrasenya(rs.getString("contrasenya"));
                a.setTipo(rs.getInt("tipo"));

            }
            rs.close();
            st.close();
            desconectar();
            return a;
        }
    }
//********************* Deletes****************************

    public void DeleteUser(Usuari e) throws SQLException, MiExcepcion {
        conectar();
        if (!existeUsuari(e)) {
            throw new MiExcepcion("ERROR: no existe user");
        } else {
            // Definimos la consulta
            String delete = "delete from user where username = " + e.getUsername();
            // Necesitamos preparar la consulta parametrizada
            PreparedStatement ps = conexion.prepareStatement(delete);
            // Le damos valor a los interrogantes
            System.out.println("Se ha eliminado correctamente");

            // Ejecutamos la consulta
            ps.executeUpdate(delete);
            // cerramos recursos
            ps.close();
            desconectar();
        }
    }

    //********************* Selects ****************************
    //********************* Update ****************************
    public void modificarUserUsername(Usuari user, String newUsername) throws SQLException {
        Statement st = conexion.createStatement();
        String updateUserUsername = "update usuari set username = '" + newUsername + "' where username = '" + user.getUsername() + "'";
        st.executeUpdate(updateUserUsername);
        System.out.println("Se ha modificado correctamente el nombre del usuario " + user.getUsername());
        st.close();
        desconectar();

    }

    public void modificarPlayerTeam(Player player, String newTeam) throws SQLException {
        Statement st = conexion.createStatement();
        String updateTeam = "update player set equip = '" + newTeam + "' where equip = '" + player.getEquip() + "'";
        st.executeUpdate(updateTeam);
        System.out.println("Se ha modificado correctamente el nombre del usuario " + player.getEquip());
        st.close();
        desconectar();

    }

    // ********************* Conectar / Desconectar ****************************
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/futsal";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
