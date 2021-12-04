package ua.com.alevel.service;

import ua.com.alevel.dao.StoreDao;
import ua.com.alevel.entity.Store;

public class StoreService {

    private static int count = 100;
    private final StoreDao storeDao = new StoreDao();

    public void create(Store store) {
        storeDao.create(store);
    }

    public void update(Store store) {
        storeDao.update(store);
    }

    public void delete(String id) {
        storeDao.delete(id);
    }

    public Store findById(String id) {
        return storeDao.findById(id);
    }

    public Store[] findAll() {
        return storeDao.findAll();
    }

    public String generateId(Store store) {

        count ++;

        String id = store.getType() + "_" + count;
        return id;
    }
}
