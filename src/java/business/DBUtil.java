
package business;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ekk
 */
public class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebHenryJPAPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
