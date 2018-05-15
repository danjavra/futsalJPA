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
