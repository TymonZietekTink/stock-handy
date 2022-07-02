package tymonzietek.stockhandy.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.repositories.InvestmentRepository;
import tymonzietek.stockhandy.service.InvestmentService;

@Service
public class InvestmentServiceImpl implements InvestmentService {
  private final InvestmentRepository investmentRepository;

  public InvestmentServiceImpl(
      InvestmentRepository investmentRepository) {
    this.investmentRepository = investmentRepository;
  }

  @Override
  public Set<Investment> findAll() {
    Set<Investment> set = new HashSet<>();
    investmentRepository.findAll().forEach(set::add);
    return set;
  }

  @Override
  public Investment findById(Long aLong) {
    return investmentRepository.findById(aLong).orElse(null);
  }

  @Override
  public Investment save(Investment object) {
    return investmentRepository.save(object);
  }

  @Override
  public void delete(Investment object) {
    investmentRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    investmentRepository.deleteById(aLong);
  }
}
