
package business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author ekk
 */
public class BookDB {
    public static List<BookInv> getBooksByStore(int storeid) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        
        List<BookInv> list = null;
        try {
            String jpquery = "SELECT b FROM BookInv b WHERE b.storeid = :storeid";
            TypedQuery<BookInv> query = manager.createQuery(jpquery, BookInv.class);
            
            query.setParameter("storeid", storeid);
            list = query.getResultList();
            
            if (list == null || list.isEmpty()) {
                list = null;
            }
            
        } catch (NoResultException e) {
            list = null;
        } finally {
            manager.close();
        }
        return list;
    }
    
    public static BookList getBookByID(String bookid) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        BookList book = null;
        try {
            String jpquery = "SELECT b FROM BookList b WHERE b.bookid = :bookid";
            TypedQuery<BookList> query = manager.createQuery(jpquery, BookList.class);
            query.setParameter("bookid", bookid);
            
            book = query.getSingleResult();
        } catch (NoResultException e) {
            book = null;
        } finally {
            manager.close();
        }
        return book;
    }
    
    public static Book getBookWithQuantity(String bookid, int storeid) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        
        Book book = new Book();
        try {
            book.setBl(getBookByID(bookid));
            
            String jpqlQuantity = "SELECT b FROM BookInv b WHERE b.storeid = :storeid and b.bookid = :bookid";
            TypedQuery<BookInv> quantityQuery = manager.createQuery(jpqlQuantity, BookInv.class);
            quantityQuery.setParameter("storeid", storeid);
            quantityQuery.setParameter("bookid", bookid);
            
            book.setInv(quantityQuery.getSingleResult());
            
        } catch (NoResultException e) {
            book = null;
        } finally {
            manager.close();
        }
        return book;
    }
    
    public static String updateOnHand(BookInv book) {
        
        String msg = "";
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = manager.getTransaction();
        try {
            trans.begin();
            manager.merge(book);
            trans.commit();
            
            msg = "Quantity Updated.</br>";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            trans.rollback();
        } finally {
            manager.close();
        }
        return msg;
    }
}
