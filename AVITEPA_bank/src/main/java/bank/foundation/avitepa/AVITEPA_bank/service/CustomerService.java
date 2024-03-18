package bank.foundation.avitepa.AVITEPA_bank.service;

import bank.foundation.avitepa.AVITEPA_bank.entity.Customer;

import java.util.List;

public interface CustomerService {

    String createCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
    List<Customer> getAllCustomer();
    Customer updateCustomer(int cid, Customer customer);
}
