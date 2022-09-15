package tymonzietek.stockhandy.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tymonzietek.stockhandy.exceptions.NotFoundException;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.service.InvestmentService;

@Slf4j
@RestController
@RequiredArgsConstructor
@ControllerAdvice
public class InvestmentController {
  private final InvestmentService investmentService;
  private final ObjectMapper objectMapper;

  @GetMapping("/investments")
  public String getInvestments() throws JsonProcessingException {
    Set<Investment> investments = investmentService.findAll();
    return objectMapper.writer().withRootName("investments").writeValueAsString(investments);
  }

  @GetMapping("/investments/{id}")
  public Investment getInvestment(@PathVariable long id){
    Investment investment = investmentService.findById(id);
    if(investment==null){
      throw new NotFoundException();
    }
    return investment;
  }

  @PostMapping("/investments")
  public Investment saveInvestment(@RequestBody Investment investment){
    return investmentService.save(investment);
  }
}
