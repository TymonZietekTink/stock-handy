package tymonzietek.stockhandy.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tymonzietek.stockhandy.model.enums.Status;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Investment extends BaseEntity {
  private String name;

  @Enumerated(value = EnumType.STRING)
  private Status status;
  private BigDecimal returnValue;

  @ManyToOne
  private FinancialInstitution financialInstitution;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Note> note;

  @OneToMany
  private List<Transaction> transactions;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Investment)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Investment that = (Investment) o;
    return name.equals(that.name) && status == that.status && returnValue.equals(that.returnValue)
        && financialInstitution.equals(that.financialInstitution) && Objects.equals(note,
        that.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, status, returnValue, financialInstitution, note);
  }
}
