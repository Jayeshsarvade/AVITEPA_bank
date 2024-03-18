package bank.foundation.avitepa.AVITEPA_bank.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private long phoneNo;
    @Column(unique = true)
    private String email;
    private String password;

}
