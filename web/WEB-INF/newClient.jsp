<%-- 
    Document   : newClient
    Created on : Jan 15, 2020, 9:26:40 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добавление нового клиента</h1>
        
        
        <p>${info}</p>
        <form action="addClient" method="POST">
            Название: <input type="text" name="clientName" value="${clientName}"><br>
            Reg.nr: <input type="text" name="regnr" value="${regnr}"><br>
            Адресс: <input type="text" name="address" value="${address}"><br>
            Телефон: <input type="text" name="phone" value="${phone}"><br>
            Э-почта: <input type="text" name="email" value="${email}"><br>
          
            <input type="submit" value="Добавить нового клиента">
        </form>
        <a href="index.jsp">Главная страница</a>
        
    </body>
</html>
