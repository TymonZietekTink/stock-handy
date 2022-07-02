package tymonzietek.stockhandy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
