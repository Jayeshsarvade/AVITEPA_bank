package bank.foundation.avitepa.AVITEPA_bank.repository;

import bank.foundation.avitepa.AVITEPA_bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
