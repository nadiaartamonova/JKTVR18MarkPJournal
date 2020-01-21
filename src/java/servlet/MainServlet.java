
package servlet;

import entity.Category;
import entity.CategorySubCategory;
import entity.Client;
import entity.SubCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CategoryFacade;
import session.CategorySubCategoryFacade;
import session.ClientFacade;
import session.SubCategoryFacade;


@WebServlet(name = "MainServlet", urlPatterns = {
    "/index",
    "/newClient",
    "/addClient",
    "/editClient",
    "/changeClient",
    "/showClientList",
    "/newCategory",
    "/addCategory",
    "/showCategoryList",
    "/newSubCategory",
    "/addSubCategory", 
    "/newStage",
    "/addStage",
    
    

})
public class MainServlet extends HttpServlet {
@EJB private ClientFacade clientFacade;
@EJB private CategoryFacade categoryFacade;
@EJB private SubCategoryFacade subCategoryFacade;
@EJB private CategorySubCategoryFacade categorySubCategoryFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String path = request.getServletPath();
        
        switch (path) {
            
            case "/index":
                               
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
//-------- клиент -----------            
            case "/newClient": // показывает страницу нового клиента
                
                request.getRequestDispatcher("/WEB-INF/newClient.jsp").forward(request, response);
                break;
            
            case "/addClient": // создает нового клиента и отправляет на страницу снова
                //собираем данные из формы (имена переменных совпадают)
                String clientName =request.getParameter("clientName");
                String regnr =request.getParameter("regnr");
                String address =request.getParameter("address");
                String phone =request.getParameter("phone");
                String email =request.getParameter("email");
                
                // проверка на заполненное поле и пустое поле
                if(null == clientName )
                        {
                  request.setAttribute("info", "Заполните поле имя клиента");
                  request.getRequestDispatcher("/newClient")
                          .forward(request, response);
                }
                
                
                
                
                Client client = new Client(clientName, regnr, address, phone, email);
                clientFacade.create(client);
                request.setAttribute("client", client);
                
                
                request.setAttribute("info", "Клиент "+client.getClientName()+" добавлен");
                request.getRequestDispatcher("index").forward(request, response);
                break;
                
            case "/showClientList": // показывает страницу нового клиента
                List<Client> listAllClients = clientFacade.findAll();
                request.setAttribute("listAllClients", listAllClients);
                
                request.getRequestDispatcher("/WEB-INF/showClientList.jsp").forward(request, response);
                break;
            
            case "/editClient": // показывает данные клиента на странице едитКлиент
                String clientId = request.getParameter("clientId");
                
                client = clientFacade.find(Long.parseLong(clientId));
                request.setAttribute("client", client);
               
                request.getRequestDispatcher("/WEB-INF/editClient.jsp").forward(request, response);
                break;
             case "/changeClient": // редактирует данные клиента
                 //Считываем данные из формы
                clientId = request.getParameter("clientId");
                clientName =request.getParameter("clientName");
                regnr =request.getParameter("regnr");
                address =request.getParameter("address");
                phone =request.getParameter("phone");
                email =request.getParameter("email");
                
                //находим клиента по ид
                client = clientFacade.find(Long.parseLong(clientId));
                // записываем данны в переменные
                client.setAddress(address);
                client.setClientName(clientName);
                client.setEmail(email);
                client.setPhone(phone);
                client.setRegnr(regnr);
                
                // сохраняем изменения клиента в базе.
                clientFacade.edit(client);
                request.setAttribute("info", "Данные отредактированы");
               
                request.getRequestDispatcher("/WEB-INF/showClientList.jsp").forward(request, response);
                break;
                
//-------- категория -----------            
            case "/newCategory": // показывает страницу 
                
                request.getRequestDispatcher("/WEB-INF/newCategory.jsp").forward(request, response);
                break;
        
            case "/addCategory": // создает категорию
                String categoryName =request.getParameter("categoryName");
                
                 //создаем запись в БД
                Category category = new Category(categoryName);
                categoryFacade.create(category);
                request.setAttribute("category", category);
                
                // проверка на заполненное поле и пустое поле
                if(null == categoryName || "".equals(categoryName))
                        {
                  request.setAttribute("info", "Запомните и выберите все поля");
                  request.getRequestDispatcher("/showCategoryList")
                          .forward(request, response);
                }
                
                // отправляем название категорий в переменную на странице и обновляем ее.
                request.setAttribute("info", "Категория "+category.getCategoryName()+" добавленa");
                request.getRequestDispatcher("showCategoryList").forward(request, response);
                break;
            
             case "/showCategoryList": // показывает страницу всех категорий
                List<CategorySubCategory> listAllSubAndCat = categorySubCategoryFacade.findSubAndCat();
                request.setAttribute("listAllSubAndCat", listAllSubAndCat);
                
                request.getRequestDispatcher("/WEB-INF/showCategoryList.jsp").forward(request, response);
                break;
    
//-------- ПОДкатегория -----------             
            case "/newSubCategory": // показывает страницу 
                List<Category> listAllCategories = categoryFacade.findAll();
                request.setAttribute("listAllCategories", listAllCategories);
                
                request.getRequestDispatcher("/WEB-INF/newSubCategory.jsp").forward(request, response);
                break;
        
            case "/addSubCategory": // создает категорию
                //собираем данные
                String categoryId = request.getParameter("categoryId");
                String subCategoryName =request.getParameter("subCategoryName");
                
                // проверка на заполненное поле и пустое поле
                if(null == categoryId || "".equals(categoryId)
                      ||  null == subCategoryName || "".equals(subCategoryName))
                        {
                  request.setAttribute("info", "Запомните и выберите все поля");
                  request.getRequestDispatcher("/newSubCategory")
                          .forward(request, response);
                }
                //парсим и находим по категориИД категорию в БД.
                category = categoryFacade.find(Long.parseLong(categoryId));
                //Создаем новый объект КатегориюПодкатегори
                CategorySubCategory categorySubCategory = new CategorySubCategory();
                
                
                //создаем запись в БД в таблице подкатегорий
                SubCategory subCategory = new SubCategory(subCategoryName);
                subCategoryFacade.create(subCategory);
                request.setAttribute("subCategory", subCategory);
                
                //создаем запись в БД в таблице Катория--Подкатегория связь 1 - *
                categorySubCategory.setCategory(category);
                categorySubCategory.setSubCategory(subCategory);
                categorySubCategoryFacade.create(categorySubCategory);
                        
                request.setAttribute("info", "Подкатегория "+subCategory.getSubCategoryName()+" добавленa");
                request.getRequestDispatcher("/showCategoryList").forward(request, response);
                break;    
//        
////-------- ЭТАПЫ -----------            
//            case "/newStage": // показывает страницу 
//                request.setAttribute(path, phone);
//                request.getRequestDispatcher("/WEB-INF/newStage.jsp").forward(request, response);
//                break;
//        
//            case "/addStage": // создает etapp
//                String categoryName =request.getParameter("categoryName");
//                
//                //создаем запись в БД
//                Category category = new Category(categoryName);
//                categoryFacade.create(category);
//                request.setAttribute("category", category);
//                
//                // отправляем название категорий в переменную на странице и обновляем ее.
//                request.setAttribute("info", "Этап "+category.getCategoryName()+" добавлен");
//                request.getRequestDispatcher("/newStage").forward(request, response);
//                break;
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
