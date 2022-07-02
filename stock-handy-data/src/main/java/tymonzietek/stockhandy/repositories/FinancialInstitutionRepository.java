package tymonzietek.stockhandy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tymonzietek.stockhandy.model.FinancialInstitution;

public interface FinancialInstitutionRepository extends JpaRepository<FinancialInstitution, Long> {

}
