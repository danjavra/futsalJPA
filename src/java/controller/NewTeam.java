/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FutsalDAO;
import entities.Equip;
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
public class NewTeam extends HttpServlet {

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
        String ciutat = request.getParameter("ciutat");
        Integer telefon = Integer.parseInt(request.getParameter("telefon"));
        Integer punts = Integer.parseInt(request.getParameter("punts"));

        Usuari u = new Usuari(nombreUsuario, password, tipo);
        Equip e = new Equip(nom, ciutat, telefon, punts,u);

        try {
            System.out.println(u.getUsername());
            futsalDAO.insertarUser(u);
            futsalDAO.insertarTeam(e);
            request.setAttribute("success", "New Team Registered");
        } catch (MiExcepcion ex) {
            request.setAttribute("error", ex.getMessage());
        }
        request.getRequestDispatcher("/estadoAltaJEquipo.jsp").forward(request, response);

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
