package bank.foundation.avitepa.AVITEPA_bank.controller;

import bank.foundation.avitepa.AVITEPA_bank.entity.Account;
import bank.foundation.avitepa.AVITEPA_bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{cid}")
    public ResponseEntity<String> addAccount(@RequestBody Account account,@PathVariable int cid){
        String add = accountService.addAccount(account, cid);
        return new ResponseEntity<String>(add,HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable int accountId) {
        Account account = accountService.getAccount(accountId);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<List<Account>>(allAccounts,HttpStatus.OK);
    }

    @GetMapping("/accountNo/{accountNo}")
    public ResponseEntity<Account> getBalanceOf(@PathVariable int accountNo){
        Account balanceOf = accountService.getBalanceOf(accountNo);
        return new ResponseEntity<Account>(balanceOf,HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountId){
        String deleted = accountService.deleteAccount(accountId);
        return new ResponseEntity<String>(deleted, HttpStatus.OK);
    }

    @PutMapping("/transfer/from/{from}/to/{to}/amount/{amount}")
    public ResponseEntity<String> transferFund(@PathVariable int from,@PathVariable int to,@PathVariable double amount) {
        String transfer = accountService.transferFund(from, to, amount);
        return new ResponseEntity<String>(transfer,HttpStatus.OK);
    }

    @PutMapping("/accountNo/{aid}/customerId/{cid}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable int aid,
            @RequestBody Account account,
            @PathVariable int cid){

        Account update = accountService.updateAccount(aid, account, cid);
        return new ResponseEntity<Account>(update,HttpStatus.OK);
    }
}
