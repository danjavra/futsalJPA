/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FutsalDAO;
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
public class Login extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");
        Usuari aux = new Usuari();
        aux.setUsername(nombreUsuario);
        aux.setContrasenya(password);

        Usuari u;
        try {
            u = futsalDAO.getUserByName(aux);
            String contrasenyaOk = futsalDAO.validateUserByPassword(nombreUsuario, password);
            if (contrasenyaOk.equals("false")) {
                request.setAttribute("errorStatus", "Login Failed");
            } else {
                System.out.println("Aqui llego 2");

                request.getSession(true).setAttribute("user", u);

            }
            if (u.getTipo() == 1) {
                System.out.println("Aqui llego 3");

                response.sendRedirect(request.getContextPath() + "/pageEquipo.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/pagePlayer.jsp");
            }

        } catch (SQLException | MiExcepcion ex) {
            System.out.println(ex.getMessage());
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
