package bank.foundation.avitepa.AVITEPA_bank.service.impl;

import bank.foundation.avitepa.AVITEPA_bank.dao.AccountDao;
import bank.foundation.avitepa.AVITEPA_bank.dao.CustomerDao;
import bank.foundation.avitepa.AVITEPA_bank.entity.Account;
import bank.foundation.avitepa.AVITEPA_bank.entity.Customer;
import bank.foundation.avitepa.AVITEPA_bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public String addAccount(Account account, int cid) {
        Customer customer = customerDao.findCustomerById(cid);
            account.setCustomer(customer);
            return accountDao.addAccount(account);
    }

    @Override
    public Account getAccount(int accountNo) {
        return accountDao.getAccount(accountNo);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    @Override
    public String transferFund(int from, int to, double amount) {
        try {
            Account fromAccount = accountDao.getAccount(from);
            Account toAccount = accountDao.getAccount(to);
            if (fromAccount != null && toAccount != null) {
                if (amount <= fromAccount.getBalance()) {
                    fromAccount.setBalance(fromAccount.getBalance() - amount);
                    toAccount.setBalance(toAccount.getBalance() + amount);
                    accountDao.updateAccount(fromAccount);
                    accountDao.updateAccount(toAccount);
                    return "SUCCESS";
                } else {
                    return "INSUFFICIENT FUNDS";
                }
            }
        } catch (Exception e) {
            return "ID MISMATCH";
        }
        return null;
    }

    @Override
    public Account getBalanceOf(int accountNo) {
        try {
            return accountDao.getBalanceOf(accountNo);
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public String deleteAccount(int accountId) {
        return accountDao.deleteAccount(accountId);
    }

    @Override
    public Account updateAccount(int aid, Account account, int cid) {
        return accountDao.updateAccount(aid,account,cid);
    }
}
