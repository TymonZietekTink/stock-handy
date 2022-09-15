package tymonzietek.stockhandy.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static tymonzietek.stockhandy.Stubs.NAME;
import static tymonzietek.stockhandy.Stubs.generateFinancialInstitution;
import static tymonzietek.stockhandy.Stubs.generateInvestment;
import static tymonzietek.stockhandy.Stubs.generateTransaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.model.enums.Status;
import tymonzietek.stockhandy.service.InvestmentService;
import tymonzietek.stockhandy.service.TransactionService;

@ExtendWith(MockitoExtension.class)
class InvestmentControllerTest {
  InvestmentService investmentService;
  InvestmentController investmentController;
  MockMvc investmentControllerMvc;

  private static final String NAME = "INVESTMENT1";

  @BeforeEach
  public void setup(){
    investmentService = mock(InvestmentService.class);
    ObjectMapper objectMapper = buildObjectMapper();
    investmentController = new InvestmentController(investmentService,objectMapper);
    investmentControllerMvc = MockMvcBuilders.standaloneSetup(investmentController).build();
  }

  ObjectMapper buildObjectMapper(){
    JavaTimeModule module = new JavaTimeModule();
    return new ObjectMapper().registerModule(module);
  }

  @Test
  void getInvestments_should_return_set_investments() throws Exception {
    //given
    FinancialInstitution financialInstitution = generateFinancialInstitution(1);
    Investment dummyInvestment1 = generateInvestment(financialInstitution, Status.CREATED, BigDecimal.ONE,1);
    Investment dummyInvestment2 = generateInvestment(financialInstitution, Status.CREATED, BigDecimal.ONE,2);
    when(investmentService.findAll()).thenReturn(Set.of(dummyInvestment1,dummyInvestment2));

    //when
    investmentControllerMvc
        .perform(MockMvcRequestBuilders.get("/investments"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.investments.length()").value(2));

    //then
    verify(investmentService).findAll();
  }

  @Test
  void getInvestment_should_return_investment() throws Exception {
    //given
    FinancialInstitution financialInstitution = generateFinancialInstitution(1);
    Investment dummyInvestment = generateInvestment(financialInstitution, Status.CREATED, BigDecimal.ONE,1);
    when(investmentService.findById(anyLong())).thenReturn(dummyInvestment);

    //when
    investmentControllerMvc
        .perform(MockMvcRequestBuilders.get("/investments/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value(NAME));

    //then
    verify(investmentService).findById(anyLong());
  }

  @Test
  void saveInvestment_should_store_investment() throws Exception {
    //given
    FinancialInstitution financialInstitution = generateFinancialInstitution(1);
    Investment dummyInvestment = generateInvestment(financialInstitution, Status.CREATED, BigDecimal.ONE,1);

    //when
    investmentControllerMvc
        .perform(MockMvcRequestBuilders.post("/investments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(buildObjectMapper().writeValueAsString(dummyInvestment))
            .characterEncoding("utf-8"))
        .andExpect(status().isOk());

    //then
    verify(investmentService).save(dummyInvestment);
  }
}