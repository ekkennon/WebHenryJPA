
package servlets;

import business.Store;
import business.StoreDB;
import business.User;
import business.UserDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ekk
 */
public class LogonServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = "/Logon.jsp";
        String msg = "";
        List<Store> stores;
        int userId = 0;
        Cookie uid;
        
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                userId = Integer.parseInt(request.getParameter("userid").trim());
                user = UserDB.getUserByID(userId);
                int pwAttempt = Integer.parseInt(request.getParameter("password").trim());
                user.setPwAttempt(pwAttempt);
            }
  
            if (user.isAuthenticated()) {
                msg = "Welcome, " + user.getUsername() + "!<br/>";
                url = "/StoreSelection.jsp";
                request.getSession().setAttribute("user", user);
            } else {
                msg = "unable to authenticate<br/>";
            }
            
            stores = StoreDB.getStores();
            
            if (stores == null) {
                msg = "No stores read from stores table<br/>";
            } else {
                request.getSession().setAttribute("stores", stores);
            }
       
        } catch (NumberFormatException e) {
            msg = "Illegal userid or password: "  + e.getMessage() + "<br/>";
        }
        uid = new Cookie("userid",Integer.toString(userId));
        uid.setMaxAge(60*10);
        uid.setPath("/");
        response.addCookie(uid);
        request.setAttribute("msg", msg);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(url);
        disp.forward(request,response);
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
