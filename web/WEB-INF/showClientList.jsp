

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <h1>Список киентов:</h1>
   
            <ul>
                <c:forEach var="client" items="${listAllClients}" varStatus="num">
                    <li>
                        ${num.index + 1}. ${client.clientName}. 
                        
                    </li>
                </c:forEach>
            </ul>
            <br>
             
            <a href="index.jsp"><button type="button" class="btn btn-danger">Главная страница</button> </a>

