package tymonzietek.stockhandy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Note;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.model.enums.Currency;
import tymonzietek.stockhandy.model.enums.Market;
import tymonzietek.stockhandy.model.enums.OperationType;
import tymonzietek.stockhandy.model.enums.Status;

public class Stubs {
  public static final String NAME = "dummyName";

  public static Transaction generateTransaction(LocalDateTime closedAt, long id) {
    return Transaction.builder()
        .id(id)
        .name(NAME)
        .additionalCost(BigDecimal.ONE)
        .closedAt(closedAt)
        .amount(BigDecimal.valueOf(10))
        .currency(Currency.PLN)
        .openedAt(LocalDateTime.of(LocalDate.of(2022,2,3),LocalTime.of(10,54)))
        .operationType(OperationType.BUY)
        .build();
  }

  public static Investment generateInvestment(FinancialInstitution financialInstitution,
      Status status, BigDecimal returnValue, long id) {
    return Investment.builder()
        .id(id)
        .financialInstitution(financialInstitution)
        .name("INVESTMENT1")
        .returnValue(returnValue)
        .status(status)
        .build();
  }

  public static Note generateNotes(long id) {
    return Note.builder()
        .id(id)
        .createdAt(LocalDateTime.of(LocalDate.of(1990, 1, 2), LocalTime.of(10, 02)))
        .description("DESCRIPTION1")
        .title("TITLE1")
        .build();
  }

  public static FinancialInstitution generateFinancialInstitution(long id) {
    return FinancialInstitution
        .builder()
        .id(id)
        .name("Company1")
        .markets(Set.of(Market.PL))
        .symbol("CMP1")
        .build();
  }
}
