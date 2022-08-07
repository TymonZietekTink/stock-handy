package tymonzietek.stockhandy.model;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tymonzietek.stockhandy.model.enums.Market;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FinancialInstitution extends BaseEntity {
  private String name;
  private String symbol;

  @ElementCollection(targetClass = Market.class)
  @Column(name = "markets", nullable = false)
  @CollectionTable(name="financial_institution_market")
  @Enumerated(EnumType.STRING)
  private Set<Market> markets;

  @OneToMany(mappedBy = "financialInstitution")
  private List<Investment> investments;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Note> note;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FinancialInstitution)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    FinancialInstitution that = (FinancialInstitution) o;
    return name.equals(that.name) && Objects.equals(symbol, that.symbol)
        && Objects.equals(markets, that.markets) && Objects.equals(investments,
        that.investments) && Objects.equals(note, that.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, symbol, markets, investments, note);
  }
}
