/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FutsalDAO;
import entities.Equip;
import entities.Player;
import entities.Usuari;
import excepciones.MiExcepcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anjo
 */
public class NewPlayer extends HttpServlet {
 FutsalDAO futsalDAO = new FutsalDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MiExcepcion {
        String nombreUsuario = request.getParameter("username");
        String password = request.getParameter("contrasenya");
        Integer tipo = Integer.parseInt(request.getParameter("tipo"));
        String nom = request.getParameter("nom");
        String posicio = request.getParameter("posicio");
        Integer edat = Integer.parseInt(request.getParameter("edat"));
        Equip equip = null;
        Integer mvp = 0;
        
        Usuari u = new Usuari(nombreUsuario, password, tipo);
        Player p = new Player(nom, posicio, edat, equip, mvp, u);
        

        try{
            System.out.println(u.getUsername());
            futsalDAO.insertarUser(u);
            futsalDAO.insertarPlayer(p);
            request.setAttribute("success", "New Empleado Registered");
        }catch(MiExcepcion ex){
            request.setAttribute("error",ex.getMessage());
        }
        request.getRequestDispatcher("/estadoAltaJugador.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try {
         processRequest(request, response);
     } catch (SQLException ex) {
         Logger.getLogger(NewPlayer.class.getName()).log(Level.SEVERE, null, ex);
     } catch (MiExcepcion ex) {
         Logger.getLogger(NewPlayer.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try {
         processRequest(request, response);
     } catch (SQLException ex) {
         Logger.getLogger(NewPlayer.class.getName()).log(Level.SEVERE, null, ex);
     } catch (MiExcepcion ex) {
         Logger.getLogger(NewPlayer.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
