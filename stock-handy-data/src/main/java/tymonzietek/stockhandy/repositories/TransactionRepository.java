package tymonzietek.stockhandy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
