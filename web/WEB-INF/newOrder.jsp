<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

              
        
        <p>${info}</p>
        
        <form action="addOrder" method="POST" style=" padding: 0;">
            
                    <div class="form-group row">
                        <h3 style=" padding: 0;" class="col-sm-12">Новый заказ </h3>
                        <label class="col-sm-2 control-label" style=" padding: 0;">Наименование:</label>
                        <div class="col-sm-10" style=" padding: 0;">
                            <input type="text" class="form-control" name="orderName" value="${orderName}" >
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label" style=" padding: 0;">Клиент: </label>
                        <div class="col-sm-10" style=" padding: 0;">
                            <select name="client" class="form-control" >
                              <option value="" hidden=""></option>
                              <c:forEach var="client" items="${listAllClients}">
                                  <option value="${client.id}">${client.clientName}</option>
                              </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label" style=" padding: 0;">Сумма заказа: </label>
                        <div class="col-sm-10" style=" padding: 0;">
                            <input type="currency" class="form-control" name="summa" value="${summa}"> 
                        </div>
                    </div>    

                    <div class="form-group row">    
                        <label class="col-sm-2 control-label" style=" padding: 0;">Начало работы: </label>
                        <div class="col-sm-10" style=" padding: 0;">
                            <input type="date" class="form-control" name="dateStart" value="${dateStart}">
                        </div>
                    </div>

                    <div class="form-group row">    
                        <label class="col-sm-2 control-label" style=" padding: 0;">Окончание работы:  </label>
                        <div class="col-sm-10" style=" padding: 0;">
                            <input type="date" class="form-control" name="dateFinish" value="${dateFinish}">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label" style=" padding: 0;">Категория:  </label>
                        <div class="col-sm-10" style=" padding: 0;">
                            <select name="category" class="form-control" id="category">
                              <option value="" hidden=""></option>
                              <c:forEach var="category" items="${listAllCategories}">
                                  <option value="${category.id}">${category.categoryName}</option>
                              </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">    
                        <label class="col-sm-2 control-label" id="subCategoryListLabel" style="display: none; padding: 0;">Подкатегория:  </label>
                        <div class="col-sm-10" style=" padding: 0;">
                            <select name="subCategory" class="form-control" id="subCategoryList" style="display: none;">
                                <option value="" hidden=""></option>
                            </select> 
                        </div>
                    </div>
                        
                   <div id="stages">
                        
                   </div>
                        
                    <button type="button" class="offset-sm-2 btn btn-light" id="addStage"> Добавить Этап </button>
                    <button type="submit" class="btn btn-primary">Добавить Заказ</button> 


            </form>    
            
        