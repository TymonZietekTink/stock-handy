package tymonzietek.stockhandy.model;

import java.util.EnumSet;
import java.util.List;
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
import lombok.Data;
import tymonzietek.stockhandy.model.enums.Market;

@Data
@Entity
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
}
