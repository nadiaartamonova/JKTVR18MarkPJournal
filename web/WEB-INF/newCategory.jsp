<%-- 
    Document   : newCategory
    Created on : Jan 16, 2020, 8:28:41 AM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New category</title>
    </head>
    <body>
        <h1>Добавление новой категории</h1>
        
        
        <p>${info}</p>
        <form action="addCategory" method="POST">
            Название категории: <input type="text" name="categoryName" value="${categoryName}"><br>
                      
            <input type="submit" value="Добавить новою категории">
        </form>
        <a href="index.jsp">Главная страница</a>
    </body>
</html>
