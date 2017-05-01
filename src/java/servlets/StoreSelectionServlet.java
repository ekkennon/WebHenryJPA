
package servlets;

import business.Book;
import business.BookDB;
import business.BookInv;
import business.Store;
import business.StoreDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ekk
 */
public class StoreSelectionServlet extends HttpServlet {

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
        String url = "/ViewInventory.jsp";
        String msg = "";
        ArrayList<Book> booklist = new ArrayList<>();
        String storeid = request.getParameter("storeid");
        Store store;
        
        if (storeid == null) {
            store = (Store) request.getSession().getAttribute("store");
            storeid = Integer.toString(store.getStoreid());
        } else {
            store = StoreDB.getStoreByID(Integer.parseInt(storeid));
            request.getSession().setAttribute("store", store);
        }
        
        try {
            List<BookInv> list = BookDB.getBooksByStore(Integer.parseInt(storeid));
            /*
            for (BookInv i : list) {
                Book b = new Book();
                b.setBl(BookDB.getBookByID(i.getBookid()));
                b.setInv(i);
                booklist.add(b);
            }*/
            
            
            list.stream().map((i) -> {
                Book b = new Book();
                b.setBl(BookDB.getBookByID(i.getBookid()));
                b.setInv(i);
                return b;
            }).forEachOrdered((b) -> {
                booklist.add(b);
            });
            

        } catch (Exception e) {
            msg += "StoreSelection Error: " + e.getMessage() + "<br/>";
        }
        
        request.setAttribute("msg", msg);
        request.setAttribute("books", booklist);
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
