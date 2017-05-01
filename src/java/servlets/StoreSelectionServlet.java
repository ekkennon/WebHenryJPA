
package servlets;

import business.Book;
//import business.ConnectionPool;
import business.Store;
import business.StoreDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        Store store;// = new Store();
        
        if (storeid == null) {
            store = (Store) request.getSession().getAttribute("store");
            storeid = Integer.toString(store.getStoreid());
        } else {
            store = StoreDB.getStoreByID(Integer.parseInt(storeid));
            request.getSession().setAttribute("store", store);
        }
        
        try {
            //ConnectionPool pool = ConnectionPool.getInstance();
            //Connection conn = pool.getConnection();
            
            String invsql = "SELECT * FROM bookinv WHERE storeID = '" + storeid + "'";
            //ResultSet invr = conn.prepareStatement(invsql).executeQuery(invsql);
            //while (invr.next()) {
                Book book = new Book();
                //book.setBookid(invr.getString("bookID"));
                //book.setOnhand(invr.getInt("OnHand"));
                //book.setStoreid(invr.getInt("storeID"));
                String booksql = "SELECT * FROM booklist WHERE bookID = '" + book.getBookid() + "'";
                //ResultSet bkr = conn.prepareStatement(booksql).executeQuery(booksql);
                //if (bkr.next()) {
                    //book.setTitle(bkr.getString("title"));
                    //book.setPrice(bkr.getDouble("price"));
                //}
                booklist.add(book);
            //}
            //String storesql = "SELECT * FROM stores where storeID = '" + storeid + "'";
            //ResultSet getStore = conn.prepareStatement(storesql).executeQuery(storesql);
            //if (getStore.next()) {
                //store.setStoreAddress(getStore.getString("storeAddr"));
                //store.setStoreName(getStore.getString("storeName"));
                //store.setStoreid(getStore.getInt("storeID"));
                //store.setNumEmployees(getStore.getInt("storeEmp"));
            //}
        } catch (Exception e) {
            msg += "StoreSelection Error: " + e.getMessage() + "<br/>";
        }
        //request.getSession().setAttribute("store", store);
        request.setAttribute("msg", msg);
        request.setAttribute("booklist", booklist);
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
