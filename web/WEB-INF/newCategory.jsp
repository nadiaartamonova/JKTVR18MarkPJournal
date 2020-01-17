
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
        
        
        <p>${info}</p>
        <form action="addCategory" method="POST">
             
        <fieldset>
            <legend>Новая категория</legend>
            <div class="form-group row-cols-4">
              <label class="col-sm-2 col-form-label">Название:</label> 
              <input type="text" class="form-control" name="categoryName" value="${categoryName}"><br>

              
            <button type="submit" class="btn btn-danger">Добавить</button> 
            <a href="index.jsp"><button type="button" class="btn btn-danger">Главная страница</button> </a>
          </fieldset>
        </form>
