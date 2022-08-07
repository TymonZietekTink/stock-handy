package tymonzietek.stockhandy.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.repositories.TransactionRepository;
import tymonzietek.stockhandy.service.InvestmentService;
import tymonzietek.stockhandy.service.TransactionService;

@RestController
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionService transactionService;
  private final ObjectMapper objectMapper;

  @GetMapping("/transactions")
  public String listTransactions() throws JsonProcessingException {
    Set<Transaction> transactions = transactionService.findAll();
    return objectMapper.writer()
        .withRootName("transactions")
        .writeValueAsString(transactions);
  }

  @GetMapping("/transactions/{id}")
  public Transaction getTransaction(@PathVariable long id) {
    return transactionService.findById(id);
  }

  @PostMapping("/transactions")
  public Transaction saveTransaction(@RequestBody Transaction transaction) {
    return transactionService.save(transaction);
  }
}
