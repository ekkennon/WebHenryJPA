
package business;

import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ekk
 */

//@Entity
//@Table(name="books")
public class Book {
    BookList bl;
    BookInv inv;
    /*
    private String bookid;
    private int storeid;
    private int onhand;
    private String title;
    private String author;
    private double price;
    private NumberFormat curr = NumberFormat.getCurrencyInstance();
*/
    public Book() {
        bl = new BookList();
        inv = new BookInv();
        /*
        bookid = "";
        storeid = 0;
        onhand = 0;
        title = "";
        price = 0;
        */
    }
    
    /**
     * @return the bookid
     *//*
    public String getBookid() {
        return bookid;
    }*/

    /**
     * @param bookid the bookid to set
     *//*
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }*/

    /**
     * @return the storeid
     *//*
    public int getStoreid() {
        return storeid;
    }*/

    /**
     * @param storeid the storeid to set
     *//*
    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }*/

    /**
     * @return the onhand
     *//*
    public int getOnhand() {
        return onhand;
    }*/

    /**
     * @param onhand the onhand to set
     *//*
    public void setOnhand(int onhand) {
        this.onhand = onhand;
    }*/

    /**
     * @return the title
     *//*
    public String getTitle() {
        return title;
    }*/

    /**
     * @param title the title to set
     *//*
    public void setTitle(String title) {
        this.title = title;
    }*/
    
    /**
     * @return the author
     *//*
    public String getAuthor() {
        return author;
    }*/

    /**
     * @param author the author to set
     *//*
    public void setAuthor(String author) {
        this.author = author;
    }*/

    /**
     * @return the price
     *//*
    public String getPrice() {
        return curr.format(price);
    }*/

    /**
     * @param price the price to set
     *//*
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return title;
    }*/
    
    public void setBl(BookList b) {
        this.bl = b;
    }
    
    public BookList getBl() {
        return bl;
    }
    
    public void setInv(BookInv i) {
        this.inv = i;
    }
    
    public BookInv getInv() {
        return inv;
    }
}
