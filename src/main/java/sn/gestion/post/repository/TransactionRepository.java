package sn.gestion.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.gestion.post.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAll();
    Optional<Transaction> findById(Long id);
    Optional<Transaction> findByIdAndArchiveFalse(Long id);
}
