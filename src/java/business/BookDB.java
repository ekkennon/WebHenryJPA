/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author raefo
 */
public class BookDB {
    public static BookInv getBookQuantity(String bookid, int storeid) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        BookInv book = null;
        try {
            String jpquery = "SELECT b FROM BookInv b WHERE b.bookid = :bookid and b.storeid = :storeid";
            TypedQuery<BookInv> query = manager.createQuery(jpquery, BookInv.class);
            //List<Book> book = null;
            query.setParameter("bookid", bookid);
            query.setParameter("storeid", storeid);
            book = query.getSingleResult();
            
        } catch (NoResultException e) {
            book = null;
        } finally {
            manager.close();
        }
        return book;
    }
    
    public static List<BookList> getBookListByStore(String storeid) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        List<BookList> list = null;
        try {
            String jpquery = "SELECT b FROM BookList b WHERE b.storeid = :storeid";
            TypedQuery<BookList> query = manager.createQuery(jpquery, BookList.class);
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
}
