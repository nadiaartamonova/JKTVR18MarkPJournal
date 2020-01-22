<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

              
        
        <p>${info}</p>
        <form action="addOrder" method="POST">

          <fieldset>
            <legend>Новый заказ</legend>
            <div class="form-group row-cols-4">
              <label class="col-sm-2 col-form-label">Наименование:</label> 
              <input type="text" class="form-control" name="orderName" value="${orderName}"><br>

              <label class="col-sm-2 col-form-label">Клиент: </label>
              
              <select name="client" class="form-control">
                <option value="" hidden=""></option>
                <c:forEach var="client" items="${listAllClients}">
                    <option value="${client.id}">${client.clientName}</option>
                </c:forEach>
              </select><br>
              
              <label class="col-sm-2 col-form-label">Сумма заказа: </label>
              <input type="currency" class="form-control" name="summa" value="${summa}"><br> 
              
              <label class="col-sm-2 col-form-label">Начало работы: </label>
              <input type="date" class="form-control" name="dateStart" value="${dateStart}"><br>

              <label class="col-sm-2 col-form-label">Окончание работы:  </label>
              <input type="date" class="form-control" name="dateFinish" value="${dateFinish}"><br>
              
              <label class="col-sm-2 col-form-label">Категория:  </label>
              <select name="category" class="form-control" id="categoriesList">
                <option value="" hidden=""></option>
                <c:forEach var="category" items="${listAllCategories}">
                    <option value="${category.id}">${category.categoryName}</option>
                </c:forEach>
              </select><br>
              
              <label class="col-sm-2 col-form-label" hidden = true>Подкатегория:  </label>
              <select name="subCategory" class="form-control" id="subCategoryList" hidden = true>
                <option value="" hidden=""></option>
                <c:forEach var="subCategory" items="${listAllSubCategories}">
                    <option value="${subCategory.id}">${subCategory.subCategoryName}</option>
                </c:forEach>
              </select><br>

            <button type="submit" class="btn btn-primary">Добавить</button> 
           
          </fieldset>
        </form>
              
