/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.futsalEJB;
import entities.Usuari;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author serra
 */
public class NewUser extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
    String username=request.getParameter("user");
    String contrasenya=request.getParameter("contrasenya");
    Integer tipo=Integer.parseInt(request.getParameter("tipo"));
    
    
    Usuari u = new Usuari (username,contrasenya,tipo);
    
    try{
   // necessita modificacion
        futsalEJB.altaUser(u);
        request.setAttribute("status","Empleado dado de alta");
    
    
    }catch(Exception e){
    request.setAttribute("status", e.getMessage());
    
    
    }
    //falta documento en dispatcher
    request.getRequestDispatcher(??).forward(request,response);
    
    
    }
        @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
 
 processRequest(request,response);
 
 }
 
    @Override
  public String getServletInfo(){
  return "Short description";
  }  
    
}
}
