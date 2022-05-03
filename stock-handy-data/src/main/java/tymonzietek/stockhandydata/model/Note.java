package tymonzietek.stockhandydata.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Note extends BaseEntity{
private String name;

@Lob
private String description;
private LocalDateTime createdAt;
}
