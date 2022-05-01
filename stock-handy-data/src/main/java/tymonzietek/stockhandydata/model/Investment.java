package tymonzietek.stockhandydata.model;

import java.math.BigDecimal;
import java.util.List;
import tymonzietek.stockhandy.model.enums.Status;

public class Investment {
  private float id;
  private String name;
  private Status status;
  private BigDecimal result;
  private List<String> notes;
}
