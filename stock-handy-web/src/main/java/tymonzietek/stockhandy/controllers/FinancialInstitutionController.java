package tymonzietek.stockhandy.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.service.FinancialInstitutionService;

@RestController
@RequiredArgsConstructor
public class FinancialInstitutionController {

  private final FinancialInstitutionService financialInstitutionService;
  private final ObjectMapper objectMapper;

  @GetMapping("/financial-institutions")
  public String getFinancialInstitutions() throws JsonProcessingException {
    Set<FinancialInstitution> financialInstitutions = financialInstitutionService.findAll();
    return objectMapper.writer().withRootName("financialInstitutions")
        .writeValueAsString(financialInstitutions);
  }

  @GetMapping("/financial-institutions/{id}")
  public FinancialInstitution getFinancialInstitution(@PathVariable long id) {
    return financialInstitutionService.findById(id);
  }

  @PostMapping("/financial-institutions")
  public FinancialInstitution getFinancialInstitution(
      @RequestBody FinancialInstitution financialInstitution) {
    return financialInstitutionService.save(financialInstitution);
  }
}
