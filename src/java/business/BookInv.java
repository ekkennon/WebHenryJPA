/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author raefo
 */

@Entity
@Table(name="bookinv")
public class BookInv {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="bookID")
    private String bookid;
    
    @Column(name="storeID")
    private int storeid;
    
    @Column(name="OnHand")
    private int onhand;
    
    public BookInv() {
        id = 0;
        bookid = "";
        storeid = 0;
        onhand = 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bookid
     */
    public String getBookid() {
        return bookid;
    }

    /**
     * @param bookid the bookid to set
     */
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    /**
     * @return the storeid
     */
    public int getStoreid() {
        return storeid;
    }

    /**
     * @param storeid the storeid to set
     */
    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    /**
     * @return the onhand
     */
    public int getOnhand() {
        return onhand;
    }

    /**
     * @param onhand the onhand to set
     */
    public void setOnhand(int onhand) {
        this.onhand = onhand;
    }
}
