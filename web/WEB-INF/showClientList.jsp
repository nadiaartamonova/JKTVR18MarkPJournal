<%-- 
    Document   : showClientList
    Created on : Jan 15, 2020, 10:36:35 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Список киентов:</h1>
   
            <ul>
                <c:forEach var="client" items="${listAllClients}" varStatus="num">
                    <li>
                        ${num.index + 1}. ${client.clientName}. 
                        
                    </li>
                </c:forEach>
            </ul>
            <br>
             <a href="index">Главная страница</a>
    </body>
</html>
