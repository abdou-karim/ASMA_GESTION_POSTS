package sn.gestion.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import sn.gestion.post.model.Transaction;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private String numeroTransaction;
    private LocalDate dateTransaction;
    private String montant;

    public static TransactionDto fromEntity (Transaction transaction) {
        if(transaction ==null) return null;
        return TransactionDto.builder()
                .id(transaction.getId())
                .numeroTransaction(transaction.getNumeroTransaction())
                .dateTransaction(transaction.getDateTransaction())
                .montant(transaction.getMontant())
                .build();
    }

    public static Transaction toEntity(TransactionDto transactionDto) {
        if(transactionDto == null) return null;

        Transaction transaction = new Transaction();

        transaction.setId(transactionDto.getId());
        transaction.setNumeroTransaction(transactionDto.getNumeroTransaction());
        transaction.setDateTransaction(transactionDto.getDateTransaction());
        transaction.setMontant(transactionDto.getMontant());

        return  transaction;
    }
}
