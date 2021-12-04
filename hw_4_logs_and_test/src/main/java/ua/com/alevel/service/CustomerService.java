package ua.com.alevel.service;

import ua.com.alevel.dao.CustomerDao;
import ua.com.alevel.entity.Customer;

public class CustomerService {

    private final CustomerDao customerDao = new CustomerDao();

    public void create(Customer customer) {
        customerDao.create(customer);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public void delete(long id) {
        customerDao.delete(id);
    }

    public Customer findById(long id) {
        return customerDao.findById(id);
    }

    public Customer[] findAll() {
        return customerDao.findAll();
    }
}
