package tymonzietek.stockhandydata.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import tymonzietek.stockhandy.model.enums.Currency;
import tymonzietek.stockhandy.model.enums.OperationType;

public class Transaction {
  private float id;
  private String name;
  private LocalDateTime openedAt;
  private LocalDateTime closedAt;
  private OperationType operationType;
  private BigDecimal amount;
  private Currency currency;
  private BigDecimal additionalCost;
  private BigDecimal income;
  private String notes;
  private Investment investment;
}