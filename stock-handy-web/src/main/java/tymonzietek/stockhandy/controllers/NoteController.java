package tymonzietek.stockhandy.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tymonzietek.stockhandy.model.Note;
import tymonzietek.stockhandy.service.NoteService;

@RestController
@RequiredArgsConstructor
public class NoteController {

  private final NoteService noteService;
  private final ObjectMapper objectMapper;

  @GetMapping("/notes")
  public String getNotes() throws JsonProcessingException {
    Set<Note> notes = noteService.findAll();
    return objectMapper.writer()
        .withRootName("notes")
        .writeValueAsString(notes);
  }

  @GetMapping("/notes/{id}")
  public Note getNote(@PathVariable long id) {
    return noteService.findById(id);
  }

  @PostMapping("/notes")
  public Note saveNote(@RequestBody Note note) {
    return noteService.save(note);
  }
}
