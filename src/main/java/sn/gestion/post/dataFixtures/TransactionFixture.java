package sn.gestion.post.dataFixtures;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.gestion.post.model.Transaction;
import sn.gestion.post.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.Arrays;

@AllArgsConstructor
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Order(3)
public class TransactionFixture implements CommandLineRunner {

    TransactionRepository transactionRepository;
    @Override
    public void run(String... args) throws Exception {

        transactionRepository.saveAll(Arrays.asList(
                new Transaction("1234", LocalDate.parse("2022-02-21"), "30000"),
                new Transaction("2345", LocalDate.parse("2021-02-21"), "100000")
        ));
    }
}
