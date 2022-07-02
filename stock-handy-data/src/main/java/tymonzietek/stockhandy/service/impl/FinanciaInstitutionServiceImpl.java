package tymonzietek.stockhandy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.repositories.FinancialInstitutionRepository;
import tymonzietek.stockhandy.service.FinancialInstitutionService;

@Service
public class FinanciaInstitutionServiceImpl implements FinancialInstitutionService {

  private final FinancialInstitutionRepository financialInstiturionRepository;

  public FinanciaInstitutionServiceImpl(FinancialInstitutionRepository financialInstiturionRepository) {
    this.financialInstiturionRepository = financialInstiturionRepository;
  }

  @Override
  public Set<FinancialInstitution> findAll() {
    Set<FinancialInstitution> financialInstitutionSet = new HashSet<>();
    financialInstiturionRepository.findAll().forEach(financialInstitutionSet::add);
    return financialInstitutionSet;
  }

  @Override
  public FinancialInstitution findById(Long aLong) {
    return financialInstiturionRepository.findById(aLong).orElse(null);
  }

  @Override
  public FinancialInstitution save(FinancialInstitution object) {
    return financialInstiturionRepository.save(object);
  }

  @Override
  public void delete(FinancialInstitution object) {
    financialInstiturionRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    financialInstiturionRepository.deleteById(aLong);
  }
}
