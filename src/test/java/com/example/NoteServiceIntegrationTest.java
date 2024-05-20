package com.example;

import com.example.ex_3_hw.model.Note;
import com.example.ex_3_hw.repository.NoteRepository;
import com.example.ex_3_hw.service.impl.NoteServiceImplement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NoteServiceIntegrationTest {
    @Autowired
    private NoteServiceImplement service;
    @MockBean
    private NoteRepository repository;
    @Test
    public void createNoteTest(){
//        Блок предусловия
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Note");
        note.setContent("test");
        note.setDateTimeCreate(LocalDateTime.now());

        given(repository.save(note)).willReturn((Note) note);

//        Блок действия (или вызова метода)
        service.createNote(note);

//        Блок проверки
        verify(repository).save(note);
//        assertEquals(1L, reserve.getId());
//        assertEquals("Note", reserve.getTitle());
//        assertEquals("test", reserve.getContent());

    }
    @Test
    public void getAllNotesTest(){
//        Блок предусловия

        Note note = new Note();
        note.setId(1L);
        note.setTitle("Note");
        note.setContent("test");
        List<Note> notes = new ArrayList<>();
        notes.add(note);


        when(repository.findById(1L)).thenReturn(Optional.of(note));

//        Блок действия (или вызова метода)
        List<Note> notes1 = service.getAllNotes();

//        Блок проверки

        assertEquals(notes1, notes);

    }


}
