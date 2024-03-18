package bank.foundation.avitepa.AVITEPA_bank.controller;

import bank.foundation.avitepa.AVITEPA_bank.entity.Customer;
import bank.foundation.avitepa.AVITEPA_bank.payload.ApiResponse;
import bank.foundation.avitepa.AVITEPA_bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public String createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse> deleteMapping(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("customer deleted successfully", true), HttpStatus.OK);
    }

    @PutMapping("/{cid}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int cid,@RequestBody Customer customer){
        Customer update = customerService.updateCustomer(cid, customer);
        return new ResponseEntity<Customer>(update, HttpStatus.OK);
    }
}
