package tymonzietek.stockhandyweb.controllers;

import java.util.Set;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tymonzietek.stockhandydata.model.FinancialInstitution;
import tymonzietek.stockhandydata.service.FinancialInstitutionService;

@RestController
public class CompanyController {
  private final FinancialInstitutionService companyService;

  public CompanyController(FinancialInstitutionService companyService) {
    this.companyService = companyService;
  }

  @RequestMapping("/companies")
  public Set<FinancialInstitution> listInvestments(){
    return companyService.findAll();
  }

}
