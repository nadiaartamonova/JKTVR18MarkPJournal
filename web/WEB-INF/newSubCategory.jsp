<%@page contentType="text/html" pageEncoding="UTF-8"%>
                
        
        <p>${info}</p>
        <form action="addSubCategory" method="POST">
            <fieldset>
            <legend>Новая подкатегория</legend>
            <div class="form-group row-cols-4">
                
            <select name="categoryId" class="form-control">
                <option value="" hidden=""></option>
                <c:forEach var="category" items="${listAllCategories}">
                    <option value="${category.id}">${category.categoryName}</option>
                </c:forEach>
            </select><br>
            <label class="col-sm-2 col-form-label">Название:</label> 
            <input type="text"  class="form-control"placeholder="Название подкатегории" name="subCategoryName" value="${subCategoryName}"> <br>
                      
            <button type="submit" class="btn btn-danger">Добавить</button> 
            <a href="index.jsp"><button type="button" class="btn btn-danger">Главная страница</button> </a>
          </fieldset>
        </form>
    
        

