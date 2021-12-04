package ua.com.alevel.dao;

import ua.com.alevel.db.DBStore;
import ua.com.alevel.entity.Store;

public class StoreDao {

    public void create(Store store) {
        DBStore.getInstance().create(store);
    }

    public void update(Store store) {
        DBStore.getInstance().update(store);
    }

    public void delete(String id) {
        DBStore.getInstance().delete(id);
    }

    public Store findById(String id) {
        return DBStore.getInstance().findById(id);
    }

    public Store[] findAll() {
        return DBStore.getInstance().findAll();
    }
}
