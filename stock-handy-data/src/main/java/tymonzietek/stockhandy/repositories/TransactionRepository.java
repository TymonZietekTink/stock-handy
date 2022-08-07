package tymonzietek.stockhandy.repositories;

import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Set<Transaction> findTransactionsByInvestment(Investment investment);
}
