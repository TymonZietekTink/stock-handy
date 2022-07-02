package tymonzietek.stockhandy.controllers;

import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.service.TransactionService;

@RestController
public class TransactionController {

  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @GetMapping(value = "/transactions")
  public Set<Transaction> listTransactions() {
    return transactionService.findAll();
  }

}
