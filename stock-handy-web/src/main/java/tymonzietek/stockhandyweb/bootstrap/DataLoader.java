package tymonzietek.stockhandyweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tymonzietek.stockhandydata.service.FinancialInstitutionService;

@Component
public class DataLoader implements CommandLineRunner {
  private final FinancialInstitutionService companyService;

  public DataLoader(FinancialInstitutionService financialInstitutionService) {
    this.companyService = financialInstitutionService;
  }

  @Override
  public void run(String... args) throws Exception {
  }
}
