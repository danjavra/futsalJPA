<%-- 
    Document   : pageEquipo
    Created on : 15-may-2018, 18:23:39
    Author     : Anjo
--%>

<%@page import="entities.Usuari"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            Usuari user = (Usuari) session.getAttribute("user");
            if(user !=null){
        %>
        <h1>Página del Equipo <%=user.getUsername()%></h1>
        <div>
            <form action="DeleteJugador">
                <input type="hidden" value="<%=user.getUsername()%>" name="jugador">
                <input type="submit" value="Delete Jugador">
            </form>
        </div>
           <%
        }else {
        %>
        <h2>LogIn failed</h2>
        <form action="index.html">
            <input type="submit" value="Back">
        </form>
        <%
        }
        %>
        
    </body>
</html>
