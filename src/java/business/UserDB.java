
package business;

import javax.persistence.EntityManager;

/**
 *
 * @author ekk
 */
public class UserDB {
    public static User getUserByID(int id) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        try {
            User user = manager.find(User.class, id);
            return user;
        } finally {
            manager.close();
        }
    }
}
