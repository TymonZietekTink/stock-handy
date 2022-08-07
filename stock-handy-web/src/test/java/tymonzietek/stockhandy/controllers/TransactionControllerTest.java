package tymonzietek.stockhandy.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static tymonzietek.stockhandy.Stubs.NAME;
import static tymonzietek.stockhandy.Stubs.generateTransaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.service.TransactionService;

@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {
  TransactionService transactionService;
  TransactionController transactionController;
  MockMvc transactionControllerMockMvc;

  @BeforeEach
  public void setup(){
    transactionService = mock(TransactionService.class);
    ObjectMapper objectMapper = buildObjectMapper();
    transactionController = new TransactionController(transactionService,objectMapper);
    transactionControllerMockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
  }

  ObjectMapper buildObjectMapper(){
    JavaTimeModule module = new JavaTimeModule();
    return new ObjectMapper().registerModule(module);
  }

  @Test
  void listTransactions_should_return_list_transactions() throws Exception {
    //given
    LocalDateTime dummyLocalDateTime = LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);
    Transaction transaction1 = generateTransaction(dummyLocalDateTime,1);
    Transaction transaction2 = generateTransaction(dummyLocalDateTime,2);
    when(transactionService.findAll()).thenReturn(Set.of(transaction1,transaction2));


    //when
    transactionControllerMockMvc
        .perform(MockMvcRequestBuilders.get("/transactions"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.transactions.length()").value(2));

    //then
    verify(transactionService).findAll();
  }

  @Test
  void getTransaction_should_return_transaction() throws Exception {
    //given
    LocalDateTime dummyLocalDateTime = LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);
    Transaction transaction = generateTransaction(dummyLocalDateTime,1);
    when(transactionService.findById(anyLong())).thenReturn(transaction);

    //when
    transactionControllerMockMvc
        .perform(MockMvcRequestBuilders.get("/transactions/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value(NAME));

    //then
    verify(transactionService).findById(anyLong());
  }

  @Test
  void saveTransaction_should_store_transaction() throws Exception {
    //given
    LocalDateTime dummyLocalDateTime = LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);
    Transaction transaction = generateTransaction(dummyLocalDateTime,1);

    //when
    transactionControllerMockMvc
        .perform(MockMvcRequestBuilders.post("/transactions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(buildObjectMapper().writeValueAsString(transaction))
            .characterEncoding("utf-8"))
        .andExpect(status().isOk());

    //then
    verify(transactionService).save(transaction);
  }
}