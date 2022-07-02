package tymonzietek.stockhandy.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import tymonzietek.stockhandy.model.Investment;
import tymonzietek.stockhandy.model.Note;
import tymonzietek.stockhandy.repositories.NoteRepository;
import tymonzietek.stockhandy.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
  private final NoteRepository noteRepository;

  public NoteServiceImpl(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @Override
  public Set<Note> findAll() {
    Set<Note> set = new HashSet<>();
    noteRepository.findAll().forEach(set::add);
    return set;
  }

  @Override
  public Note findById(Long aLong) {
    return noteRepository.getById(aLong);
  }

  @Override
  public Note save(Note object) {
    return noteRepository.save(object);
  }

  @Override
  public void delete(Note object) {
    noteRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    noteRepository.deleteById(aLong);
  }
}
