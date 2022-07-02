package tymonzietek.stockhandy.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import tymonzietek.stockhandy.model.enums.Status;

@Data
@Entity
public class Investment extends BaseEntity {
  private String name;

  @Enumerated(value = EnumType.STRING)
  private Status status;
  private BigDecimal result;

  @ManyToOne
  private FinancialInstitution financialInstitution;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Note> note;
}
