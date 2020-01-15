
package servlet;

import entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;


@WebServlet(name = "MainServlet", urlPatterns = {
    "/index",
    "/newClient",
    "/addClient",
    "/showClientList"

})
public class MainServlet extends HttpServlet {
@EJB private ClientFacade clientFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String path = request.getServletPath();
        
        switch (path) {
            
            case "/index":
                               
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
                
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
                
                Client client = new Client(clientName, Integer.parseInt(regnr), address, Integer.parseInt(phone), email);
                clientFacade.create(client);
                request.setAttribute("client", client);
                
                
                request.setAttribute("info", "Клиент "+client.getClientName()+" добавлен");
                request.getRequestDispatcher("newClient").forward(request, response);
                break;
                
            case "/showClientList": // показывает страницу нового клиента
                List<Client> listAllClients = clientFacade.findAll();
                request.setAttribute("listAllClients", listAllClients);
                
                request.getRequestDispatcher("/WEB-INF/showClientList.jsp").forward(request, response);
                break;
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
