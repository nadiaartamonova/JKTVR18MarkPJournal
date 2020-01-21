

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>${info}</p>
        <form action="changeClient" method="POST">

          <fieldset>
            <legend>Клиент</legend>
            <div class="form-group row-cols-4">
              <input type="hidden" name="clientId" value="${client.id}">
              <label class="col-sm-2 col-form-label">Имя клиента:</label> 
              <input type="text" class="form-control" name="clientName" value="${client.clientName}"><br>

              <label class="col-sm-2 col-form-label">Reg.nr: </label>
              <input type="text" class="form-control" name="regnr" value="${client.regnr}"><br>

              <label class="col-sm-2 col-form-label">Адрес: </label>
              <input type="text" class="form-control" name="address" value="${client.address}"><br>

              <label class="col-sm-2 col-form-label">Телефон: </label>
              <input type="text" class="form-control" name="phone" value="${client.phone}"><br>

              <label for="staticEmail" class="col-sm-2 col-form-label">Э-почта: </label>
              <input type="email" class="form-control"  aria-describedby="emailHelp"  name="email" value="${client.email}"><br>

            <button type="submit" class="btn btn-primary">Изменить</button> 
           
          </fieldset>
        </form>
