package bank.foundation.avitepa.AVITEPA_bank.service;

import bank.foundation.avitepa.AVITEPA_bank.entity.Account;

import java.util.List;

public interface AccountService {

    String addAccount(Account account, int cid);
    Account getAccount(int accountNO);
    List<Account> getAllAccounts();
    String transferFund(int from, int to, double amount);
    Account getBalanceOf(int accountNo);
    String deleteAccount(int accountId);

    Account updateAccount(int aid, Account account, int cid);
}
