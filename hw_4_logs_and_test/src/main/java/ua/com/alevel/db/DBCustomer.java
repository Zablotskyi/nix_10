package ua.com.alevel.db;

import ua.com.alevel.entity.Customer;
import java.util.Arrays;

public class DBCustomer {

    private static DBCustomer instance;
    private Customer[] customers;

    private DBCustomer() {
        customers = new Customer[0];
    }

    public static DBCustomer getInstance() {
        if (instance == null) {
            instance = new DBCustomer();
        }
        return instance;
    }

    public void create(Customer customer) {
        arraySizeUp();
        customer.setId(customer.getId());
        customers[customers.length - 1] = customer;
    }

    public void update(Customer customer) {
        Customer current = findById(customer.getId());
        current.setName(customer.getName());
        current.setLastName(customer.getLastName());
        current.setBirthDay(customer.getBirthDay());
        current.setId(customer.getId());
    }

    public void delete(long id) {
        for (int i = 0; i < customers.length; i++) {
            if (id == (customers[i].getId())) {
                customers[i] = null;
            }
        }
        arrayUsersSizeDown();
    }

    public Customer findById(long id) {
        for (int i = 0; i < customers.length; i++) {
            if (id == (customers[i].getId())) {
                return customers[i];
            }
        }
        throw new RuntimeException("пользователь не найден");
    }

    public Customer[] findAll() {
        return customers;
    }

    //метод увеличивающий массив на одну ячейку
    private void arraySizeUp() {
        customers = Arrays.copyOf(customers, customers.length + 1);
    }

    //метод который убирает ячейки по индексу с значением null
    private void arrayUsersSizeDown() {
        Customer[] tempArrayUsers = Arrays.copyOf(customers, customers.length);
        customers = new Customer[tempArrayUsers.length - 1];

        int count = 0;
        for (int i = 0; i < tempArrayUsers.length; i++) {
            if (tempArrayUsers[count] != null) {
                customers[count] = tempArrayUsers[i];
                count++;
            }
        }
    }
}
