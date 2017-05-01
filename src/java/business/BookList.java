/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.NumberFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author raefo
 */

@Entity
@Table(name="booklist")
public class BookList {
    
    @Id
    @Column(name="bookID")
    private String bookid;
    
    @Column(name="title")
    private String title;
    
    @Column(name="author")
    private String author;
    
    @Column(name="publisher_Code")
    private String pcode;
    
    @Column(name="booktype")
    private String booktype;
    
    @Column(name="price")
    private double price;
    
    @Transient
    private final NumberFormat curr = NumberFormat.getCurrencyInstance();

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the pcode
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * @param pcode the pcode to set
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    /**
     * @return the booktype
     */
    public String getBooktype() {
        return booktype;
    }

    /**
     * @param booktype the booktype to set
     */
    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
