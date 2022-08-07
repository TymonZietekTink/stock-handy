package tymonzietek.stockhandy.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static tymonzietek.stockhandy.Stubs.generateFinancialInstitution;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.service.FinancialInstitutionService;

class FinancialInstitutionControllerTest {

  FinancialInstitutionService financialInstitutionService;
  FinancialInstitutionController financialInstitutionController;
  MockMvc financialInstitutionControllerMock;

  private static final String NAME = "Company1";

  @BeforeEach
  public void setup() {
    financialInstitutionService = mock(FinancialInstitutionService.class);
    ObjectMapper objectMapper = buildObjectMapper();
    financialInstitutionController = new FinancialInstitutionController(financialInstitutionService,
        objectMapper);
    financialInstitutionControllerMock = MockMvcBuilders.standaloneSetup(
        financialInstitutionController).build();
  }

  ObjectMapper buildObjectMapper() {
    JavaTimeModule module = new JavaTimeModule();
    return new ObjectMapper().registerModule(module);
  }

  @Test
  void getInvestments_should_return_set_investments() throws Exception {
    //given
    FinancialInstitution financialInstitution1 = generateFinancialInstitution(1);
    FinancialInstitution financialInstitution2 = generateFinancialInstitution(2);
    when(financialInstitutionService.findAll()).thenReturn(
        Set.of(financialInstitution1, financialInstitution2));

    //when
    financialInstitutionControllerMock
        .perform(MockMvcRequestBuilders.get("/financial-institutions"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.financialInstitutions.length()").value(2));

    //then
    verify(financialInstitutionService).findAll();
  }

  @Test
  void getInvestment_should_return_investment() throws Exception {
    //given
    FinancialInstitution financialInstitution = generateFinancialInstitution(1);
    when(financialInstitutionService.findById(anyLong())).thenReturn(financialInstitution);

    //when
    financialInstitutionControllerMock
        .perform(MockMvcRequestBuilders.get("/financial-institutions/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value(NAME));

    //then
    verify(financialInstitutionService).findById(anyLong());
  }

  @Test
  void saveInvestment_should_store_investment() throws Exception {
    //given
    FinancialInstitution financialInstitution = generateFinancialInstitution(1);

    //when
    financialInstitutionControllerMock
        .perform(MockMvcRequestBuilders.post("/financial-institutions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(buildObjectMapper().writeValueAsString(financialInstitution))
            .characterEncoding("utf-8"))
        .andExpect(status().isOk());

    //then
    verify(financialInstitutionService).save(financialInstitution);
  }
}