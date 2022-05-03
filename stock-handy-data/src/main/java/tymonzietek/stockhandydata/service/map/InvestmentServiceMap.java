package tymonzietek.stockhandydata.service.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import tymonzietek.stockhandydata.model.Investment;
import tymonzietek.stockhandydata.model.Transaction;
import tymonzietek.stockhandydata.service.AbstractMapService;
import tymonzietek.stockhandydata.service.InvestmentService;
import tymonzietek.stockhandydata.service.TransactionService;

@Service
public class InvestmentServiceMap extends AbstractMapService<Investment, Long> implements
    InvestmentService {

  @Override
  public Investment save(Investment object) {
    return super.save(object.getId(),object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Set<Investment> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Investment object) {
    super.delete(object);
  }

  @Override
  public Investment findById(Long id) {
    return findById(id);
  }
}
