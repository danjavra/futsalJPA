<%-- 
    Document   : status
    Created on : 15-may-2018, 20:53:20
    Author     : Anjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String success = (String) request.getAttribute("success");
            String error = (String) request.getAttribute("error");
            if(success!=null){
        %>
        <h1 style="text-align:center; color:green;"><%= success%></h1>
        <% }else{ %>
        <h2><%=error%></h2>
        <%}%>
        <form action="index.html">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
