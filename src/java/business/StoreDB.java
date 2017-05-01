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
public class StoreDB {
    public static List<Store> getStores() {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        String jpquery = "SELECT s FROM Store s ORDER BY s.storeName";
        TypedQuery<Store> query = manager.createQuery(jpquery, Store.class);
        List<Store> stores = null;
        
        try {
            stores = query.getResultList();
            if (stores == null || stores.isEmpty()) {
                stores = null;
            }
        } catch (NoResultException e) {
            stores = null;
        } finally {
            manager.close();
        }
        
        return stores;
    }
    
    public static Store getStoreByID(int id) {
        EntityManager manager = DBUtil.getEmFactory().createEntityManager();
        try {
            Store store = manager.find(Store.class, id);
            return store;
        } finally {
            manager.close();
        }
    }
}
