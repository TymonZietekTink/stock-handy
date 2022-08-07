package tymonzietek.stockhandy.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import tymonzietek.stockhandy.model.FinancialInstitution;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Note;
import tymonzietek.stockhandy.model.Transaction;
import tymonzietek.stockhandy.model.enums.Currency;
import tymonzietek.stockhandy.model.enums.Market;
import tymonzietek.stockhandy.model.enums.Status;

public class Stubs {

  public static Transaction generateTransaction(Investment investment, LocalDateTime closedAt) {
    return Transaction.builder()
        .additionalCost(BigDecimal.ONE)
        .closedAt(closedAt)
        .amount(BigDecimal.valueOf(10))
        .currency(Currency.PLN)
        .build();
  }

  public static Investment generateInvestment(FinancialInstitution financialInstitution,
      Status status, BigDecimal returnValue) {
    return Investment.builder()
        .financialInstitution(financialInstitution)
        .name("INVESTMENT1")
        .returnValue(returnValue)
        .status(status)
        .build();
  }

  public static Note generateNotes() {
    return Note.builder()
        .createdAt(LocalDateTime.of(LocalDate.of(1990, 1, 2), LocalTime.of(10, 02)))
        .description("DESCRIPTION1")
        .title("TITLE1")
        .build();
  }

  public static FinancialInstitution generateFinancialInstitution() {
    return FinancialInstitution
        .builder()
        .name("Company1")
        .markets(Set.of(Market.PL))
        .symbol("CMP1")
        .build();
  }
}
