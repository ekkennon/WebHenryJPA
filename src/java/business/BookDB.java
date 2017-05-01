/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author raefo
 */
public class BookDB {
    public static List<BookInv> getBooksByStore(int storeid) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        //BookInv book = null;
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
        //HashMap<BookList,Integer> book = new HashMap<>();
        Book book = new Book();
        try {
            book.setBl(getBookByID(bookid));
            
            String jpqlQuantity = "SELECT b FROM BookInv b WHERE b.storeid = :storeid and b.bookid = :bookid";
            TypedQuery<BookInv> quantityQuery = manager.createQuery(jpqlQuantity, BookInv.class);
            quantityQuery.setParameter("storeid", storeid);
            quantityQuery.setParameter("bookid", bookid);
            
            book.setInv(quantityQuery.getSingleResult());
            //book.put(bookQuery.getSingleResult(),quantityQuery.getSingleResult().getOnhand());
        } catch (NoResultException e) {
            book = null;
        } finally {
            manager.close();
        }
        return book;
    }
    
    public static String updateOnHand(BookInv book) {
        //int quantity, String bookid, int storeid
        String msg = "";
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = manager.getTransaction();
        try {
            trans.begin();
            manager.merge(book);
            trans.commit();
            /*
            String jpquery = "UPDATE BookInv b SET b.onhand = :oh WHERE b.storeid = :st and b.bookid = :bk";
            TypedQuery<BookInv> query = manager.createQuery(jpquery, BookInv.class);
            query.setParameter("oh", quantity);
            query.setParameter("bk", bookid);
            query.setParameter("st", storeid);
            count = query.executeUpdate();
            */
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
