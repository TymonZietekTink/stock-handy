package tymonzietek.stockhandy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import tymonzietek.stockhandy.model.BaseEntity;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Note;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.repositories.TransactionRepository;
import tymonzietek.stockhandy.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
  private final TransactionRepository transactionRepository;

  public TransactionServiceImpl(
      TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Override
  public Set<Transaction> findAll() {
    Set<Transaction> set = new HashSet<>();
    transactionRepository.findAll().forEach(set::add);
    return set;
  }

  @Override
  public Transaction findById(Long aLong) {
    return transactionRepository.findById(aLong).orElse(null);
  }

  @Override
  public Transaction save(Transaction object) {
    return transactionRepository.save(object);
  }

  @Override
  public void delete(Transaction object) {
    transactionRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    transactionRepository.deleteById(aLong);
  }
}
