
<%@page contentType="text/html" pageEncoding="UTF-8"%>

              
        
        <p>${info}</p>
        <form action="addClient" method="POST">

          <fieldset>
            <legend>Новый клиент</legend>
            <div class="form-group row-cols-4">
              <label class="col-sm-2 col-form-label">Имя клиента:</label> 
              <input type="text" class="form-control" name="clientName" value="${clientName}"><br>

              <label class="col-sm-2 col-form-label">Reg.nr: </label>
              <input type="text" class="form-control" name="regnr" value="${regnr}"><br>

              <label class="col-sm-2 col-form-label">Адрес: </label>
              <input type="text" class="form-control" name="address" value="${address}"><br>

              <label class="col-sm-2 col-form-label">Телефон: </label>
              <input type="text" class="form-control" name="phone" value="${phone}"><br>

              <label for="staticEmail" class="col-sm-2 col-form-label">Э-почта: </label>
              <input type="email" class="form-control"  aria-describedby="emailHelp"  name="email" value="${email}"><br>

            <button type="submit" class="btn btn-primary">Добавить</button> 
           
          </fieldset>
        </form>
        
