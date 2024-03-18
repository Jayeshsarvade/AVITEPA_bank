package bank.foundation.avitepa.AVITEPA_bank.dao;

import bank.foundation.avitepa.AVITEPA_bank.entity.Account;
import bank.foundation.avitepa.AVITEPA_bank.entity.Customer;
import bank.foundation.avitepa.AVITEPA_bank.exception.ResourceNotFoundException;
import bank.foundation.avitepa.AVITEPA_bank.repository.AccountRepository;
import bank.foundation.avitepa.AVITEPA_bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public class AccountDao {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    public String addAccount(Account account) {
        Account save = accountRepository.save(account);
        if (save != null) {
            return "account add successfully";
        } else {
            return "account add failed";
        }
    }

    public Account getAccount(int accountNo) {
        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "accountId", accountNo));
        return account;
    }

    public List<Account> getAllAccounts(){
        List<Account> all = accountRepository.findAll();
        return all;
    }

    public Account getBalanceOf(int accountNo){

        Account account = accountRepository.findById(accountNo)
        .orElseThrow(() -> new ResourceNotFoundException("account", "accountNo", accountNo));
       return account;
    }

    public String deleteAccount(int accountNo) {
        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new ResourceNotFoundException("account", "accountNo", accountNo));
        accountRepository.delete(account);
        return "account deleted successfully...";
    }

    public void updateAccount(Account account){
        accountRepository.save(account);
    }

    public Account updateAccount(int aid, Account account, int cid) {
        Account updatesAccount = accountRepository.findById(aid)
                .orElseThrow(() -> new ResourceNotFoundException("account", "accountId", aid));

        Customer customer = customerRepository.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("customer", "customerId", cid));

        updatesAccount.setBankName(account.getBankName());
        updatesAccount.setIfsc(account.getIfsc());
        updatesAccount.setAccountType(account.getAccountType());
        updatesAccount.setCustomer(customer);
        accountRepository.save(updatesAccount);
        return updatesAccount;
    }
}
