package tymonzietek.stockhandy.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import tymonzietek.stockhandy.model.enums.Currency;
import tymonzietek.stockhandy.model.enums.OperationType;


@Data
@Entity
public class Transaction extends BaseEntity {
  private String name;
  private LocalDateTime openedAt;
  private LocalDateTime closedAt;

  @Enumerated(value = EnumType.STRING)
  private OperationType operationType;
  private BigDecimal amount;

  @Enumerated(value = EnumType.STRING)
  private Currency currency;
  private BigDecimal additionalCost;
  private BigDecimal income;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Note> note;

  @ManyToOne
  private Investment investment;
}
