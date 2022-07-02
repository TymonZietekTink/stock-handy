package tymonzietek.stockhandy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.model.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
