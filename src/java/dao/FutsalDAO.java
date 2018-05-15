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
public void insertarPlayer(Player p) throws SQLException, MiExcepcion {
        if (existePlayer(p)) {
            throw new MiExcepcion("ERROR: Ya existe un player con ese nombre");
        } else {
            // Definimos la consulta
            String insert = "insert into cocinero values (?, ?, ?, ?, ?, ?, ?)";
            // Necesitamos preparar la consulta parametrizada
            PreparedStatement ps = conexion.prepareStatement(insert);
            // Le damos valor a los interrogantes
            ps.setInt(1, p.getIdplayer());
            ps.setString(2, p.getNom());
            ps.setString(3, p.getPosicio());
            ps.setInt(4, p.getEdat());
            ps.setString(5, p.getEquip());
            ps.setInt(6, p.getMvp());
            ps.setString(7, p.getUser());
            // Ejecutamos la consulta
            ps.executeUpdate();
            // cerramos recursos
            ps.close();
        }
    }
public void insertarTeam(Equip e) throws SQLException, MiExcepcion {
        if (existeEquipo(e)) {
            throw new MiExcepcion("ERROR: Ya existe un equipo con ese nombre");
        } else {
            // Definimos la consulta
            String insert = "insert into equip values (?, ?, ?, ?, ?, ?, ?)";
            // Necesitamos preparar la consulta parametrizada
            PreparedStatement ps = conexion.prepareStatement(insert);
            // Le damos valor a los interrogantes
            
            ps.setString(1, e.getNom());
            ps.setString(3, e.getCiutat());
            ps.setInt(4, e.getTelefon());
            ps.setInt(5, e.getPunts());
            ps.setInt(6, e.getUser());
            // Ejecutamos la consulta
            ps.executeUpdate();
            // cerramos recursos
            ps.close();
        }
    }
         private void insertPartido(Partit equip1, Partit equip2) throws SQLException {
        String insert = "insert into partit (equip1,equip2) values (?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setObject(1,equip1.getEquip1());
        ps.setObject(2,equip2.getEquip2());
        ps.executeUpdate();
        ps.close();
    }

 // ********************* Funciones auxiliares ****************************
    private boolean existePlayer(Player p) throws SQLException {
        String select = "select * from player where nom='" + p.getNom() + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        return existe;
    }
     private boolean existeEquipo(Equip e) throws SQLException {
        String select = "select * from equip where nom='" + e.getNom() + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        return existe;
    }
     

      // ********************* Selects ****************************
     
     // ********************* Update ****************************
     public void modificarUserName(Usuari user, String newUsername) throws SQLException {
        Statement st = conexion.createStatement();
        String updateUsername = "update usuari set username = '" + newUsername + "' where username = '" + user.getUsername() + "'";
        st.executeUpdate(updateUsername);
        System.out.println("Se ha modificado correctamente el nombre del usuario " + user.getUsername());
        st.close();

    }
     
       public void modificarPlayerTeam(Player player, String newTeam) throws SQLException {
        Statement st = conexion.createStatement();
        String updateTeam = "update player set equip = '" + newTeam + "' where equip = '" + player.getEquip() + "'";
        st.executeUpdate(updateTeam);
        System.out.println("Se ha modificado correctamente el nombre del usuario " + player.getEquip());
        st.close();

    }
     
     
     

       // ********************* Conectar / Desconectar ****************************
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/futsal";
        String user = "root";
        String pass = "root";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
