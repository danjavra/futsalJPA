/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author serra
 */
public class Login extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
        String username=request.getParameter("user");
        String password=request.getParameter("pass");
        
        request.getSession(true).setAttribute("user",username);
        request.sendRedirect(request.getContextPath() + "/userValidado.jsp");
        
        
    
    
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
