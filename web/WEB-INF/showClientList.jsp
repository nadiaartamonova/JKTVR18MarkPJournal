

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <h1>Список клиентов:</h1>

                <table class="table table-hover">
                    <thead>
                      <tr class="bg-light">
                        <th scope="col">№</th>
                        <th scope="col">Имя клиента</th>
                        <th scope="col">Телефон</th>
                        <th scope="col">Редактирование</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="client" items="${listAllClients}" varStatus="num">  
                        <tr>
                          <th scope="row">${num.index + 1}.</th>
                          <td>${client.clientName} </td>
                          <td>${client.phone} </td>
                          <td> <a href="editClient">Изменить</a></td>
                        </tr>
                      </c:forEach>
                      
                    </tbody>
                  </table> 
           
            
            <br>
             
            <a href="newClient"><button type="button" class="btn btn-primary">Новый клиент</button> </a>

