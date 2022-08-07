package tymonzietek.stockhandy.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.model.enums.Status;
import tymonzietek.stockhandy.repositories.TransactionRepository;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

  @Mock
  TransactionRepository transactionRepository;

  @InjectMocks
  TransactionServiceImpl transactionService;

  @Test
  void findAll() {
    //given
    //when
    transactionService.findAll();

    //then
    verify(transactionRepository).findAll();
  }

  @Test
  void findById() {
    //given
    //when
    transactionService.findById(1L);

    //then
    verify(transactionRepository).findById(1L);
  }

  @Test
  void save() {
    //given
    Transaction transaction = mock(Transaction.class);

    //when
    transactionService.save(transaction);

    //then
    verify(transactionRepository).save(transaction);
  }

  @Test
  void delete() {
    //given
    Transaction transaction = mock(Transaction.class);

    //when
    transactionService.delete(transaction);

    //then
    verify(transactionRepository).delete(transaction);
  }

  @Test
  void deleteById() {
    //given
    Transaction transaction = mock(Transaction.class);

    //when
    transactionService.delete(transaction);

    //then
    verify(transactionRepository).delete(transaction);
  }
}