package tymonzietek.stockhandy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Note extends BaseEntity {

  private String title;

  @Lob
  private String description;
  private LocalDateTime createdAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Note)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Note note = (Note) o;
    return title.equals(note.title) && description.equals(note.description) && createdAt.equals(
        note.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), title, description, createdAt);
  }
}
