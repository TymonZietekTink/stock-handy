package tymonzietek.stockhandy.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.service.InvestmentService;
import tymonzietek.stockhandy.service.TransactionService;

@RestController
@RequiredArgsConstructor
public class InvestmentController {
  private final InvestmentService investmentService;
  private final TransactionService transactionService;
  private final ObjectMapper objectMapper;

  @GetMapping("/investments")
  public String getInvestments() throws JsonProcessingException {
    Set<Investment> investments = investmentService.findAll();
    return objectMapper.writer().withRootName("investments").writeValueAsString(investments);
  }

  @GetMapping("/investments/{id}")
  public Investment getInvestment(@PathVariable long id){
    return investmentService.findById(id);
  }

  @PostMapping("/investments")
  public Investment saveInvestment(@RequestBody Investment investment){
    return investmentService.save(investment);
  }
}
