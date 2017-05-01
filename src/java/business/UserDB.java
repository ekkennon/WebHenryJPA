/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.persistence.EntityManager;

/**
 *
 * @author raefo
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
        //return user;
    }
}
