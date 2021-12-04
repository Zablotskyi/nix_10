package ua.com.alevel.dao;

import ua.com.alevel.db.DBCustomer;
import ua.com.alevel.entity.Customer;

public class CustomerDao {
    public void create(Customer customer) {
        DBCustomer.getInstance().create(customer);
    }

    public void update(Customer customer) {
        DBCustomer.getInstance().update(customer);
    }

    public void delete(long id) {
        DBCustomer.getInstance().delete(id);
    }

    public Customer findById(long id) {
        return DBCustomer.getInstance().findById(id);
    }

    public Customer[] findAll() {
        return DBCustomer.getInstance().findAll();
    }
}
