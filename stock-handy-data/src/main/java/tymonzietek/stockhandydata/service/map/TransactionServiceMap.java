package tymonzietek.stockhandydata.service.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import tymonzietek.stockhandydata.model.Transaction;
import tymonzietek.stockhandydata.service.AbstractMapService;
import tymonzietek.stockhandydata.service.TransactionService;

@Service
public class TransactionServiceMap extends AbstractMapService<Transaction, Long> implements
    TransactionService {

  @Override
  public Transaction save(Transaction object) {
    return super.save(object.getId(),object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Set<Transaction> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Transaction object) {
    super.delete(object);
  }

  @Override
  public Transaction findById(Long id) {
    return findById(id);
  }
}
