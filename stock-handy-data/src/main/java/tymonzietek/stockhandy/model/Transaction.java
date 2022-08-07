package tymonzietek.stockhandy.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Lazy;
import tymonzietek.stockhandy.model.enums.Currency;
import tymonzietek.stockhandy.model.enums.OperationType;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
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

  @OneToMany(cascade = CascadeType.ALL)
  private List<Note> note;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Transaction)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Transaction that = (Transaction) o;
    return openedAt.equals(that.openedAt)
        && Objects.equals(closedAt, that.closedAt) && operationType == that.operationType
        && amount.equals(that.amount) && currency == that.currency && Objects.equals(
        additionalCost, that.additionalCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), openedAt, closedAt, operationType, amount, currency,
        additionalCost, note);
  }
}
