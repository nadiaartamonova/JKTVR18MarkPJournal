<%@page contentType="text/html" pageEncoding="UTF-8"%>
                
                
        <h1>Добавление новой подкатегории</h1>
        
        
        <p>${info}</p>
        <form action="addSubCategory" method="POST">
            <select name="categoryId">
                <option value="" hidden=""></option>
                <c:forEach var="category" items="${listAllCategories}">
                    <option value="${category.id}">${category.categoryName}</option>
                </c:forEach>
            </select><br>
            
            Название подкатегории: <input type="text"  placeholder="Название подкатегории" name="subCategoryName" value="${subCategoryName}"> <br>
                      
            <input type="submit" value="Добавить новою подкатегории">
        </form>
        <a href="index.jsp">Главная страница</a>
    
        

