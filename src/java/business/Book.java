
package business;



/**
 *
 * @author ekk
 */


public class Book {
    BookList bl;
    BookInv inv;

    public Book() {
        bl = new BookList();
        inv = new BookInv();
 
    }
    

    
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
