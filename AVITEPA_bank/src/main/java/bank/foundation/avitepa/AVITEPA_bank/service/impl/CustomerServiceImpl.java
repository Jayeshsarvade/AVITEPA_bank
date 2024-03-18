package bank.foundation.avitepa.AVITEPA_bank.service.impl;

import bank.foundation.avitepa.AVITEPA_bank.dao.CustomerDao;
import bank.foundation.avitepa.AVITEPA_bank.entity.Customer;
import bank.foundation.avitepa.AVITEPA_bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
    @Override
    public String createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public Customer updateCustomer(int cid, Customer customer) {
        return customerDao.updateCustomer(cid,customer);
    }
}
