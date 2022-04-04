package sn.gestion.post.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String numeroTransaction;

    private LocalDate dateTransaction = LocalDate.now();;

    private String montant;

    private boolean archive = false;

    public Transaction(String numeroTransaction, LocalDate dateTransaction, String montant) {
        this.numeroTransaction = numeroTransaction;
        this.dateTransaction = dateTransaction;
        this.montant = montant;
    }
}
