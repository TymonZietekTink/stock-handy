package tymonzietek.stockhandy.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tymonzietek.stockhandy.Stubs;
import tymonzietek.stockhandy.model.Note;
import tymonzietek.stockhandy.service.NoteService;

public class NoteControllerTest {
  NoteService noteService;
  NoteController noteController;
  MockMvc noteControllerMockMvc;
  private static final String TITLE = "TITLE1";
  private static final String DESCRIPTION = "DESCRIPTION1";

  @BeforeEach
  public void setup(){
    noteService = mock(NoteService.class);
    noteController = new NoteController(noteService, buildObjectMapper());
    noteControllerMockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
  }

  ObjectMapper buildObjectMapper(){
    JavaTimeModule module = new JavaTimeModule();
    return new ObjectMapper().registerModule(module);
  }

  @Test
  void getNotes_should_return_notes() throws Exception {
    //given
    Note note1 = Stubs.generateNotes(1l);
    Note note2 = Stubs.generateNotes(2l);
    when(noteService.findAll()).thenReturn(Set.of(note1,note2));

    //when
    noteControllerMockMvc
        .perform(MockMvcRequestBuilders.get("/notes"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.notes.length()").value(2));

    //then
    verify(noteService).findAll();
  }

  @Test
  void getNote_should_get_note() throws Exception {
    //given
    Note note = Stubs.generateNotes(1l);
    when(noteService.findById(anyLong())).thenReturn(note);

    //when
    noteControllerMockMvc
        .perform(MockMvcRequestBuilders.get("/notes/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.title").value(TITLE))
        .andExpect(jsonPath("$.description").value(DESCRIPTION));

    //then
    verify(noteService).findById(anyLong());
  }

  @Test
  void saveNote_should_store_note() throws Exception {
    //given
    Note note = Stubs.generateNotes(1l);

    //when
    noteControllerMockMvc
        .perform(MockMvcRequestBuilders.post("/notes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(buildObjectMapper().writeValueAsString(note))
            .characterEncoding("utf-8"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk());

    //then
    verify(noteService).save(note);
  }
}
