package bank.foundation.avitepa.AVITEPA_bank.dao;

import bank.foundation.avitepa.AVITEPA_bank.entity.Customer;
import bank.foundation.avitepa.AVITEPA_bank.exception.ResourceNotFoundException;
import bank.foundation.avitepa.AVITEPA_bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    public String createCustomer(Customer customer){
        Customer save = customerRepository.save(customer);
        if (save!=null){
            return "customer created successfully";
        }else {
            return "customer created failed";
        }
    }

    public Customer findCustomerById(int cid){
        Customer customer = customerRepository.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", cid));
        return customer;
    }

    public Customer getCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
    return customer;
    }

    public List<Customer> getAllCustomer() {
        List<Customer> all = customerRepository.findAll();
        return all;
    }


    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", id));
            customerRepository.delete(customer);
    }

    public Customer updateCustomer(int cid, Customer customer) {
        Customer update = customerRepository.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", cid));
        update.setName(customer.getName());
        update.setPhoneNo(customer.getPhoneNo());
        update.setEmail(customer.getEmail());
        update.setPassword(customer.getPassword());
        customerRepository.save(update);
        return update;
    }


}
