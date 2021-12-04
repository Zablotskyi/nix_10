package ua.com.alevel.db;

import ua.com.alevel.entity.Store;
import java.util.Arrays;

public class DBStore {

    private static DBStore instance;
    private Store[] stores;

    private DBStore() {
        stores = new Store[0];
    }

    public static DBStore getInstance() {
        if (instance == null) {
            instance = new DBStore();
        }
        return instance;
    }

    public void create(Store store) {
        arraySizeUp();
        store.setId(store.getId());
        stores[stores.length - 1] = store;
    }

    public void update(Store store) {
        Store current = findById(store.getId());
        current.setName(store.getName());
    }

    public void delete(String id) {
        for (int i = 0; i < stores.length; i++) {
            if (id == (stores[i].getId())) {
                stores[i] = null;
            }
        }
        arrayUsersSizeDown();
    }

    public Store findById(String id) {
        for (int i = 0; i < stores.length; i++) {
            if (id == (stores[i].getId())) {
                return stores[i];
            }
        }
        throw new RuntimeException("пользователь не найден");
    }

    public Store[] findAll() {
        return stores;
    }

    //метод увеличивающий массив на одну ячейку
    private void arraySizeUp() {
        stores = Arrays.copyOf(stores, stores.length + 1);
    }

    //метод который убирает ячейки по индексу с значением null
    private void arrayUsersSizeDown() {
        Store[] tempArrayUsers = Arrays.copyOf(stores, stores.length);
        stores = new Store[tempArrayUsers.length - 1];

        int count = 0;
        for (int i = 0; i < tempArrayUsers.length; i++) {
            if (tempArrayUsers[count] != null) {
                stores[count] = tempArrayUsers[i];
                count++;
            }
        }
    }
}
