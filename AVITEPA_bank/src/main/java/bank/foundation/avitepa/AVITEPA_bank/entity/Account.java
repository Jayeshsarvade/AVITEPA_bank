package bank.foundation.avitepa.AVITEPA_bank.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Account {
    @Id
    private  int accountNo;
    private String bankName;
    private String ifsc;
    private String accountType;
    private double balance;
    @OneToOne
    private Customer customer;
}
