package tymonzietek.stockhandydata.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import org.yaml.snakeyaml.error.Mark;
import tymonzietek.stockhandydata.model.enums.Market;
import tymonzietek.stockhandydata.model.enums.Status;

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
  private List<Note> notes;
}
