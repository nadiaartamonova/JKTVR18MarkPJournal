

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1>Список категорий</h1>
        <p> ${info}</p>    
        <table class="table table-hover">
                    <thead>
                      <tr class="bg-light">
                        <th scope="col">№</th>
                        <th scope="col">Категория</th>
                        <th scope="col">Подкатегория</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="items" items="${listAllSubAndCat}" varStatus="num">  
                         
                        <tr>
                          <th scope="row">${num.index + 1}.</th>
                           <c:forEach var="item" items="${items}">
                            <td>${item}</td>
                           </c:forEach>
                          
                        </tr>
                         
                      </c:forEach>
                      
                    </tbody>
                  </table> 
            
            <br>
            
            <a href="newCategory"><button type="button" class="btn btn-primary">Добавить новую категорию</button> </a>
            <a href="newSubCategory"><button type="button" class="btn btn-primary">Добавить новую подкатегорию</button> </a>
