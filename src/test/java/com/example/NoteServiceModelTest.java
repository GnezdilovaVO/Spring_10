package com.example;

import com.example.ex_3_hw.model.Note;
import com.example.ex_3_hw.repository.NoteRepository;
import com.example.ex_3_hw.service.NoteService;
import com.example.ex_3_hw.service.impl.NoteServiceImplement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoteServiceModelTest {
    @InjectMocks
    private NoteServiceImplement service;
    @Mock
    private NoteRepository repository;

    @Test
    public void createNoteTest(){
//        Блок предусловия
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Note");
        note.setContent("test");

        given(repository.save(note)).willReturn(note);

//        Блок действия (или вызова метода)
        Note reserve = service.createNote(note);

//        Блок проверки
//        verify(repository).save(new Note(1, "Note", "test", LocalDateTime.now());
        assertEquals(1L, reserve.getId());
        assertEquals("Note", reserve.getTitle());
        assertEquals("test", reserve.getContent());

    }
    @Test
    public void getAllNotesTest(){
//        Блок предусловия
        List<Note> notes = new ArrayList<>();
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Note");
        note1.setContent("test");

        notes.add(note1);


        given(repository.findAll()).willReturn(notes);

//        Блок действия (или вызова метода)
        List<Note> notes1 = service.getAllNotes();

//        Блок проверки
//        verify(repository).save(new Note(1, "Note", "test", LocalDateTime.now());
        assertEquals(1, notes1.size());
        assertEquals("Note", notes.get(0).getTitle());
        assertEquals("test", notes.get(0).getContent());

    }
}
